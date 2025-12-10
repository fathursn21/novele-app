package id.ac.pnm.novele.data.repository.novel

import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.ChapterData
import id.ac.pnm.novele.data.model.novel.Genre
import id.ac.pnm.novele.data.model.novel.NovelData

class NovelRepository {
    private lateinit var _allNovels: List<NovelData>
    fun fetchNovelData(): List<NovelData> {
        val chaptersNovelId1 = listOf(
            ChapterData(12, "Akhir dari Pencarian", 1),
            ChapterData(11, "Menuju Titik Balik", 2),
            ChapterData(10, "Pengkhianatan yang Terungkap", 3),
            ChapterData(9, "Rencana Pelarian", 4),
            ChapterData(8, "Negosiasi di Malam Hari", 5),
            ChapterData(7, "Munculnya Sosok Tak Terduga", 6),
            ChapterData(6, "Terjebak di Reruntuhan Kuno", 7),
            ChapterData(5, "Pengejaran di Tengah Hutan", 8),
            ChapterData(4, "Petunjuk dari Surat Rahasia", 9),
            ChapterData(3, "Pertemuan di Bawah Pohon Tua", 10),
            ChapterData(2, "Misteri Hilangnya Kunci", 11),
            ChapterData(1, "Awal Mula Kisah", 12)
        )

        val chaptersNovelId2 = listOf(
            ChapterData(5, "Pengejaran di Tengah Hutan", 8),
            ChapterData(4, "Petunjuk dari Surat Rahasia", 9),
            ChapterData(3, "Pertemuan di Bawah Pohon Tua", 10),
            ChapterData(2, "Misteri Hilangnya Kunci", 11),
            ChapterData(1, "Awal Mula Kisah", 12)
        )

        val listNovel = listOf(
            NovelData("1", R.drawable.ic_launcher_background, "Makan Sate","Roger","Moonton", chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("2", R.drawable.ic_baseline_home_24, "Makan Bakso", "Alucard","Moonton",chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Sejarah),
            NovelData("3", R.drawable.ic_baseline_star_24, "Makan Mie Ayam", "Bane","Moonton",chaptersNovelId1,   "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("4", R.drawable.ic_baseline_settings_24, "Makan Soto","Gusion","Moonton", chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Horor),
            NovelData("5", R.drawable.ic_baseline_search_24, "Makan Ayam Goreng","Lancelot","Moonton", chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("6", R.drawable.ic_baseline_cancel_24, "Nasi Goreng","Lapu-Lapu","Moonton", chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Fantasi),
            NovelData("7", R.drawable.ic_launcher_foreground, "Sate Ayam", "Lolita","Moonton", chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("8", R.drawable.ic_baseline_person_24, "Bakso Urat", "Hylos","Moonton", chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Horor),
        )
        _allNovels = listNovel

        return listNovel
    }

    //untuk search novel terus di lowercase biar kalau ada typo tetep ada hasil
    fun getSearchNovel(searchText: String): List<NovelData> {
        if (!this::_allNovels.isInitialized) {
            fetchNovelData()
        }
        var hasilSearchFilter = _allNovels
        if (searchText.isNotEmpty()) {
            val lowerCaseSearch = searchText.lowercase()
            hasilSearchFilter = hasilSearchFilter.filter {
                it.judulNovel.lowercase().contains(lowerCaseSearch)
            }
        } else{
            return _allNovels
        }

        return hasilSearchFilter
    }
    //ngambil id novel kalau datanya belum ada di _allNovel langsung ambil pakai bantuan fungsi teman-temannya
    fun getNovelById(id: String?): NovelData? {
        if (!this::_allNovels.isInitialized) {
            fetchNovelData()
        }
        return _allNovels.find { it.id == id }
    }

    //mengurutkan novel dengan chapter terbanyak dan tersedikit atau tersedikit ke terbanyak dengan sortBy
    fun getNovelByChapterCount(ascending: Boolean): List<NovelData> {
        if (!this::_allNovels.isInitialized) {
            fetchNovelData()
        }

        return if (ascending) {
            _allNovels.sortedBy { it.chapter.size }
        } else {
            _allNovels.sortedByDescending { it.chapter.size }
        }
    }
}