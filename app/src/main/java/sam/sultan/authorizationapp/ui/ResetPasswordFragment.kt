package sam.sultan.authorizationapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentResetPasswordBinding
import sam.sultan.authorizationapp.entities.Password
import sam.sultan.authorizationapp.view_models.ViewModel

class ResetPasswordFragment : Fragment() {

    lateinit var binding: FragmentResetPasswordBinding
    val viewModel = ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreatePassword.setOnClickListener {
            val pass1 = binding.pass1.text.toString()
            val pass2 = binding.pass2.text.toString()
            val password = Password(pass1, pass2)
            viewModel.setPassword(password)
        }
    }

}