package sam.sultan.authorizationapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentRegistrationBinding
import sam.sultan.authorizationapp.view_models.ViewModel

class RegistrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding
    val viewModel = ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.nextButton.setOnClickListener {
            var email = binding.emailField.text.toString()
            if(viewModel.validEmail(email) == null){
                findNavController().navigate(R.id.action_registrationFragment_to_detailInfoFragment)
            }else{
                binding.emailContainer.helperText = viewModel.validEmail(email)
            }
        }

    }



}