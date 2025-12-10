package id.ac.pnm.novele.data.repository.diary

import android.util.Log
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData
import id.ac.pnm.novele.data.model.novel.Genre

class DiaryRepository {

    private val diaryList = mutableListOf(
        DiaryData("1", R.drawable.ic_launcher_background,
            "Makan Sate",
            "anonim", emptyList(),
            "sinopsis testing"),
        DiaryData("1", R.drawable.ic_launcher_background,
            "Makan Bakso",
            "anonim", emptyList(),
            "sinopsis testing"),
        DiaryData("1", R.drawable.ic_launcher_background,
            "Makan Mie Ayam",
            "anonim", emptyList(),
            "sinopsis testing"),
        DiaryData("1", R.drawable.ic_launcher_background,
            "Makan Soto",
            "anonim", emptyList(),
            "sinopsis testing"),
        DiaryData("1", R.drawable.ic_launcher_background,
            "Makan Ayam Goreng",
            "anonim", emptyList(),
            "sinopsis testing"),
    )

    fun fetchDiaryData(): List<DiaryData> {
       return diaryList
    }

    fun addDiary(diary: DiaryData){
        diaryList.add(0, diary)
    }
}