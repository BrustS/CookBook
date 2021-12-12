package by.brust.cookbook.presentation.ui.view.recipelist.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.databinding.FragmentItemBinding
import coil.load


class RecipeAdapter(private val recipes_list: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    class RecipeViewHolder(private val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.apply {
                titleRecipeTextView.text = recipe.title
                recipeImage.load(recipe.imageurl)
                shortDescriptionRecipeTextView.text = recipe.shortdescription
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