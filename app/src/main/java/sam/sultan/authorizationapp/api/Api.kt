package sam.sultan.authorizationapp.api

import retrofit2.http.POST

interface Api {

    @POST("register")
    suspend fun register()

    @POST("login")
    suspend fun login()

    @POST("{user_id}/form")
    suspend fun infoForm()

    @POST("forgot_password")
    suspend fun password()

}