package sam.sultan.authorizationapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sam.sultan.authorizationapp.R
import sam.sultan.authorizationapp.databinding.FragmentDetailInfoBinding

class DetailInfoFragment : Fragment() {

    lateinit var binding: FragmentDetailInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

}