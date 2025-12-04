package id.ac.pnm.novele.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.view.DetailActivity
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel

class DetailFragment : Fragment() {
    private var id: String? = null
    private lateinit var recyclerViewChapterNovelDetail: RecyclerView
    private lateinit var textViewJudulNovelDetail: TextView
    private lateinit var textViewSinopsisNovelDetail: TextView
    private lateinit var textViewPenulisNovelDetail: TextView
    private lateinit var textViewPenerbitNovelDetail: TextView
    private lateinit var textViewJumlahChapterNovelDetail: TextView
    private lateinit var detailChapterAdapter: DetailChapterAdapter
    private lateinit var imageViewCoverNovelDetail : ImageView
    private lateinit var novelViewModel: NovelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //menerima kiriman
        val getExtraNovelId = requireActivity().intent.getStringExtra(DetailActivity.ID_NOVEL)
        id = getExtraNovelId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textViewJudulNovelDetail = view.findViewById(R.id.textViewJudulNovelDetail)
        textViewSinopsisNovelDetail = view.findViewById(R.id.textViewSinopsisNovelDetail)
        textViewPenulisNovelDetail = view.findViewById(R.id.textViewPenulisNovelDetail)
        textViewPenerbitNovelDetail = view.findViewById(R.id.textViewPenerbitNovelDetail)
        textViewJumlahChapterNovelDetail = view.findViewById(R.id.textViewJumlahChapterNovelDetail)
        imageViewCoverNovelDetail = view.findViewById(R.id.imageViewCoverNovelDetail)

        recyclerViewChapterNovelDetail = view.findViewById(R.id.recyclerViewChapterNovelDetail)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapter
        detailChapterAdapter = DetailChapterAdapter()
        //tampilan dari adapter
        recyclerViewChapterNovelDetail.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = detailChapterAdapter
        }

        novelViewModel = ViewModelProvider(requireActivity())[NovelViewModel::class.java]
        novelViewModel.loadNovelById(id)


        //memperbarui data sesuai nilai detailNovel yang diamati
        novelViewModel.detailNovel.observe(viewLifecycleOwner) { novel ->
            textViewJudulNovelDetail.text = novel?.judulNovel
            textViewSinopsisNovelDetail.text = novel?.sinopsis
            textViewPenulisNovelDetail.text = novel?.penulis
            textViewPenerbitNovelDetail.text = novel?.penerbit
            imageViewCoverNovelDetail.setImageResource(novel?.coverNovel!!)
        }
        //daftar chapter
        novelViewModel.chapterData.observe(viewLifecycleOwner) { daftarChapter->
            detailChapterAdapter.updateData(daftarChapter)
        }

        //nilai totalChapter dari viewmodel
        novelViewModel.totalChapter.observe(viewLifecycleOwner) { total ->
            textViewJumlahChapterNovelDetail.text =
                view.context.getString(R.string.chapter, total)
        }
    }
}