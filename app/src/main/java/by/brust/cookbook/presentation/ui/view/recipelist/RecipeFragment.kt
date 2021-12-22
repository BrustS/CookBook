package by.brust.cookbook.presentation.ui.view.recipelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.brust.cookbook.R
import by.brust.cookbook.databinding.FragmentRecipesListBinding
import by.brust.cookbook.presentation.ui.view.recipelist.recycler.RecipeAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentRecipesListBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesListBinding.inflate(inflater,container,false)

        binding.recyclerView.apply {
            adapter = RecipeAdapter(viewModel.recipes)
            layoutManager = LinearLayoutManager(requireContext())
        }

        val navController = findNavController(this)
        binding.bottomNavigationView.setupWithNavController(navController)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}