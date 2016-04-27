package edu.psu.swe.scim.fortress.producer;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import org.apache.directory.fortress.core.AccessMgr;
import org.apache.directory.fortress.core.AccessMgrFactory;
import org.apache.directory.fortress.core.AdminMgr;
import org.apache.directory.fortress.core.AdminMgrFactory;
import org.apache.directory.fortress.core.DelAccessMgr;
import org.apache.directory.fortress.core.DelAccessMgrFactory;
import org.apache.directory.fortress.core.DelAdminMgr;
import org.apache.directory.fortress.core.DelAdminMgrFactory;
import org.apache.directory.fortress.core.DelReviewMgr;
import org.apache.directory.fortress.core.DelReviewMgrFactory;
import org.apache.directory.fortress.core.ReviewMgr;
import org.apache.directory.fortress.core.ReviewMgrFactory;
import org.apache.directory.fortress.core.SecurityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FortressManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(FortressManagerProducer.class);

	
	@Produces @SessionScoped
	public DelAdminMgr createDelAdminManager() throws SecurityException {
		DelAdminMgr delAdminMgr = DelAdminMgrFactory.createInstance();	
		
		return delAdminMgr;
	}
			
	@Produces @SessionScoped
	public DelReviewMgr createDelReviewManager() throws SecurityException{
		DelReviewMgr delReviewMgr = DelReviewMgrFactory.createInstance();	
		
		return delReviewMgr;
	}
	
	@Produces @SessionScoped
	public AdminMgr createAdminManager() throws SecurityException{
		AdminMgr adminMgr = AdminMgrFactory.createInstance();	

		return adminMgr;
	}
		
	@Produces @SessionScoped
	public ReviewMgr createReviewManager() throws SecurityException{
		ReviewMgr reviewMgr = ReviewMgrFactory.createInstance();
		
		return reviewMgr;
	}
	
	@Produces @SessionScoped
	public AccessMgr createAccessManager() throws SecurityException{
		AccessMgr accessMgr = AccessMgrFactory.createInstance();	
		
		return accessMgr;
	}
	
	@Produces @SessionScoped
	public DelAccessMgr createDelAccessManager() throws SecurityException{
		DelAccessMgr delAccessMgr = DelAccessMgrFactory.createInstance();	
		
		return delAccessMgr;
	}
	
}
