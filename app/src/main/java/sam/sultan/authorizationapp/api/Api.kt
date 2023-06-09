package sam.sultan.authorizationapp.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import sam.sultan.authorizationapp.entities.Email
import sam.sultan.authorizationapp.entities.LoginData
import sam.sultan.authorizationapp.entities.UserDetails

interface Api {

    @POST("register/")
    suspend fun register(@Body email: Email): Response<Email>

    @POST("login/")
    suspend fun login(loginData: LoginData): Response<LoginData>

    @POST("{user_id}/form/")
    suspend fun infoForm(userDetails: UserDetails): Response<UserDetails>

    @POST("forgot_password/")
    suspend fun password(@Body email: Email): Response<Email>

}