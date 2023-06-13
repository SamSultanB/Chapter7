package sam.sultan.authorizationapp.repositories

import sam.sultan.authorizationapp.api.RetrofitInstance
import sam.sultan.authorizationapp.entities.Email
import sam.sultan.authorizationapp.entities.LoginData
import sam.sultan.authorizationapp.entities.Password
import sam.sultan.authorizationapp.entities.UserDetails

class Repository {

    private val api = RetrofitInstance.api

    suspend fun register(email: Email) = api.register(email)

    suspend fun saveDetails(userDetails: UserDetails, id: String) = api.infoForm(userDetails, id)

    suspend fun setPassword(password: Password) = api.setPassword(password)

    suspend fun login(loginData: LoginData) = api.login(loginData)

    suspend fun forgotPassword(email: Email) = api.password(email)


}