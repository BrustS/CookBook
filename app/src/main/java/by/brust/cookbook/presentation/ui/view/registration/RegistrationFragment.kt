package by.brust.cookbook.presentation.ui.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.brust.cookbook.R
import by.brust.cookbook.data.models.User
import by.brust.cookbook.databinding.FragmentProfileBinding
import by.brust.cookbook.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentRegistrationBinding? = null
private val binding get() = _binding!!
@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)

    binding.AddUserButton.setOnClickListener {
        val user = User(
            name = binding.nameEditText.text.toString(),
            email = binding.emailEditText.text.toString(),
            password = binding.passwordEditText.text.toString()
        )
        viewModel.add(user)
        Toast.makeText(requireContext()," User added!", Toast.LENGTH_SHORT).show()
}
        binding.BackButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        return binding.root
    }
}