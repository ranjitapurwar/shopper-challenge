package com.shopper.ws.rest;

import com.shopper.ws.dto.Shopper;
import com.shopper.ws.service.ShopperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.MessageFormat;

/**
 * Created by rpurwar on 5/18/18.
 */

@Controller
@Path("/shopper")
public class ShopperApi {

        private static final Logger log = LoggerFactory.getLogger(ShopperApi.class);

        @Autowired
        private ShopperService shopperService;

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
        public Response createShopper(Shopper shopper) {
            Response response;
            log.info(MessageFormat.format("Creating shopper is {0}", shopper));
            if (shopper == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            // Create new shopper
            Shopper shopperDTO = shopperService.createShopper(shopper);

            response = Response.ok(shopperDTO).build();

            return response;
        }

        @GET
        @Path("/{id}")
        @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
        public Response getShopper(@PathParam("id") Long id)
        {
            Response response;
            log.info(MessageFormat.format("Get shopper with id {0}", id));
            Shopper shopperDTO = shopperService.getShopper(id);
            response = Response.ok(shopperDTO).build();

            return response;
        }

}
