package by.brust.cookbook.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.brust.cookbook.R
import by.brust.cookbook.databinding.FragmentLoginBinding
import by.brust.cookbook.domain.usecases.LoginUserByEmailUseCase

private var _binding: FragmentLoginBinding? = null
private val binding get() = _binding!!


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            if (LoginUserByEmailUseCase().execute(email = email, password = password)) {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_loginFragment_to_recipeFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}