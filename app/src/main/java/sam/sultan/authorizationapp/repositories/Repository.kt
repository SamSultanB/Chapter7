package sam.sultan.authorizationapp.repositories

import sam.sultan.authorizationapp.api.RetrofitInstance
import sam.sultan.authorizationapp.entities.Email

class Repository {

    private val api = RetrofitInstance.api

    suspend fun register(email: Email) = api.register(email)

    suspend fun forgotPassword(email: Email) = api.password(email)

}