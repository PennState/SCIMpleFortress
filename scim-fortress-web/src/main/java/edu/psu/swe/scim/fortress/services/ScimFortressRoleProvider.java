package edu.psu.swe.scim.fortress.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import lombok.extern.slf4j.Slf4j;

import org.apache.directory.fortress.core.AdminMgr;
import org.apache.directory.fortress.core.FinderException;
import org.apache.directory.fortress.core.ReviewMgr;
import org.apache.directory.fortress.core.SecurityException;
import org.apache.directory.fortress.core.model.Role;

import edu.psu.swe.scim.fortress.data.FortressRole;
import edu.psu.swe.scim.fortress.util.Converter;
import edu.psu.swe.scim.server.exception.UnableToCreateResourceException;
import edu.psu.swe.scim.server.exception.UnableToDeleteResourceException;
import edu.psu.swe.scim.server.exception.UnableToRetrieveExtensionsException;
import edu.psu.swe.scim.server.exception.UnableToRetrieveResourceException;
import edu.psu.swe.scim.server.exception.UnableToUpdateResourceException;
import edu.psu.swe.scim.server.provider.Provider;
import edu.psu.swe.scim.spec.protocol.search.Filter;
import edu.psu.swe.scim.spec.protocol.search.PageRequest;
import edu.psu.swe.scim.spec.protocol.search.SortRequest;
import edu.psu.swe.scim.spec.resources.ScimExtension;

@Slf4j
public class ScimFortressRoleProvider implements Provider<FortressRole> {

  @Inject
  private ReviewMgr reviewMgr_;
  
  @Inject
  private AdminMgr adminMgr_;
	
  @Override
  public FortressRole create(FortressRole resource) throws UnableToCreateResourceException {
	Role role;
	  
    try {
		role = adminMgr_.addRole(Converter.convertScimFortressRoleToFortressRole(resource));
	} catch (SecurityException e) {
		throw new UnableToCreateResourceException(Status.INTERNAL_SERVER_ERROR, "Error updating role " + e.getMessage());
	}
    
    return Converter.convertFortressRoleToScimFortressRole(role);
  }

  @Override
  public FortressRole update(FortressRole resource) throws UnableToUpdateResourceException {
	Role role;
	  
    try {
		role = adminMgr_.updateRole(Converter.convertScimFortressRoleToFortressRole(resource));
	} catch (SecurityException e) {
		throw new UnableToUpdateResourceException(Status.INTERNAL_SERVER_ERROR, "Error updating role " + e.getMessage());
	}
    
    return Converter.convertFortressRoleToScimFortressRole(role);
  }

  @Override
  public FortressRole get(String id) throws UnableToRetrieveResourceException {
	log.debug("Getting role with id {}", id);
	  
    Role role;
	try {
		role = reviewMgr_.readRole(new Role(id));
	} catch (SecurityException e) {
		if(e instanceof FinderException){
			return null;
		}
		throw new UnableToRetrieveResourceException(Status.INTERNAL_SERVER_ERROR, "Security exception retreiving resource", e);
	}
	
    return Converter.convertFortressRoleToScimFortressRole(role);
  }

  @Override
  public List<FortressRole> find(Filter filter, PageRequest pageRequest, SortRequest sortRequest) throws UnableToRetrieveResourceException {
    
    return null;
  }

  @Override
  public void delete(String id) throws UnableToDeleteResourceException {
    try {
		adminMgr_.deleteRole(new Role(id));
	} catch (SecurityException e) {
		throw new UnableToDeleteResourceException(Status.INTERNAL_SERVER_ERROR, "Error deleting role " + e.getMessage());
	}
  }

  @Override
  public List<Class<? extends ScimExtension>> getExtensionList() throws UnableToRetrieveExtensionsException {
    // TODO Auto-generated method stub
    return null;
  }
  
}
