package sam.sultan.authorizationapp.entities

data class UserDetails(
    val id: Int,
    val user_id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val birthdate: String,
    val createdAt: String,
    val updatedAt: String
)
