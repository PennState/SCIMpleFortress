package edu.psu.swe.scim.fortress.producer;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.SessionContext;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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

@Named
@SessionScoped
public class FortressManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(FortressManagerProducer.class);

	private SessionContext context_;
	
	@PostConstruct
	private void init() {
		LOG.debug("initializing security util...");

		try {
			InitialContext ic = new InitialContext();
			context_ = (SessionContext) ic.lookup("java:comp/EJBContext");
		} catch (NamingException ex) {
			LOG.debug("Session context not found...");
		}
	}
	
	@Produces @SessionScoped
	public DelAdminMgr createDelAdminManager() throws SecurityException {
		LOG.debug("Producing DelAdminMgr for user {}", context_.getCallerPrincipal().getName());
		DelAdminMgr delAdminMgr = DelAdminMgrFactory.createInstance();	
		
		return delAdminMgr;
	}
			
	@Produces @SessionScoped
	public DelReviewMgr createDelReviewManager() throws SecurityException{
		LOG.debug("Producing DelReviewMgr for user {}", context_.getCallerPrincipal().getName());
		DelReviewMgr delReviewMgr = DelReviewMgrFactory.createInstance();	
		
		return delReviewMgr;
	}
	
	@Produces @SessionScoped
	public AdminMgr createAdminManager() throws SecurityException{
		LOG.debug("Producing AdminMgr for user {}", context_.getCallerPrincipal().getName());
		AdminMgr adminMgr = AdminMgrFactory.createInstance();	

		return adminMgr;
	}
		
	@Produces @SessionScoped
	public ReviewMgr createReviewManager() throws SecurityException{
		LOG.debug("Producing ReviewMgr for user {}", context_.getCallerPrincipal().getName());		
		ReviewMgr reviewMgr = ReviewMgrFactory.createInstance();
		
		return reviewMgr;
	}
	
	@Produces @SessionScoped
	public AccessMgr createAccessManager() throws SecurityException{
		LOG.debug("Producing AccessMgr for user {}", context_.getCallerPrincipal().getName());
		AccessMgr accessMgr = AccessMgrFactory.createInstance();	
		
		return accessMgr;
	}
	
	@Produces @SessionScoped
	public DelAccessMgr createDelAccessManager() throws SecurityException{
		LOG.debug("Producing DelAccessMgr for user {}", context_.getCallerPrincipal().getName());
		DelAccessMgr delAccessMgr = DelAccessMgrFactory.createInstance();	
		
		return delAccessMgr;
	}
	
}
