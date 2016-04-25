package edu.psu.swe.scim.fortress.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import lombok.extern.slf4j.Slf4j;

import org.apache.directory.fortress.core.AdminMgr;
import org.apache.directory.fortress.core.ReviewMgr;
import org.apache.directory.fortress.core.SecurityException;
import org.apache.directory.fortress.core.model.User;

import edu.psu.swe.scim.server.exception.UnableToCreateResourceException;
import edu.psu.swe.scim.server.exception.UnableToDeleteResourceException;
import edu.psu.swe.scim.server.exception.UnableToRetrieveExtensionsException;
import edu.psu.swe.scim.server.exception.UnableToRetrieveResourceException;
import edu.psu.swe.scim.server.exception.UnableToUpdateResourceException;
import edu.psu.swe.scim.server.provider.Provider;
import edu.psu.swe.scim.spec.protocol.search.Filter;
import edu.psu.swe.scim.spec.protocol.search.PageRequest;
import edu.psu.swe.scim.spec.protocol.search.SortRequest;
import edu.psu.swe.scim.spec.resources.Role;
import edu.psu.swe.scim.spec.resources.ScimExtension;
import edu.psu.swe.scim.spec.resources.ScimUser;

@Slf4j
public class ScimFortressUserProvider implements Provider<ScimUser> {
  
  @Inject
  private AdminMgr adminMgr_;
  
  @Inject
  private ReviewMgr reviewMgr_;
	
  @Override
  public ScimUser create(ScimUser resource) throws UnableToCreateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ScimUser update(ScimUser resource) throws UnableToUpdateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  
  
  @Override
  public ScimUser get(String id) throws UnableToRetrieveResourceException {
    User user;
	try {
		user = reviewMgr_.readUser(new User(id));
	} catch (SecurityException e) {
		throw new UnableToRetrieveResourceException(Status.INTERNAL_SERVER_ERROR, "Security exception retreiving resource", e);
	}
    
    ScimUser scimUser = new ScimUser();
    scimUser.setDisplayName(user.getDisplayName());
    scimUser.setId(user.getUserId());
    scimUser.setRoles(user.getRoles().stream().map(r -> {
    	Role role = new Role();
    	role.setValue(r.getName());
    	return role;
    }).collect(Collectors.toList()));
    
    return scimUser;
  }

  @Override
  public List<ScimUser> find(Filter filter, PageRequest pageRequest, SortRequest sortRequest) throws UnableToRetrieveResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(String id) throws UnableToDeleteResourceException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Class<? extends ScimExtension>> getExtensionList() throws UnableToRetrieveExtensionsException {
    // TODO Auto-generated method stub
    return null;
  }
}
