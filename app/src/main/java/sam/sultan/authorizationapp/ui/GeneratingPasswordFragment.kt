package sam.sultan.authorizationapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentGeneratingPasswordBinding
import sam.sultan.authorizationapp.entities.Password
import sam.sultan.authorizationapp.view_models.ViewModel

class GeneratingPasswordFragment : Fragment() {

    lateinit var binding: FragmentGeneratingPasswordBinding
    val viewModel = ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGeneratingPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.BackButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.firstPassword.setOnFocusChangeListener { v, hasFocus ->
            val password = binding.firstPassword.text.toString()
            if (!hasFocus){
                if (viewModel.capitalCase(password)){
                    binding.upperCaseLetter.setTextColor(R.color.smile_text_color)
                }
                if (viewModel.digits(password)){
                    binding.numbers.setTextColor(R.color.smile_text_color)
                }
                if (viewModel.symbols(password)){
                    binding.symbols.setTextColor(R.color.smile_text_color)
                }
            }
        }
        binding.buttonCreatePassword.setOnClickListener {
            passwordSave()
        }
    }

    private fun passwordSave(){
        val pass1 = binding.firstPassword.text.toString()
        val pass2 = binding.secondPassword.text.toString()
        val passwords = Password(pass1, pass2)
        viewModel.setPassword(passwords)
        findNavController().navigate(R.id.action_generatingPasswordFragment_to_loginFragment)
    }
}