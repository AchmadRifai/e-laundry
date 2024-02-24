package achmad.rifai

import achmad.rifai.dto.GreetingRes
import achmad.rifai.dto.LoginReq
import achmad.rifai.services.SecurityService
import io.smallrye.mutiny.Uni
import jakarta.annotation.security.PermitAll
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.SecurityContext

@Path("/login")
class LoginResource {
    @Inject
    @field: Default
    private lateinit var securityService: SecurityService

    @POST
    fun login(@Valid req: LoginReq) = securityService.login(req)
        .map { GreetingRes(it) }!!
}

@Path("/hello")
class HelloResource {
    @Inject
    @field: Default
    private lateinit var securityService: SecurityService

    @GET
    @PermitAll
    fun hello(@Context ctx: SecurityContext) = Uni.createFrom()
        .item { ctx }
        .map { GreetingRes(securityService.context(it)) }
        .log()!!
}