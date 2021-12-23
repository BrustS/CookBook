package by.brust.cookbook.presentation.ui.view.recipelist.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.storage.local.room.mappers.ToRecipe
import by.brust.cookbook.databinding.FragmentFavoriteitemBinding
import by.brust.cookbook.presentation.ui.view.favoritelist.FavoriteFragmentDirections
import com.bumptech.glide.Glide



class FavoriteRecipeAdapter: ListAdapter<FavoriteRecipe, FavoriteRecipeViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRecipeViewHolder =
        FavoriteRecipeViewHolder(
            FragmentFavoriteitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavoriteRecipeViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    companion object {
        private val COMPARATOR  = object : DiffUtil.ItemCallback<FavoriteRecipe>() {
            override fun areItemsTheSame(oldItem: FavoriteRecipe, newItem: FavoriteRecipe): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: FavoriteRecipe, newItem: FavoriteRecipe): Boolean {
             return oldItem.title == newItem.title
            }

        }
    }
}

    class FavoriteRecipeViewHolder(private val binding: FragmentFavoriteitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriterecipe: FavoriteRecipe?) {
           if (favoriterecipe != null) {
               binding.apply {
                   titleRecipeTextView.text = favoriterecipe.title
                   Glide.with(binding.root).load(favoriterecipe.imageurl).into(binding.recipeImage)
               }
               binding.root.setOnClickListener {
                   val recipe = favoriterecipe.ToRecipe()
                   val action =
                       FavoriteFragmentDirections.actionFavoriteFragmentToDetailRecipeFragment(recipe)
                   it.findNavController().navigate(action)
               }

               binding.deleteButton.setOnClickListener {

               }
           }

        }
    }