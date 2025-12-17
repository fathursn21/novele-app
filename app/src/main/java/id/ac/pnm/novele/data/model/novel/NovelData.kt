package id.ac.pnm.novele.data.model.novel

data class NovelData(
    var id : String,
    var coverNovel : Int,
    var judulNovel : String,
    var penulis: String,
    var penerbit: String,
    var chapter: List<ChapterData>,
    var sinopsis: String,
    var tagGenre: Genre
)

data class ChapterData(
    val idChapter: Int,
    val title: String,
    val isi: String,
    val waktu: Int
)

enum class Genre{
    Romantis,
    Fantasi,
    Horor,
    Sejarah,
}
