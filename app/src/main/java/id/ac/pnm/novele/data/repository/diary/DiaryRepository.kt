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
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare."),
        DiaryData("2", R.drawable.ic_launcher_background,
            "Makan Bakso",
            "anonim", emptyList(),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare."),
        DiaryData("3", R.drawable.ic_launcher_background,
            "Makan Mie Ayam",
            "anonim", emptyList(),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare."),
        DiaryData("4", R.drawable.ic_launcher_background,
            "Makan Soto",
            "anonim", emptyList(),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare."),
        DiaryData("5", R.drawable.ic_launcher_background,
            "Makan Ayam Goreng",
            "anonim", emptyList(),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare."),
    )

    fun fetchDiaryData(): List<DiaryData> {
       return diaryList
    }

    fun addDiary(diary: DiaryData){
        diaryList.add(0, diary)
    }

    fun getDiaryById(id: String): DiaryData? {
        return diaryList.firstOrNull { it.id == id }
    }
}