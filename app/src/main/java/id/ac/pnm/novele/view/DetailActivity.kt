package id.ac.pnm.novele.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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
        val imageViewBackArrowIcon: ImageView = findViewById(R.id.imageViewBackArrowIcon)
        val imageViewDetailHomeIcon: ImageView = findViewById(R.id.imageViewDetailHomeIcon)
        //biar mirip kyk nekan tombol back
        imageViewBackArrowIcon.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        //balik ke home
        imageViewDetailHomeIcon.setOnClickListener {
            detailHome()
        }
    }
    private fun detailHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val ID_NOVEL = "ID_NOVEL"
    }
}