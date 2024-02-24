package achmad.rifai.services

import achmad.rifai.dto.LoginReq
import achmad.rifai.repositories.UserRepository
import io.smallrye.jwt.build.Jwt
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.InternalServerErrorException
import jakarta.ws.rs.core.SecurityContext
import org.eclipse.microprofile.jwt.JsonWebToken
import java.time.Duration

@ApplicationScoped
class SecurityService {
    @Inject
    @field: Default
    private lateinit var jwt: JsonWebToken
    @Inject
    @field: Default
    private lateinit var userRepository: UserRepository

    fun login(req: LoginReq) = userRepository.findByUsername(req.username.orEmpty())
        .log()
        .map { Jwt.issuer("auth")
            .subject(it.id.toString())
            .groups(it.roles.toSet())
            .expiresIn(Duration.ofMinutes(30))
            .sign() }
        .log()

    fun context(ctx: SecurityContext) = run {
        var name = "anonymous"
        if (ctx.userPrincipal != null) {
            if (ctx.userPrincipal.name != jwt.name) {
                throw InternalServerErrorException("Principal and JsonWebToken names do not match")
            } else {
                name = ctx.userPrincipal.name
            }
        }
        "hello $name isHttps ${ctx.isSecure} authScheme ${ctx.authenticationScheme} hasJWT ${hasJwt()}"
    }

    fun hasJwt() = jwt.claimNames != null
}