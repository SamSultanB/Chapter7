package sam.sultan.authorizationapp.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import sam.sultan.authorizationapp.entities.*

interface Api {

    @POST("register/")
    suspend fun register(@Body email: Email): Response<RegistrationResponse>

    @POST("login/")
    suspend fun login(@Body loginData: LoginData): Response<LoginData>

    @POST("{user_id}/form/")
    suspend fun infoForm(@Body userDetails: UserDetails, @Path("user_id") id: String): Response<UserDetails>

    @POST("forgot_password/")
    suspend fun password(@Body email: Email): Response<RegistrationResponse>

    @PUT("{user_id}/set_password/")
    suspend fun setPassword(@Body password: Password): Response<Password>

}