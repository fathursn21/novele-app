package id.ac.pnm.novele.data.model.diary

data class DiaryData(
    var id : String,
    var coverDiary : Int,
    var judulDiary : String,
    var chapterBaru : Int,
    var chapterLama : Int,
    var waktuChapterBaru : Int,
    var waktuChapterLama : Int
)
