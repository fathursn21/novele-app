package id.ac.pnm.novele.data.repository.diary

import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData

class DiaryRepository {

    private val diaryList = mutableListOf(
        DiaryData("1", R.drawable.ic_launcher_background, "Makan Sate", 2, 1, 1, 5),
        DiaryData("2", R.drawable.ic_launcher_background, "Makan Bakso", 2, 1, 1, 5),
        DiaryData("3", R.drawable.ic_launcher_background, "Makan Mie Ayam", 2, 1, 1, 5),
        DiaryData("4", R.drawable.ic_launcher_background, "Makan Soto", 2, 1, 1, 5),
        DiaryData("5", R.drawable.ic_launcher_background, "Makan Ayam Goreng", 2, 1, 1, 5),
    )

    fun fetchDiaryData(): List<DiaryData> {
       return diaryList
    }

    fun addDiary(diary: DiaryData){
        diaryList.add(0, diary)
    }
}