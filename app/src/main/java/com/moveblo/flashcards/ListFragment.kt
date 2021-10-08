package com.moveblo.flashcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moveblo.flashcards.databinding.ItemListBinding
import com.moveblo.flashcards.model.Flashcard


val flashcards = arrayListOf(
    Flashcard(1,"question 1", "answer 1"),
    Flashcard(2,"question 2", "answer 2"),
    Flashcard(3,"question 3", "answer 3"),
    Flashcard(4,"question 4", "answer 4"),
    Flashcard(5,"question 5", "answer 5"),
    Flashcard(6,"question 6", "answer 6"),
    Flashcard(7,"question 7", "answer 7"),
    Flashcard(8,"question 1", "answer 1"),
    Flashcard(9,"question 2", "answer 2"),
    Flashcard(10,"question 3", "answer 3"),
    Flashcard(11,"question 4", "answer 4"),
    Flashcard(12,"question 5", "answer 5"),
    Flashcard(13,"question 6", "answer 6"),
    Flashcard(14,"question 7", "answer 7"),
    Flashcard(15,"question 1", "answer 1"),
    Flashcard(16,"question 2", "answer 2"),
    Flashcard(17,"question 3", "answer 3"),
    Flashcard(18,"question 4", "answer 4"),
    Flashcard(19,"question 5", "answer 5"),
    Flashcard(20,"question 6", "answer 6"),
    Flashcard(21,"question 77", "answer 77"),
)


class ListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var flashcardList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        flashcardList = view.findViewById<RecyclerView>(R.id.fragment_list_list)
        val linearLayoutManager = LinearLayoutManager(this.context)
        flashcardList.layoutManager = linearLayoutManager
        flashcardList.adapter = ListAdapter(flashcards)
        return view
    }
}

class ListAdapter(val flashcards: ArrayList<Flashcard>) :
    RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder>() {

    class ListAdapterViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapter.ListAdapterViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListAdapterViewHolder, position: Int) {
        with(holder) {
            binding.textviewItemList.text =  flashcards[position].question
            binding.root.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(flashcards[position].id)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return flashcards.size
    }

}