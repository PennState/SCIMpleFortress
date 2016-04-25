package edu.psu.swe.scim.fortress.services;

import java.util.List;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import edu.psu.swe.scim.spec.resources.ScimGroup;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class ScimFortressGroupProvider implements Provider<ScimGroup> {
  
  @Override
  public ScimGroup create(ScimGroup resource) throws UnableToCreateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ScimGroup update(ScimGroup resource) throws UnableToUpdateResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ScimGroup get(String id) throws UnableToRetrieveResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ScimGroup> find(Filter filter, PageRequest pageRequest, SortRequest sortRequest) throws UnableToRetrieveResourceException {
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
