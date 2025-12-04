package id.ac.pnm.novele.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.pnm.novele.R
import id.ac.pnm.novele.view.detail.DetailFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null) {

            val fragment = DetailFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerDetail, fragment)
                .commit()
        }
    }

    // tempat untuk mendefinisikan variabel tetap mirip define di php jadi nanti tinggal manggil kelas.variabel

    companion object {
        const val ID_NOVEL = "ID_NOVEL"
    }
}