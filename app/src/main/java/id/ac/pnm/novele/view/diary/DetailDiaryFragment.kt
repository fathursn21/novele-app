package id.ac.pnm.novele.view.diary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.repository.diary.DiaryRepository

class DetailDiaryFragment : Fragment() {
    private var DiaryRepository = DiaryRepository()

    private lateinit var imageViewBackArrowIcon : ImageView
    private lateinit var imageViewDetailHomeIcon : ImageView

    private lateinit var imageViewCoverDiaryDetail : ImageView
    private lateinit var textViewJudulDiaryDetail : TextView
    private lateinit var textViewPenulisDiaryDetail : TextView
    private lateinit var textViewSinopsisNovelDetail : TextView
    private lateinit var textViewJumlahChapterDiaryDetail : TextView

    private lateinit var buttonAddChapterDiary: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_detail_diary, container, false)

        imageViewBackArrowIcon = view.findViewById(R.id.imageViewBackArrowIcon)
        imageViewDetailHomeIcon = view.findViewById(R.id.imageViewDetailHomeIcon)

        imageViewCoverDiaryDetail = view.findViewById(R.id.imageViewCoverDiaryDetail)
        textViewJudulDiaryDetail = view.findViewById(R.id.textViewJudulDiaryDetail)
        textViewPenulisDiaryDetail = view.findViewById(R.id.textViewPenulisDiaryDetail)
        textViewSinopsisNovelDetail = view.findViewById(R.id.textViewSinopsisNovelDetail)
        textViewJumlahChapterDiaryDetail = view.findViewById(R.id.textViewJumlahChapterDiaryDetail)

        buttonAddChapterDiary = view.findViewById(R.id.buttonAddChapterDiary)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewBackArrowIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        imageViewDetailHomeIcon.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        val diaryId = arguments?.getString("idDiary")

        if (diaryId != null){
            val rowDiary = DiaryRepository.getDiaryById(diaryId)

            if (rowDiary != null){
                val sizeDiary = rowDiary?.chapter?.size ?: 0
                imageViewCoverDiaryDetail.setImageResource(rowDiary.coverDiary)
                textViewJudulDiaryDetail.text = rowDiary.judulDiary
                textViewPenulisDiaryDetail.text = rowDiary.penulis
                textViewSinopsisNovelDetail.text = rowDiary.sinopsis
                textViewJumlahChapterDiaryDetail.text = "$sizeDiary Chapter"
            }

            buttonAddChapterDiary.setOnClickListener {
                val intent = Intent(requireContext(), DiaryChapterEditorActivity::class.java)
                intent.putExtra("diaryId", diaryId)
                startActivity(intent)
            }

        }

    }
}