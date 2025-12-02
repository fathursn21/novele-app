package id.ac.pnm.novele.data.repository.novel

import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.NovelData

class NovelRepository {
    private lateinit var _allNovels: List<NovelData>
    fun fetchNovelData(): List<NovelData> {
        val listNovel = listOf(
            NovelData("1", R.drawable.ic_launcher_background, "Makan Sate", 2, 1, 1, 5),
            NovelData("2", R.drawable.ic_baseline_home_24, "Makan Bakso", 2, 1, 1, 5),
            NovelData("3", R.drawable.ic_baseline_star_24, "Makan Mie Ayam", 2, 1, 1, 5),
            NovelData("4", R.drawable.ic_baseline_settings_24, "Makan Soto", 2, 1, 1, 5),
            NovelData("5", R.drawable.ic_baseline_search_24, "Makan Ayam Goreng", 2, 1, 1, 5),
            NovelData("6", R.drawable.ic_baseline_cancel_24, "Nasi Goreng", 2, 1, 1, 5),
            NovelData("7", R.drawable.ic_launcher_foreground, "Sate Ayam", 2, 1, 1, 5),
            NovelData("8", R.drawable.ic_baseline_person_24, "Bakso Urat", 2, 1, 1, 5),
        )
        _allNovels = listNovel

        return listNovel
    }

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
}