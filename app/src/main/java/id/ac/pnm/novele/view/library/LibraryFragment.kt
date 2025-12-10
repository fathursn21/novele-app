package id.ac.pnm.novele.view.library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.view.DetailActivity
import id.ac.pnm.novele.viewmodel.SearchViewModel
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel

class LibraryFragment : Fragment() {

    private lateinit var recyclerViewLibrary: RecyclerView
    private lateinit var libraryAdapter: LibraryAdapterVertical
    private lateinit var novelViewModel: NovelViewModel
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var editTextLibrarySearchInput : EditText
    private lateinit var textViewLibrary: TextView
    private lateinit var imageViewLibrarySearchIcon : ImageView
    private lateinit var imageViewLibraryCancelSearchIcon : ImageView
    private lateinit var imageViewLibraryFilterSearchIcon : ImageView



    private val onBackPressedCallback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            tutupSearch()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_library, container, false)
        recyclerViewLibrary = view.findViewById(R.id.recyclerViewNovelLibrary)
        textViewLibrary = view.findViewById(R.id.textViewLibrary)
        editTextLibrarySearchInput = view.findViewById(R.id.editTextLibrarySearchInput)
        imageViewLibrarySearchIcon = view.findViewById(R.id.imageViewLibrarySearchIcon)
        imageViewLibraryCancelSearchIcon = view.findViewById(R.id.imageViewLibraryCancelSearchIcon)
        imageViewLibraryFilterSearchIcon = view.findViewById(R.id.imageViewLibraryFilterSearchIcon)


        //tombol back
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        novelViewModel = ViewModelProvider(requireActivity())[NovelViewModel::class.java]
        searchViewModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]

        libraryAdapter = LibraryAdapterVertical { id ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("ID_NOVEL", id)
            startActivity(intent)
        }

        imageViewLibrarySearchIcon.setOnClickListener {
            //imageView
            imageViewLibrarySearchIcon.visibility = View.GONE
            imageViewLibraryCancelSearchIcon.visibility = View.VISIBLE
            imageViewLibraryFilterSearchIcon.visibility = View.GONE
            //textView
            textViewLibrary.visibility = View.GONE
            // editText
            editTextLibrarySearchInput.visibility = View.VISIBLE
            //rekues keyboard
            editTextLibrarySearchInput.requestFocus()
            // keyboard
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(editTextLibrarySearchInput, InputMethodManager.SHOW_IMPLICIT)
            onBackPressedCallback.isEnabled = true
        }

        imageViewLibraryCancelSearchIcon.setOnClickListener {
            tutupSearch()
        }

        editTextLibrarySearchInput.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                val query = editTextLibrarySearchInput.text.toString().trim()
                if (query.isNotEmpty()) {
                    searchViewModel.query.value = query
                    novelViewModel.searchNovel(query)

                    val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                    // menyembunyikan keyboard biar rapi aja
                    imm?.hideSoftInputFromWindow(v.windowToken, 0)
                }
                true
            } else {
                false
            }
        }
        //adapter
        recyclerViewLibrary.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = libraryAdapter
        }
        //untuk mengamati value query lalu mengirim query ke fungsi novelViewmodel
        searchViewModel.query.observe(viewLifecycleOwner) { query ->
            novelViewModel.searchNovel(query)
        }

        //untuk mengamati hasil search
        novelViewModel.searchResult.observe(viewLifecycleOwner) { searchList ->
            if (searchList.isNotEmpty()) {
                libraryAdapter.adapterListenerData(searchList)
            } else {
                // kalau search kosong, pakai list normal
                val allNovel = novelViewModel.novelData.value ?: emptyList()
                libraryAdapter.adapterListenerData(allNovel)
            }
        }

        //untuk mengamati daftar novel saat tidak di search atau daftar normalnya bang
        novelViewModel.novelData.observe(viewLifecycleOwner) { listNovel ->
            if (novelViewModel.searchResult.value.isNullOrEmpty()) {
                libraryAdapter.adapterListenerData(listNovel)
            }
        }

        //ambil daftar novelnya biar ga kosong
        novelViewModel.getNovelData()
    }
    private fun tutupSearch(){
        //editText
        editTextLibrarySearchInput.setText("")
        editTextLibrarySearchInput.visibility = View.GONE
        //imageView
        imageViewLibrarySearchIcon.visibility = View.VISIBLE
        imageViewLibraryCancelSearchIcon.visibility = View.GONE
        imageViewLibraryFilterSearchIcon.visibility = View.VISIBLE
        //textView
        textViewLibrary.visibility = View.VISIBLE
        //membersihkan hasil search
        novelViewModel.clearSearchResult()
        //sama kayak diatas untuk menyembunyikan keyboard kalau masih muncul
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(editTextLibrarySearchInput.windowToken, 0)
        onBackPressedCallback.isEnabled = false
    }
}
