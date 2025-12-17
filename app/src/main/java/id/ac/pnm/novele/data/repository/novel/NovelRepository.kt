package id.ac.pnm.novele.data.repository.novel

import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.ChapterData
import id.ac.pnm.novele.data.model.novel.Genre
import id.ac.pnm.novele.data.model.novel.NovelData

class NovelRepository {
    // variabel allNovels diinisiakan setelah onCreateView
    private lateinit var _allNovels: List<NovelData>
    fun fetchNovelData(): List<NovelData> {
        val chaptersNovelId1 = listOf(
            ChapterData(12, "Akhir dari Pencarian", "m",   1),
            ChapterData(11, "Menuju Titik Balik","m", 2),
            ChapterData(10, "Pengkhianatan yang Terungkap", "m",3),
            ChapterData(9, "Rencana Pelarian","m", 4),
            ChapterData(8, "Negosiasi di Malam Hari","m", 5),
            ChapterData(7, "Munculnya Sosok Tak Terduga","m", 6),
            ChapterData(6, "Terjebak di Reruntuhan Kuno","m", 7),
            ChapterData(5, "Pengejaran di Tengah Hutan", "m",8),
            ChapterData(4, "Petunjuk dari Surat Rahasia","m", 9),
            ChapterData(3, "Pertemuan di Bawah Pohon Tua", "m",10),
            ChapterData(2, "Misteri Hilangnya Kunci", "m",11),
            ChapterData(1, "Awal Mula Kisah","m", 12)
        )

        val chaptersNovelId2 = listOf(
            ChapterData(5, "Pengejaran di Tengah Hutan","m", 8),
            ChapterData(4, "Petunjuk dari Surat Rahasia","m", 9),
            ChapterData(3, "Pertemuan di Bawah Pohon Tua", "m",10),
            ChapterData(2, "Misteri Hilangnya Kunci", "m",11),
            ChapterData(1, "Awal Mula Kisah","m", 12)
        )

        val listNovel = listOf(
            NovelData("1",
                R.drawable.f_eragon,
                "Eragon",
                "Christopher Paolini",
                "Gramedia Pustaa Utama",
                chaptersNovelId1,
                "Aku berpikir lama dan mendalam selama beberapa hari terakhir, dan kusadari apa artinya menjadi naga dan Penunggang: sudah menjadi takdir kita untuk mencoba yang mustahil, melakukan perbuatan-perbuatan besar tanpa memedulikan rasa takut. Itulah tanggung jawab kita pada masa depan.\n" +
                        "\n" +
                        "Suatu hari Eragon, anak petani miskin berusia lima belas tahun, menemukan “batu” biru yang indah. Ternyata batu itu telur naga! Ditemani Brom si pendongeng tua dan naga yang dinamainya Saphira, Eragon belajar berbagai hal mengenai sejarah dan naga. Brom juga mengajarkan ilmu sihir dan ilmu pedang karena ternyata Eragon adalah penerus klan para Penunggang Naga. Klan ini punah akibat ditumpas Raja Galbatorix yang kejam.\n" +
                        "\n" +
                        "Berbekal ilmu dari Brom, Eragon bertekad membangun kembali klan Penunggang Naga, meskipun itu berarti ia harus menghadapi berbagai makhluk ajaib seperti elf, kurcaci, Urgal, Ra’zac, dan Shade, yang memiliki ilmu jauh lebih tinggi daripada dirinya.",
                Genre.Fantasi),
            NovelData("2",
                R.drawable.f_kota_seribu_lantai_dewi_intan_86000,
                "Kota Seribu Lantai",
                "Dewi Intan",
                "selfietera indonesia",
                chaptersNovelId1,
                "Erin, seorang perempuan yatim piatu pekerja kantoran yang tinggal bersama adiknya, usai ditinggal pergi Kakek yang menjaga mereka sedari kecil untuk selama-lamanya. Demi memenuhi kebutuhan hidup dan menabung untuk biaya kuliah adik, Erin melupakan hasratnya untuk keluar, dengan menyibukkan diri di kantor bersama sahabainya, sembari berhadapan dengan Pak Bos yang kerap memarahi dan menegurnya.\n" +
                        "\n" +
                        "Suatu hari, Erin menemukan Pohon Raksasa yang membawanya ke dunia ajaib. Di Pohon Raksasa ini, Erin mengalami pengalaman ajaib dengan menelusuri fasilitas layaknya di kota metropolitan. Erin mendapatkan misi dari Pohon Raksasa untuk menyelesaikan semua masalah dari masa lalunya. Apakah Erin akan berhasil menyelesaikan misi dari Pohon Raksasa? Dan apakah Erin akan bertemu dengan Kakek yang ia rindukan selama ini?",
                Genre.Fantasi),
            NovelData("3",
                R.drawable.f_enchantress,
                "The Enchantress",
                "Michael Scott",
                "Qantara",
                chaptersNovelId1,
                "Hidup Nicholas dan Perenelle Flamel tersisa satu hari lagi, namun masih ada pekerjaan yang harus dilakukan. Mereka harus mempertahankan San Francisco. Monster-monster yang terkumpul di Pulau Alcatraz telah dilepas dan dalam perjalanan ke kota. Jika tidak dihentikan, mereka akan menghancurkan segala sesuatu yang mereka lalui, termasuk manusia.\n" +
                        "\n" +
                        "Meskipun mendapatkan bantuan dari dua prajurit terbesar dalam sejarah dan mitos, dapatkah sang Sorceress dan sang Alchemyst mempertahankan kota? Ataukah ini awal dari kehancuran humani?\n" +
                        "\n" +
                        "Danu Talis:\n" +
                        "Sophie dan Josh Newman melakukan perjalanan sepuluh ribu tahun ke masa lalu ke Danu Talis saat mereka mengikuti Dr. John Dee dan Virginia Dare. Dan di pulau legendaris inilah pertempuran bagi dunia dimulai dan berakhir.\n" +
                        "\n" +
                        "Scathach, Prometheus, Palamedes, Shakespeare, Saint-Germain, dan Joan of Arc juga ada di pulau itu. Namun, tak ada yang yakin apaatau siapayang akan dibela oleh si kembar.\n" +
                        "\n" +
                        "Inilah penentuan apakah pertempuran untuk Danu Talis akan dimenangkan atau justru dikalahkan. Akankah si kembar di pihak yang sama? Ataukah mereka akan saling berperang? Satu dari si kembar akan menyelamatkan dunia, dan yang satu lagi akan menghancurkannya?",
                Genre.Fantasi),
            NovelData("4",
                R.drawable.h_perundungan_maut_ranissa_tya_82000,
                "Perundungan Maut",
                "Ranissa Tya",
                "Elex Media Komputindo",
                chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Horor),
            NovelData("5",
                R.drawable.h_sendang,
                "Sendang Banyu Getih",
                "Diosetta",
                "Anak Hebat Indonesia",
                chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Horor),
            NovelData("6",
                R.drawable.h_teluh,
                "Teluh Ilmu Hitam",
                "Wulan Wahyuning Ratri",
                "Anak Hebat Indonesia",
                chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Horor),
            NovelData("7",
                R.drawable.s_janji_di_tanah_jawa_agil_sri_rahayu_109000,
                "Janji Di Tanah Jawa",
                "Agil Sri Rahayu",
                "Skuad",
                chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Sejarah),
            NovelData("8",
                R.drawable.s_ken_arok_dan_ken_dedes_gamal_komandoko_80000,
                "Ken Arok Dan Ken Dedes",
                "Gamal Komandoko",
                "Narasi",
                chaptersNovelId1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Sejarah),
            NovelData("9",
                R.drawable.s_mahajana_gigrey_99000,
                "Mahajana",
                "Gigrey",
                "Kawah Media",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Sejarah),
            NovelData("10",
                R.drawable.r_lautmu_bukan_aku_lilpudu_99000,
                "Lagu Lautmu Bukan Aku",
                "Lilpudu",
                "Tekad",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("11",
                R.drawable.r_mengikhlaskan,
                "Mengikhlaskanmu Adalah Caraku Mencintaimu",
                "Pelukis Kata",
                "Snowball",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("12",
                R.drawable.r_neraka,
                "Neraka Di Dalam SurgaKu",
                "Ratu Dhyah",
                "Wahyu Qolbu",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("13",
                R.drawable.r_pelabuhan_hati_nur_hairiah_129000,
                "Pelabuhan Hati",
                "Nur Hairiah",
                "Wahyu Qolbu",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Romantis),
            NovelData("14",
                R.drawable.s_mein,
                "Mein Kampf: Perjuangan Saya",
                "Adolf Hitler",
                "Anak Hebat Indonesia",
                chaptersNovelId2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada quam diam, non condimentum felis convallis ut. Pellentesque turpis erat, rhoncus vel diam ut, condimentum sagittis dui. Maecenas sagittis non mi sit amet lacinia. Proin eget interdum tellus. Integer odio enim, pharetra ut diam commodo, dignissim vulputate tortor. Fusce gravida consequat faucibus. Nullam pharetra quam ac sem posuere, eget sagittis tortor ornare.",
                Genre.Sejarah),
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