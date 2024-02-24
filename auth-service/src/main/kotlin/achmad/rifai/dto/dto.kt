package achmad.rifai.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class LoginReq(
    @NotNull
    @NotEmpty
    @NotBlank
    val username: String?,
    @NotNull
    @NotEmpty
    @NotBlank
    val password: String?
)

data class GreetingRes(val message: String = "Hello")