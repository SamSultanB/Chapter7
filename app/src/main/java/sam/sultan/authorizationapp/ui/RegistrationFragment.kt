package sam.sultan.authorizationapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentRegistrationBinding
import sam.sultan.authorizationapp.databinding.MessageSentDialogSheetBinding
import sam.sultan.authorizationapp.entities.Email
import sam.sultan.authorizationapp.entities.Resource
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
                val email2 = Email(email)
                callDialog(email)
                viewModel.register(email2)
            }else{
                binding.emailContainer.helperText = viewModel.validEmail(email)
            }
        }

    }

    private fun callDialog(email: String){
        val dialog = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog).create()
        val messageDialog = MessageSentDialogSheetBinding.inflate(layoutInflater)
        dialog.setView(messageDialog.root)
        messageDialog.message.text = getString(R.string.message, email)
        messageDialog.closeBtn.setOnClickListener {
            dialog.dismiss()
            response()
        }
        dialog.show()
    }

    private fun response(){
        viewModel.response.observe(viewLifecycleOwner, Observer{response ->
            if (response is Resource.Success){
                val bundle = Bundle()
                response.data?.user_id?.let { bundle.putInt("user_id", it) }
                findNavController().navigate(R.id.action_registrationFragment_to_detailInfoFragment, bundle)
            }else if(response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}