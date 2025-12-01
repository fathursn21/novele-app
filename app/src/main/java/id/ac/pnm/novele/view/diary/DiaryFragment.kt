package id.ac.pnm.novele.view.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.viewmodel.diary.DiaryViewModel
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel

class DiaryFragment : Fragment() {

    private lateinit var recyclerViewDiaryHorizontal : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_diary, container, false)

        recyclerViewDiaryHorizontal = view.findViewById<RecyclerView>(R.id.recyclerViewDiaryHorizontal)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val diaryViewModel: DiaryViewModel = ViewModelProvider(this)[DiaryViewModel::class.java]
        val diaryAdapterHorizontal = DiaryAdapterHorizontal()

        recyclerViewDiaryHorizontal.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = diaryAdapterHorizontal
        }

        diaryViewModel.diaryData.observe(viewLifecycleOwner){listDiary ->
            if (listDiary.isEmpty()){
                diaryAdapterHorizontal.adapterListenerData(emptyList())
            } else {
                diaryAdapterHorizontal.adapterListenerData(listDiary.take(5))
            }
        }
        diaryViewModel.getDiaryData()
        
    }
}