package id.ac.pnm.novele.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ac.pnm.novele.R

class HomeActivity : AppCompatActivity() {

    private lateinit var rootView: View
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_home)

        rootView = findViewById(R.id.main)


        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val containerView : FragmentContainerView = findViewById(R.id.fragmentContainerHome)
        val bottomNavView : BottomNavigationView = findViewById(R.id.bottom_nav)

        val navHostFragment = containerView.getFragment<NavHostFragment>()
        navController = navHostFragment.navController

        bottomNavView.setupWithNavController(navController)
        cekPosisi()


    }
    private fun cekPosisi() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val fragmentName = destination.label ?: "tersesat"

            Toast.makeText(this, "$fragmentName", Toast.LENGTH_SHORT).show()
        }
    }

    // tempat untuk mendefinisikan variabel tetap mirip define di php jadi nanti tinggal manggil kelas.variabel
    companion object {
        const val DISPLAY_NAME = "DISPLAY_NAME"
    }
}