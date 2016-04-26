package edu.psu.swe.scim.fortress.util;

import org.apache.directory.fortress.core.model.Role;

import edu.psu.swe.scim.fortress.data.FortressRole;

public class Converter {
	
  public static FortressRole convertFortressRoleToScimFortressRole(Role role){
	  FortressRole fortressRole = new FortressRole();
	  fortressRole.setName(role.getName());
	  fortressRole.setId(role.getName());
	  fortressRole.setBeginDate(role.getBeginDate());
	  fortressRole.setBeginLockDate(role.getBeginLockDate());
	  fortressRole.setBeginTime(role.getBeginTime());
	  fortressRole.setChildList(role.getChildren());
	  fortressRole.setDayMask(role.getDayMask());
	  fortressRole.setDescription(role.getDescription());
	  fortressRole.setEndDate(role.getEndDate());
	  fortressRole.setEndLockDate(role.getEndLockDate());
	  fortressRole.setEndTime(role.getEndTime());
	  fortressRole.setModCode(role.getModCode());
	  fortressRole.setModId(role.getModId());
	  fortressRole.setParentList(role.getParents());
	  fortressRole.setTimeout(role.getTimeout());
	  
	  return fortressRole;
  }
  
  public static Role convertScimFortressRoleToFortressRole(FortressRole fortressRole){
	  Role role = new Role();
	  role.setName(fortressRole.getName());
	  role.setBeginDate(fortressRole.getBeginDate());
	  role.setBeginLockDate(fortressRole.getBeginLockDate());
	  role.setBeginTime(fortressRole.getBeginTime());
	  role.setChildren(fortressRole.getChildList());
	  role.setDayMask(fortressRole.getDayMask());
	  role.setDescription(fortressRole.getDescription());
	  role.setEndDate(fortressRole.getEndDate());
	  role.setEndLockDate(fortressRole.getEndLockDate());
	  role.setEndTime(fortressRole.getEndTime());
	  role.setParents(fortressRole.getParentList());
	  role.setTimeout(fortressRole.getTimeout());
	  
	  return role;
  }
  
}
