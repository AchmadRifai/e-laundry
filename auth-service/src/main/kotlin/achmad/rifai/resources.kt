package achmad.rifai

import achmad.rifai.dto.GreetingRes
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/hello")
class HelloResource {
    @GET
    fun hello() = Uni.createFrom()
        .voidItem()
        .map { GreetingRes() }
}