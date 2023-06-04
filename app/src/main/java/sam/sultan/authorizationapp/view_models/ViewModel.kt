package sam.sultan.authorizationapp.view_models
import android.util.Patterns
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    fun validEmail(email: String): String?{
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid email"
        }
        return null
    }

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