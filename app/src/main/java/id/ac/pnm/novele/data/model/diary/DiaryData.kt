package id.ac.pnm.novele.data.model.diary

import id.ac.pnm.novele.data.model.novel.Genre

data class DiaryData(
    var id : String,
    var coverDiary : Int,
    var judulDiary : String,
    var penulis: String,
    var chapter: List<DiaryChapterData>,
    var sinopsis: String,
)

data class DiaryChapterData(
    var idDiary : String,
    val chapter: Int,
    val title: String,
    val konten: String,
    val waktu: Int
)
