package by.brust.cookbook.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.brust.cookbook.R
import by.brust.cookbook.databinding.FragmentItemListBinding
import by.brust.cookbook.databinding.FragmentLoginBinding

private var _binding: FragmentItemListBinding? = null
private val binding get() = _binding!!


class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}