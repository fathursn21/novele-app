package id.ac.pnm.novele.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData
import id.ac.pnm.novele.data.repository.diary.DiaryRepository

class DiaryEditorActivity : AppCompatActivity() {

    private lateinit var imageViewDiaryCover: ImageView
    private lateinit var buttonEditDiaryCover : ImageButton

    private var selectedCoverRequest:Int = R.drawable.ic_launcher_background

    // define launcher to listen action pick image in gallery
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        uri : Uri? ->
        if (uri != null){
            imageViewDiaryCover.setImageURI(uri)

            selectedCoverRequest = R.drawable.ic_launcher_background
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diary_editor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageViewDiaryCover = findViewById<ImageView>(R.id.imageViewDiaryCover)
        buttonEditDiaryCover = findViewById<ImageButton>(R.id.buttonEditDiaryCover)

        // set listener in edit cover diary
        buttonEditDiaryCover.setOnClickListener {
            // call launcher function cover where in filters all image
            pickImageLauncher.launch("image/*")
        }

        val buttonCancelEditDiary = findViewById<Button>(R.id.buttonCancelEditDiary)
        buttonCancelEditDiary.setOnClickListener {
            finish()
        }

        val buttonCreateDiary = findViewById<Button>(R.id.buttonCreateDiary)
        val editTextDiaryTitle = findViewById<EditText>(R.id.editTextDiaryTitle)
        buttonCreateDiary.setOnClickListener {
            val diaryTitle = editTextDiaryTitle.text.toString().trim()

            if (diaryTitle.isEmpty()){
                editTextDiaryTitle.error = "Judul diary tidak boleh kosong"
                return@setOnClickListener
            }

            val newDiary = DiaryData (
                System.currentTimeMillis().toString(),
                selectedCoverRequest,
                diaryTitle,
                0,
                0,
                0,
                0
            )

            DiaryRepository.addDiary(newDiary)

            finish()
        }


    }
}