package edu.psu.swe.scim.fortress.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import edu.psu.swe.scim.spec.annotation.ScimResourceType;
import edu.psu.swe.scim.spec.resources.ScimResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@ScimResourceType(id = FortressRole.SCHEMA_URI, name = FortressRole.RESOURCE_NAME, schema = FortressRole.SCHEMA_URI, description = "Resource for representing Fortress Roles", endpoint = "/Roles")
@Data
@EqualsAndHashCode(callSuper=true)
public class FortressRole extends ScimResource {
  public static final String SCHEMA_URI = "edu:psu:fortress:params:scim:schemas:Role";
  public static final String RESOURCE_NAME = "FortressRole";
  
  public FortressRole() {
    super(SCHEMA_URI);
  }

  @Override
  public String getResourceType() {
    return RESOURCE_NAME;
  }
}
