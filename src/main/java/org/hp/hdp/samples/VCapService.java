package org.hp.hdp.samples;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;



@Path("/") // in web.xml this maps to /rest/.*
public class VCapService {

	@Context UriInfo uriInfo;
	
	
	private Logger logger;
    
    private Logger getLogger() {
    	
    	if(logger == null) {
    		logger = Logger.getLogger(this.getClass());
    	}
    	
    	return logger;
    	
    }
    
    /**
	 * Note that exception 
	 * @return a list of all data as a list of TableContents objects
	 * @throws Exception
	 */
	@GET
	@Path("vcap_services")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllData() throws Exception {
			    
		String vCapServicesValue = System.getenv("VCAP_SERVICES");
		getLogger().debug("VCAP_SERVICES = "+vCapServicesValue);
		return Response.ok(vCapServicesValue, MediaType.APPLICATION_JSON).build();
				
	}
	
}
