package sam.sultan.authorizationapp.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentRegistrationBinding
import sam.sultan.authorizationapp.databinding.MessageSentDialogSheetBinding
import sam.sultan.authorizationapp.entities.Email
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
                var email1 = binding.emailField.text.toString()
                val email2 = Email(email1)
                callDialog(email1)
//                viewModel.register(email2)
            }else{
                binding.emailContainer.helperText = viewModel.validEmail(email)
            }
        }
//        viewModel.response.observe(viewLifecycleOwner, Observer{response ->
//            if (response is Resource.Success){
//                findNavController().navigate(R.id.action_registrationFragment_to_detailInfoFragment)
//            }else if(response is Resource.Error){
//                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_registrationFragment_to_detailInfoFragment)
//            }
//        })

    }

    private fun callDialog(email: String){
        val dialog = AlertDialog.Builder(requireContext()).create()
        val messageDialog = MessageSentDialogSheetBinding.inflate(layoutInflater)
        dialog.setView(messageDialog.root)
        messageDialog.message.text = getString(R.string.message, email)
        messageDialog.closeBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }



}