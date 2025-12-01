package id.ac.pnm.novele.view.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel

class LibraryFragment : Fragment() {
    private  lateinit var recyclerViewLibrary : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_library, container, false)

        recyclerViewLibrary = view.findViewById<RecyclerView>(R.id.recyclerViewNovelLibrary)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val novelViewModel: NovelViewModel = ViewModelProvider(this)[NovelViewModel::class.java]
        val libraryAdapter = LibraryAdapterHorizontal()

        recyclerViewLibrary.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = libraryAdapter
        }

        novelViewModel.novelData.observe(viewLifecycleOwner){listNovel ->
            if (listNovel.isEmpty()){
                libraryAdapter.adapterListenerData(emptyList())
            } else {
                libraryAdapter.adapterListenerData(listNovel.take(5))
            }

        }
        novelViewModel.getNovelData()

    }
}