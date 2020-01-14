package org.acme

import javax.inject.Inject
import javax.ws.rs.{GET, Path, PathParam, Produces}
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource @Inject() (service: GreetingService){

    def this() = this(null)

    @GET 
    @Path("/greeting/{name}")
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def greeting(@PathParam("name") name: String): String = service.greeting(name)

    @GET 
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def hello() = "hello"
}