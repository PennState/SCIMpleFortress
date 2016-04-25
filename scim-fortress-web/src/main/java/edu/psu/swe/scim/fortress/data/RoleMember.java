package edu.psu.swe.scim.fortress.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import edu.psu.swe.scim.spec.annotation.ScimAttribute;
import edu.psu.swe.scim.spec.schema.Schema.Attribute.Type;
import lombok.Data;

@XmlType
@Data
public class RoleMember {

  @XmlElement
  @ScimAttribute(description="The userId that is associated with UserRole.  UserId is required attribute and must be set on all UserRole assignment operations.")
  private String userid;
  
  @XmlElement
  @ScimAttribute(description="The Role name required attribute of the UserRole object")
  private String name;
  
  @XmlElement
  @ScimAttribute(type=Type.INTEGER, description="The integer timeout that contains max time (in seconds) that entity may remain inactive. This attribute is optional but if set will be validated for reasonableness.")
  private Integer timeout;
  
  @XmlElement
  @ScimAttribute(description="The begin time of day entity is allowed to be activated in system.  The format is military time - HHMM, i.e. 0800 (8:00 am) or 1700 (5:00 p.m.). This attribute is optional but if set will be validated for reasonableness.")
  private String beginTime;
  
  @XmlElement
  @ScimAttribute(description="The end time of day entity is allowed to be activated in system.  The format is military time - HHMM, i.e. 0000 (12:00 am) or 2359 (11:59 p.m.). This attribute is optional but if set will be validated for reasonableness.")
  private String endTime;
  
  @XmlElement
  @ScimAttribute(description="The beginDate when entity is allowed to be activated in system.  The format is - YYYYMMDD, i.e. 20100101 (January 1, 2001). This attribute is optional but if set will be validated for reasonableness.")
  private String beginDate;
  
  @XmlElement
  @ScimAttribute(description="The end date when entity is not allowed to be activated in system.  The format is - YYYYMMDD, i.e. 20100101 (January 1. 2010). This attribute is optional but if set will be validated for reasonableness.")
  private String endDate;
  
  @XmlElement
  @ScimAttribute(description="Set the begin lock date when entity is temporarily not allowed to be activated in system.  The format is - YYYYMMDD, 20100101 (January 1. 2010).  This attribute is optional but if set will be validated for reasonableness.")
  private String beginLockDate;
  
  @XmlElement
  @ScimAttribute(description="Set the end lock date when entity is allowed to be activated in system once again.  The format is - YYYYMMDD, i.e. 20100101 (January 1. 2010).  This attribute is optional but if set will be validated for reasonableness.")
  private String endLockDate;
  
  @XmlElement
  @ScimAttribute(description="the daymask that indicates what days of week entity is allowed to be activated in system.  The format is 1234567, i.e. 23456 (Monday, Tuesday, Wednesday, Thursday, Friday). This attribute is optional but if set will be validated for reasonableness.")
  private String dayMask;
}
