package by.brust.cookbook.presentation.ui.view.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.brust.cookbook.R
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.databinding.FragmentProfileBinding
import by.brust.cookbook.domain.usecases.GetUserFromSharedPrefsUseCase
import by.brust.cookbook.domain.usecases.SaveUserToSharedPrefUserCase
import by.brust.cookbook.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private var _binding: FragmentProfileBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val navController = NavHostFragment.findNavController(this)
        binding.bottomNavigationViewProfile.setupWithNavController(navController)

        binding.userNameTextView.text = viewModel.user.name
        binding.emailUserTextView.text = viewModel.user.email

        binding.logoutButton.setOnClickListener {
            viewModel.save(SavedUser(name = "", email = "")).toString()
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_profileFragment_to_loginFragment)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}