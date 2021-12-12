package by.brust.cookbook.presentation.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import by.brust.cookbook.R
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.databinding.FragmentLoginBinding
import by.brust.cookbook.presentation.ui.view.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentLoginBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.getSavedUser()) NavHostFragment.findNavController(this)
            .navigate(R.id.action_loginFragment_to_recipeFragment)


        viewModel.userLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(
                    requireContext(),
                    "User not found or password is not correct",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.save(SavedUser(name = it.name, email = it.email))
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_loginFragment_to_recipeFragment)
            }
        }

        binding.signInButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            viewModel.get(email, password)
        }

        binding.addNewUserButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}