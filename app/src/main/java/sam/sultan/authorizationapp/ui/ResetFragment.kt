package sam.sultan.authorizationapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentResetBinding
import sam.sultan.authorizationapp.entities.Email
import sam.sultan.authorizationapp.view_models.ViewModel

class ResetFragment : Fragment() {

    lateinit var binding: FragmentResetBinding
    val viewModel = ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            val email = Email(binding.emailField.text.toString())
            viewModel.forgotPassword(email)
            findNavController().navigate(R.id.action_resetFragment_to_resetPasswordFragment)
        }

    }

}