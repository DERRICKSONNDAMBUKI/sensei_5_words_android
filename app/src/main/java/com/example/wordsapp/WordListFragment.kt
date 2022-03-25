package com.example.wordsapp

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX =  "https://www.google.com/search?q="
    }
    private var _binding:FragmentWordListBinding?=null
    private val binding get() = _binding!!
    val recyclerView = binding.recyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns String? (String or null)
        // so toString() guarantees that the value will be a String
        val letterId = activity?.intent?.extras?.getString(WordListFragment.LETTER).toString()


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(activity?.intent?.extras?.getString(LETTER).toString(), requireContext())

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}