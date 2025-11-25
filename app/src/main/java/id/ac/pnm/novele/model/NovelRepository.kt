package id.ac.pnm.novele.model

import id.ac.pnm.novele.R

class NovelRepository {
    fun fetchNovelData(): List<NovelData> {
        return listOf(
            NovelData("1",R.drawable.ic_launcher_background, "Makan Sate", 2,1, 1,5),
            NovelData("2",R.drawable.ic_launcher_background, "Makan Bakso", 2,1, 1,5),
            NovelData("3",R.drawable.ic_launcher_background, "Makan Mie Ayam", 2,1, 1,5),
            NovelData("4",R.drawable.ic_launcher_background, "Makan Soto", 2,1, 1,5),
            NovelData("5",R.drawable.ic_launcher_background, "Makan Ayam Goreng", 2,1, 1,5),
        )
    }
}