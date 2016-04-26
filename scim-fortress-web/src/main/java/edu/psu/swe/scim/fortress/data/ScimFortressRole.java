package edu.psu.swe.scim.fortress.data;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.psu.swe.scim.spec.annotation.ScimAttribute;
import edu.psu.swe.scim.spec.annotation.ScimResourceType;
import edu.psu.swe.scim.spec.resources.ScimResource;
import edu.psu.swe.scim.spec.schema.Schema.Attribute.Type;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@ScimResourceType(id = ScimFortressRole.SCHEMA_URI, name = ScimFortressRole.RESOURCE_NAME, schema = ScimFortressRole.SCHEMA_URI, description = "Resource for representing Fortress Roles", endpoint = "/Roles")
@Data
@EqualsAndHashCode(callSuper=true)
public class ScimFortressRole extends ScimResource {
  public static final String SCHEMA_URI = "edu:psu:fortress:params:scim:schemas:Role";
  public static final String RESOURCE_NAME = "FortressRole";
  
  @XmlElement
  @ScimAttribute(description="The unique name of this role")
  private String name;
  
  @XmlElement
  @ScimAttribute(description="The unique identifier for this role")
  private String id;
  
  @XmlElement
  @ScimAttribute(description="The description of this role")
  private String description;

  @XmlElement(name="parent")
  @ScimAttribute(description="The list of parent roles")
  private Set<String> parentList;
  
  @XmlElement(name="child")
  @ScimAttribute(description="The list of child roles")
  private Set<String> childList;

  @XmlElement
  @ScimAttribute(description="Contains the begin date when Role is allowed to be activated in session.  The format is - YYYYMMDD, i.e. 20100101 (January 1. 2010). This attribute is optional but if set will be validated for reasonableness.")
  private String beginDate;

  @XmlElement
  @ScimAttribute(description="Contains the begin lock date when Role is temporarily not allowed to be activated in session.  The format is - YYMMDD, i.e. 20100101 (January 1. 2010). This attribute is optional but if set will be validated for reasonableness.")
  private String beginLockDate;
  
  @XmlElement
  @ScimAttribute(description="Contains the begin time of day Role is allowed to be activated in session.  The format is military time - HHMM,  i.e. 0800 (8:00 am) or 1700 (5:00 p.m.). This attribute is optional but if set will be validated for reasonableness.")
  private String beginTime;

  @XmlElement
  @ScimAttribute(description="Get the daymask that indicates what days of week Role is allowed to be activated in session.  The format is 1234567, i.e. 23456 (Monday, Tuesday, Wednesday, Thursday, Friday). This attribute is optional but if set will be validated for reasonableness.")
  private String dayMask;
  
  @XmlElement
  @ScimAttribute(description="Contains the end date when Role is allowed to be activated in session.  The format is - YYYYMMDD, i.e. 20101231 (December 31, 2010). This attribute is optional but if set will be validated for reasonableness.")
  private String endDate;

  @XmlElement
  @ScimAttribute(description="Contains the end lock date when Role is allowed to be activated in session once again.  The format is - YYYYMMDD, i.e. 20100101 (January 1. 2010).This attribute is optional but if set will be validated for reasonableness.")
  private String endLockDate;
  
  @XmlElement
  @ScimAttribute(description="Contains the end time of day Role is allowed to be activated in session.  The format is military time - HHMM, i.e. 0000 (12:00 am) or 2359 (11:59 p.m.). This attribute is optional but if set will be validated for reasonableness.")
  private String endTime;

  @XmlElement
  @ScimAttribute(type=Type.INTEGER, description="Return the integer timeout that contains total time (in seconds) that Role may remain inactive in User's session before it is deactivated. This attribute is optional but if set will be validated for reasonableness.")
  private Integer timeout;
  
  @XmlElement
  @ScimAttribute(type=Type.INTEGER, description="Contains the Fortress modification code to be associated with an audit record.  This is the ObjectName.methodName for the Manager API that was called.")
  private String modCode;

  @XmlElement
  @ScimAttribute(type=Type.INTEGER, description="Get the unique ID that is to be associated with a particular audit record in directory.")
  private String modId;
  
  @XmlElement(name="role_member")
  @ScimAttribute(description="The members of this role")
  
  private Set<RoleMember> roleMemberSet;
  public ScimFortressRole() {
    super(SCHEMA_URI);
  }

  @Override
  public String getResourceType() {
    return RESOURCE_NAME;
  }
}
