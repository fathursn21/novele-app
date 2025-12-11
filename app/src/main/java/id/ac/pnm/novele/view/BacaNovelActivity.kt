package id.ac.pnm.novele.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.pnm.novele.R

class BacaNovelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_baca_novel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewIsiChapterBacaNovel : TextView = findViewById(R.id.textViewIsiChapterBacaNovel)
        val imageViewBackBacaNovel : ImageView = findViewById(R.id.imageViewBackBacaNovel)
        imageViewBackBacaNovel.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        textViewIsiChapterBacaNovel.text = """
            ---  Bab IV: Gerbang Senyap menuju Aethelgard

            --- Kedatangan di Lembah Sembunyi

            Matahari telah tergelincir di balik Puncak Kembar, mewarnai langit dengan gradasi jingga dan ungu yang melankolis. Debu halus gurun menyambut setiap langkah Sir Kaelen, memeluk bot kulit usangnya. Sudah hampir dua bulan ia menyusuri Jalur Tandus, hanya berbekal peta yang sketsanya seburuk teka-teki kuno.

            "Di sinilah, Jax. Lembah Sembunyi," bisik Kaelen pada kudanya, suaranya serak karena kehausan. Ia menunjuk ke celah sempit di antara dua formasi batu pasir raksasa yang tampak seperti dua rahang bumi yang mengatup.

            Setelah melewati celah tersebut, dunia seakan berubah. Panas gurun digantikan oleh kelembapan yang dingin, dan bau pasir berganti dengan aroma lumut dan air tawar yang samar. Kaelen menemukan dirinya berada di sebuah ngarai tersembunyi, di mana air terjun tipis menetes dari tebing, memelihara hutan kecil yang subur—oasis yang mustahil.

            --- Menemukan Relief Pembimbing

            Di bawah gemuruh air terjun mini itu, tersembunyi sebuah dinding batu yang ditutupi oleh tumbuhan merambat. Dengan hati-hati, Kaelen membersihkan vegetasi tersebut, memperlihatkan sebuah relief yang megah.

            Relief itu menggambarkan sebuah peradaban yang hilang: figur-figur tinggi dengan jubah mengalir, memuja matahari dan bulan yang disatukan oleh sebuah lambang berbentuk kunci melingkar. Di bagian bawah relief, ada serangkaian simbol yang ia kenali sebagai dialek prasejarah dari bahasa Eldoria – bahasa yang ia pelajari selama sepuluh tahun dari gulungan-gulungan tua di perpustakaan kerajaan.

            Kaelen mengeluarkan buku catatannya yang lusuh. Ia mulai menerjemahkan, setiap kata terucap pelan, seperti mantra:

            "Ketika Tiga Bintang sejajar di atas Cermin Air, pintu ke Aethelgard akan terbuka. Sang Penjaga tidak tidur, tapi dia tidak peduli pada orang yang membawa hati yang bimbang. Kunci adalah Cahaya, Waktu adalah Jembatan, dan Hanya yang Berani yang akan Melihat Kota Emas Abadi..."

            Kaelen melihat sekeliling. Tiga Bintang? Cermin Air? Dia melihat genangan air di kakinya, memantulkan cahaya sisa senja. Ia menyadari bahwa malam itu adalah malam di mana tiga bintang paling terang di rasi bintang Draco akan sejajar sempurna. Waktunya tepat.

            ### Ujian Jembatan Waktu

            Ia melanjutkan pencarian, menyusuri ngarai hingga mencapai tepi jurang yang dalam. Di seberangnya, tampaklah siluet samar struktur buatan manusia—atap, menara yang patah, dan dinding batu obsidian. Itulah Aethelgard.

            Jembatan yang seharusnya menghubungkan kedua sisi jurang itu sudah runtuh ribuan tahun yang lalu. Hanya tersisa pilar-pilar batu yang menjulang dari kegelapan. Kaelen menghela napas. Ia tahu ujian sebenarnya baru saja dimulai.

            Di pilar terdekat, ia melihat sebuah mekanisme kuno. Itu adalah batu keseimbangan yang memerlukan tekanan yang tepat untuk mengaktifkan proyektor cahaya. Kaelen harus menempatkan sesuatu yang berat, tapi tidak terlalu berat. Dia ingat kutipan itu: "Kunci adalah Cahaya."

            Dia mengeluarkan perangkat kristal yang ia temukan di reruntuhan kuil di selatan. Kristal itu dikenal sebagai Sunstone, yang mampu menyerap dan memancarkan cahaya matahari yang tersimpan.

            Saat ia meletakkan kristal itu di mekanisme, kristal itu bersinar dengan intensitas yang membutakan. Sinar cahaya biru murni melesat dari kristal, menyentuh pilar-pilar yang runtuh. Pilar-pilar itu, yang sebelumnya tampak mati, kini bersinar. Dalam hitungan detik, sebuah jembatan yang terbuat dari energi murni, berkilauan seperti fatamorgana di gurun, terwujud di hadapannya.

            "Jembatan Waktu," gumam Kaelen, merasakan tarikan energi kuno itu.

            ### Memasuki Aethelgard

            Langkah pertama Kaelen di atas jembatan terasa dingin dan bergetar. Dia tahu jika konsentrasinya goyah, atau jika kristal itu kehabisan energi, ia akan jatuh ke jurang tak berdasar di bawahnya.

            Akhirnya, ia mencapai sisi seberang. Jembatan energi itu lenyap di belakangnya, meninggalkan dia sendirian di gerbang Aethelgard.

            Gerbang itu bukanlah gerbang pertahanan, melainkan gerbang sambutan. Itu terbuat dari perunggu yang ditutupi oleh lapisan tipis emas yang masih berkilauan meskipun diterpa usia. Di atasnya, terukir kata-kata:

            DI SINI, HATI YANG LELAH AKAN MENEMUKAN KEDAMAIAN ABADI, ATAU KEGELAPAN ABADI.

            Kaelen mendorong pintu gerbang yang, mengejutkannya, terbuka tanpa suara, seolah-olah baru saja diminyaki kemarin.

            Jalanan Aethelgard terbuat dari marmer hitam yang dipoles, yang memantulkan cahaya bulan seperti permukaan air. Kota itu tidak dihuni, tetapi tidak juga tampak hancur. Tidak ada puing, tidak ada kerusakan akibat perang. Bangunan-bangunannya utuh, perabotannya masih di tempatnya, seolah-olah penduduknya baru saja bangun dan pergi sarapan.

            Di tengah alun-alun utama, berdiri patung dewi yang terbuat dari gading, tangannya menunjuk ke menara tertinggi di kota—Menara Pengetahuan.

            Kaelen merasa merinding. Kota ini bukan hanya kota yang hilang; ini adalah kota yang terhenti dalam waktu. Terdengar desisan halus dari bayangan di antara kolom. Dia mengeluarkan belati peraknya, menyadari bahwa "Sang Penjaga" mungkin bukan hanya metafora.

            Langkahnya bergema di kesunyian Aethelgard, membawa beban harapan dan ketakutan para arkeolog selama berabad-abad. Dia berjalan menuju Menara Pengetahuan, tempat yang dia yakini menyimpan rahasia tentang mengapa kota ini menghilang, dan yang lebih penting, bagaimana ia bisa tetap begitu sempurna. Setiap lorong yang ia lewati adalah bisikan masa lalu yang membeku, menunggu nafas kehidupan untuk membangunkannya kembali.
            """
    }

}