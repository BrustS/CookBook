package by.brust.cookbook.presentation.ui.view.favoritelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.brust.cookbook.R
import by.brust.cookbook.databinding.FragmentDetailRecipeBinding
import by.brust.cookbook.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentFavoriteBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteFragment()
    }

  private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)



        return binding.root
    }

}