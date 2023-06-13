package sam.sultan.authorizationapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentDetailInfoBinding
import sam.sultan.authorizationapp.entities.UserDetails
import sam.sultan.authorizationapp.view_models.ViewModel

class DetailInfoFragment : Fragment() {

    lateinit var binding: FragmentDetailInfoBinding
    private val viewModel = ViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("user_id").toString()

        binding.registerButton.setOnClickListener {
            checkNotEmpty()
            if(binding.name.helperText == null && binding.surname.helperText == null && binding.birthday.helperText == null && binding.emailDetails.helperText == null){
                saveDetails(id)
            }

        }

    }

    private fun checkNotEmpty(){
        binding.name.helperText = if (binding.nameField.text.isNullOrBlank()) "Please, enter your name" else null
        binding.surname.helperText = if(binding.surnameField.text.isNullOrBlank()) "Please, enter your surname" else null
        binding.birthday.helperText = if(binding.birthdayField.text.isNullOrBlank()) "Please, enter your birthday date" else null
        binding.emailDetails.helperText = if(viewModel.validEmail(binding.emailField.text.toString())!=null) "Please, enter your actual email" else null
    }

    private fun saveDetails(id: String){
        val name = binding.nameField.text.toString()
        val surname = binding.surnameField.text.toString()
        val birthdate = binding.birthdayField.text.toString()
        val email = binding.emailField.text.toString()

        val user = UserDetails(name, surname, birthdate, email)
        viewModel.saveDetails(user, id)
        val bundle = Bundle()
        bundle.putString("user_id", id)
        findNavController().navigate(R.id.action_detailInfoFragment_to_generatingPasswordFragment, bundle)
    }

}