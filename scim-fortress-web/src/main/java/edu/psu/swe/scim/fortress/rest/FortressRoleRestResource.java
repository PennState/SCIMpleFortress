package edu.psu.swe.scim.fortress.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import edu.psu.swe.scim.fortress.data.FortressRole;
import edu.psu.swe.scim.server.provider.Provider;
import edu.psu.swe.scim.server.provider.ProviderRegistry;
import edu.psu.swe.scim.server.rest.BaseResourceTypeResourceImpl;

@Path("Roles")
public class FortressRoleRestResource extends BaseResourceTypeResourceImpl<FortressRole> {
  
  @Inject
  ProviderRegistry providerRegistry;

  @Override
  public Provider<FortressRole> getProvider() {
    return providerRegistry.getProvider(FortressRole.class);
  }

}
