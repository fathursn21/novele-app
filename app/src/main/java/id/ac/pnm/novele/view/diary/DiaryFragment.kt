package id.ac.pnm.novele.view.diary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.view.DiaryEditorActivity
import id.ac.pnm.novele.viewmodel.diary.DiaryViewModel

class DiaryFragment : Fragment() {

    private lateinit var recyclerViewDiaryHorizontal : RecyclerView

    private lateinit var buttonAddDiary : Button

    private lateinit var diaryViewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_diary, container, false)

        recyclerViewDiaryHorizontal = view.findViewById<RecyclerView>(R.id.recyclerViewDiaryHorizontal)

        buttonAddDiary = view.findViewById<Button>(R.id.buttonAddDiary)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set horizontal slider in diary view in case karyaku
        diaryViewModel = ViewModelProvider(this)[DiaryViewModel::class.java]
        val diaryAdapterHorizontal = DiaryAdapterHorizontal{ idDiary ->

            val bundle = bundleOf(
                "idDiary" to idDiary
            )

            findNavController().navigate(
                R.id.detailDiaryFragment,
                bundle
            )
        }

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

        // set button listener to redirect to view add diary
        buttonAddDiary.setOnClickListener {
            Log.d("DiaryFragment", "buttonAddDiary clicked")
            val intent = Intent(requireContext(), DiaryEditorActivity::class.java)

            intent.putExtra("is_edit", false)
            startActivity(intent)
        }
        
    }

    override fun onResume() {
        super.onResume()
        diaryViewModel.getDiaryData()
    }
}