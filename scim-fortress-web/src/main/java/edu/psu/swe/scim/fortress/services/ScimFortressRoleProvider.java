package edu.psu.swe.scim.fortress.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import lombok.extern.slf4j.Slf4j;

import org.apache.directory.fortress.core.ReviewMgr;
import org.apache.directory.fortress.core.SecurityException;
import org.apache.directory.fortress.core.model.Role;

import edu.psu.swe.scim.fortress.data.FortressRole;
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
	
  @Override
  public FortressRole create(FortressRole resource) throws UnableToCreateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FortressRole update(FortressRole resource) throws UnableToUpdateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FortressRole get(String id) throws UnableToRetrieveResourceException {
	log.debug("Getting role with id {}", id);
	  
    Role role;
	try {
		role = reviewMgr_.readRole(new Role(id));
	} catch (SecurityException e) {
		throw new UnableToRetrieveResourceException(Status.INTERNAL_SERVER_ERROR, "Security exception retreiving resource", e);
	}
    
	if(role == null){
		throw new UnableToRetrieveResourceException(Status.NOT_FOUND, "Role with id " + id + " was not found.");
	}
	
    FortressRole fortressRole = convertFortressRoleToScimFortressRole(role);
    log.debug("Returning role iwth id {}", fortressRole.getId());
    return fortressRole;
  }

  @Override
  public List<FortressRole> find(Filter filter, PageRequest pageRequest, SortRequest sortRequest) throws UnableToRetrieveResourceException {
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

  private FortressRole convertFortressRoleToScimFortressRole(Role role){
	  FortressRole fortressRole = new FortressRole();
	  fortressRole.setName(role.getName());
	  fortressRole.setId(role.getId());
	  return fortressRole;
  }
  
}
