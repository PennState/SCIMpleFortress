package edu.psu.swe.scim.fortress.services;

import java.util.List;

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

public class ScimFortressRoleProvider implements Provider<FortressRole> {

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
    // TODO Auto-generated method stub
    return null;
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

}
