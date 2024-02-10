package com.example.tomcat;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        String message = "Hello, World!";
        return Response.ok().entity(message).build();
    }
}
