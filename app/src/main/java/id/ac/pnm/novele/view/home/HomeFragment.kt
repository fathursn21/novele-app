package id.ac.pnm.novele.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ac.pnm.novele.view.DetailActivity
import id.ac.pnm.novele.viewmodel.SearchViewModel

class HomeFragment : Fragment() {

    private lateinit var recyclerViewNovelVertical : RecyclerView
    private lateinit var recyclerViewNovelHorizontal : RecyclerView

    private lateinit var textViewNovelUpdate : TextView
    private lateinit var textViewNovelPopuler : TextView
    private lateinit var textViewHome : TextView

    private lateinit var editTextSearchInput : EditText

    private lateinit var imageViewSearchIcon : ImageView
    private lateinit var imageViewCancelSearchIcon : ImageView
    private lateinit var imageViewMoreVerticalIcon : ImageView


    private lateinit var novelVerticalUpdateAdapter: NovelVerticalUpdateAdapter
    private lateinit var novelHorizontalAdapter: NovelHorizontalAdapter
    private lateinit var novelViewModel: NovelViewModel
    private lateinit var searchViewModel: SearchViewModel

    //tombok back 2x
    private val onBackPressedCallback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            tutupSearch()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //recyclerView
        recyclerViewNovelVertical = view.findViewById(R.id.recyclerViewNovelVertical)
        recyclerViewNovelHorizontal = view.findViewById(R.id.recyclerViewNovelHorizontal)
        //textView
        textViewNovelUpdate = view.findViewById(R.id.textViewNovelUpdate)
        textViewNovelPopuler = view.findViewById(R.id.textViewNovelPopuler)
        textViewHome = view.findViewById(R.id.textViewLibrary)
        editTextSearchInput = view.findViewById(R.id.editTextSearchInput)
        //imageView
        imageViewSearchIcon = view.findViewById(R.id.imageViewSearchIcon)
        imageViewCancelSearchIcon = view.findViewById(R.id.imageViewCancelSearchIcon)
        imageViewMoreVerticalIcon = view.findViewById(R.id.imageViewMoreVerticalIcon)
        //tombol back
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewNovelUpdate.setText(R.string.title_novel_update)
        textViewNovelPopuler.setText(R.string.title_novel_populer)
        
        //viewmodelhome memakai requireActivity biar instance di fragment lain sama dengan yang ini
        novelViewModel = ViewModelProvider(requireActivity())[NovelViewModel::class.java]
        //viewmodel untuk search agar datanya tidak dihapus itu aja sih
        searchViewModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]

        //adapter ngirim paket id novel
        novelVerticalUpdateAdapter = NovelVerticalUpdateAdapter { id ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("ID_NOVEL", id)
            startActivity(intent)
        }
        novelHorizontalAdapter = NovelHorizontalAdapter{ id ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("ID_NOVEL", id)
            startActivity(intent)
        }

        imageViewSearchIcon.setOnClickListener {
            //imageView
            imageViewSearchIcon.visibility = View.GONE
            imageViewCancelSearchIcon.visibility = View.VISIBLE
            imageViewMoreVerticalIcon.visibility = View.GONE
            //textView
            textViewHome.visibility = View.GONE
            // editText
            editTextSearchInput.visibility = View.VISIBLE
            //rekues keyboard
            editTextSearchInput.requestFocus()
            // keyboard
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(editTextSearchInput, InputMethodManager.SHOW_IMPLICIT)
            onBackPressedCallback.isEnabled = true
        }

        imageViewCancelSearchIcon.setOnClickListener {
            tutupSearch()
        }
        //untuk search
        editTextSearchInput.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = editTextSearchInput.text.toString().trim()
                if (query.isNotEmpty()) {
                    searchViewModel.query.value = query
                    novelViewModel.searchNovel(query)

                    val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                    // menyembunyikan keyboard biar rapi aja
                    imm?.hideSoftInputFromWindow(v.windowToken, 0)
                    //pindah ke libraryfragment pakai bottom_nav tapi lewat kode bukan xml
                    (requireActivity()).findViewById<BottomNavigationView>(R.id.bottom_nav)
                        .selectedItemId = R.id.libraryFragment
                }
                true
            } else {
                false
            }
        }
        //tampilan dari adapter
        recyclerViewNovelVertical.adapter = novelVerticalUpdateAdapter
        //bisa pakai apply atau tidak sama aja cuma beda dibungkus saja
        recyclerViewNovelHorizontal.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
            adapter = novelHorizontalAdapter
        }
        //belum jadi karena belum tak buatkan LIFO nya atau tumpukannya untuk novel Update
        novelViewModel.novelData.observe(viewLifecycleOwner){ daftarNovel ->
            if (daftarNovel.isNotEmpty()){
                val daftarNovelHorizontal = daftarNovel.take(5)
                novelHorizontalAdapter.updateData(daftarNovelHorizontal)

                val daftarNovelVertical = daftarNovel.take(5)
                novelVerticalUpdateAdapter.updateData(daftarNovelVertical)
            } else {
                novelHorizontalAdapter.updateData(emptyList())
                novelVerticalUpdateAdapter.updateData(emptyList())
            }
        }
        //ambil daftar novelnya biar ga kosong
        novelViewModel.getNovelData()
    }

    override fun onResume() {
        super.onResume()
        searchViewModel.query.value = ""
    }
    
    private fun tutupSearch(){
        //editText
        editTextSearchInput.setText("")
        editTextSearchInput.visibility = View.GONE
        //imageView
        imageViewSearchIcon.visibility = View.VISIBLE
        imageViewCancelSearchIcon.visibility = View.GONE
        imageViewMoreVerticalIcon.visibility = View.VISIBLE
        //textView
        textViewHome.visibility = View.VISIBLE
        //membersihkan hasil search
        novelViewModel.clearSearchResult()
        //sama kayak diatas untuk menyembunyikan keyboard kalau masih muncul
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(editTextSearchInput.windowToken, 0)
        onBackPressedCallback.isEnabled = false
    }
}