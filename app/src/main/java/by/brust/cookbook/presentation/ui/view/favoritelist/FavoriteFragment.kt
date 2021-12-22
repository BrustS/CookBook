package by.brust.cookbook.presentation.ui.view.favoritelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.brust.cookbook.R
import by.brust.cookbook.databinding.FragmentDetailRecipeBinding
import by.brust.cookbook.databinding.FragmentFavoriteBinding
import by.brust.cookbook.presentation.ui.view.recipelist.recycler.FavoriteRecipeAdapter
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentFavoriteBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private val viewModel: FavoriteViewModel by viewModels()
    private val favoriteadapter = FavoriteRecipeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        val navController = NavHostFragment.findNavController(this)
       binding.bottomNavigationViewFavorite.setupWithNavController(navController)

        binding.recyclerFavoriteList.apply {
            adapter = favoriteadapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.recipeList.observe(this) {
                recipes -> recipes.let { favoriteadapter.submitList(it) }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}