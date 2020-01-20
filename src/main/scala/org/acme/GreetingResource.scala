package org.acme

import javax.inject.Inject
import javax.ws.rs.{GET, Path, PathParam, Produces}
import javax.ws.rs.core.MediaType
import org.eclipse.microprofile.config.inject.ConfigProperty

@Path("/hello")
class GreetingResource @Inject() (service: GreetingService){

    @ConfigProperty(name = "greeting.message")
    var message: String = _

    @ConfigProperty(name = "greeting.suffix", defaultValue="!")
    var suffix: String = _

    @ConfigProperty(name = "greeting.name")
    var name: Option[String] = _

    def this() = this(null)

    @GET 
    @Path("/greeting/{name}")
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def greeting(@PathParam("name") name: String): String = service.greeting(name)

    @GET 
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def hello() = s"${message} world${suffix}" 
}