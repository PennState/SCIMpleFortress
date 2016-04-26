package edu.psu.swe.scim.fortress.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import edu.psu.swe.scim.fortress.data.ScimFortressRole;
import edu.psu.swe.scim.server.provider.Provider;
import edu.psu.swe.scim.server.provider.ProviderRegistry;
import edu.psu.swe.scim.server.rest.BaseResourceTypeResourceImpl;

@Path("Roles")
public class FortressRoleRestResource extends BaseResourceTypeResourceImpl<ScimFortressRole> {
  
  @Inject
  ProviderRegistry providerRegistry;

  @Override
  public Provider<ScimFortressRole> getProvider() {
    return providerRegistry.getProvider(ScimFortressRole.class);
  }

}
