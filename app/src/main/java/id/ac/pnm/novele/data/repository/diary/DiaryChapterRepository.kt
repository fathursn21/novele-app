package id.ac.pnm.novele.data.repository.diary

import id.ac.pnm.novele.data.model.diary.DiaryChapterData

class DiaryChapterRepository {
    private val diaryChapterList = mutableListOf<DiaryChapterData>(
        DiaryChapterData(
            "1",
            "1",
            1,
            "awal dari segalanya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
            2
        ),
        DiaryChapterData(
            "2",
            "1",
            2,
            "awal dari segalanya 2",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
            3
        ),
        DiaryChapterData(
            "3",
            "1",
            3,
            "awal dari segalanya 3",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
            4
        )

    )

    fun fetchChapterDiaryData(): List<DiaryChapterData> {
        return diaryChapterList
    }

    fun addChapterDiary(diary: DiaryChapterData){
        diaryChapterList.add(0, diary)
    }

    fun getChapterDiaryById(id: String): DiaryChapterData? {
        return diaryChapterList.firstOrNull { it.idChapter == id }
    }
}