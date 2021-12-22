package by.brust.cookbook.presentation.ui.view.recipelist.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.databinding.FragmentItemBinding
import by.brust.cookbook.presentation.ui.view.recipelist.RecipeFragmentDirections
import com.bumptech.glide.Glide


class RecipeAdapter(private val recipes_list: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    class RecipeViewHolder(private val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.apply {
                titleRecipeTextView.text = recipe.title
                Glide.with(binding.root).load(recipe.imageurl).into(binding.recipeImage)
                shortDescriptionRecipeTextView.text = recipe.shortdescription
            }
            binding.root.setOnClickListener {
                val action = RecipeFragmentDirections.actionRecipeFragmentToDetailRecipeFragment(recipe)
                it.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes_list[position])
    }

    override fun getItemCount() = recipes_list.size
}