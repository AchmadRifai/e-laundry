package achmad.rifai.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class User(
    @BsonId
    var id: ObjectId? = null,
    val username: String = "",
    var password: String = "",
    var name: String = "",
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val createdBy: String = "",
    var roles: List<String> = listOf(),
)