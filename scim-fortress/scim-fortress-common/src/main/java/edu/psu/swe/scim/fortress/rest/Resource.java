package edu.psu.swe.scim.fortress.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public interface Resource {
  
  @GET
  Response getDemo();
  
}
