package by.brust.cookbook.presentation.ui.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.brust.cookbook.databinding.FragmentDetailRecipeBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

private var _binding: FragmentDetailRecipeBinding? = null
private val binding get() = _binding!!

@AndroidEntryPoint
class DetailRecipeFragment : Fragment() {

    val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailRecipeBinding.inflate(inflater, container, false)

        binding.ingredientsLabel.text = viewModel.recipe?.title
        binding.fullDescriptionTextView.text = viewModel.recipe?.fulldecription
        binding.ingredientsTextView.text = viewModel.recipe?.shortdescription
        Glide.with(requireContext()).load(viewModel.recipe?.imageurl).centerCrop()
            .into(binding.imageView)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoriteAddButton.setOnClickListener{
            Toast.makeText(requireContext(), "Recipe added!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}