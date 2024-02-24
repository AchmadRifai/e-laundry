package achmad.rifai.repositories

import achmad.rifai.models.User
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository : ReactivePanacheMongoRepository<User> {
    fun findByUsername(username: String) = findsByUsername(username).map { it.first() }!!

    fun findsByUsername(username: String) = find("username", username).list()
}