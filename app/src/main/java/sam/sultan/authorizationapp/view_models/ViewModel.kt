package sam.sultan.authorizationapp.view_models
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import sam.sultan.authorizationapp.entities.Email
import sam.sultan.authorizationapp.entities.Resource
import sam.sultan.authorizationapp.repositories.Repository

class ViewModel: ViewModel() {

    private val repository = Repository()

    val response = MutableLiveData<Resource<Email>>()

    fun register(email: Email){
        viewModelScope.launch {
            response.postValue(Resource.Loading())
            var result = repository.register(email)
            if(result.isSuccessful){
                result.body()?.let { response.postValue(Resource.Success(it)) }
            }else{
                response.postValue(Resource.Error(result.message()))
            }
        }
    }

    fun forgotPassword(email: Email){
        viewModelScope.launch {
            response.postValue(Resource.Loading())
            var result = repository.forgotPassword(email)
            if(result.isSuccessful){
                result.body()?.let { response.postValue(Resource.Success(it)) }
            }else{
                response.postValue(Resource.Error(result.message()))
            }
        }
    }

    //validation methods

    //validation of email
    fun validEmail(email: String): String?{
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid email"
        }
        return null
    }

    //validation of password
    fun capitalCase(password: String): Boolean{
        if(!password.matches(".*[A-Z].*".toRegex())) {
            return false
        }
        return true
    }

    fun digits(password: String): Boolean{
        if(!password.matches(".*[0-9].*".toRegex())) {
            return false
        }
        return true
    }

    fun symbols(password: String): Boolean{
        if(!password.matches(".*[@#\$%^&+=].*".toRegex())) {
            return false
        }
        return true
    }

    fun samePassword(password1: String, password2: String): Boolean{
        if(!password1.equals(password2)){
            return false
        }
        return true
    }

}