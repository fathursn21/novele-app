package id.ac.pnm.novele.view

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData
import id.ac.pnm.novele.data.repository.diary.DiaryRepository

class DiaryEditorActivity : AppCompatActivity() {

    private lateinit var imageViewDiaryCover: ImageView
    private lateinit var buttonEditDiaryCover : ImageButton

    val diaryRepository: DiaryRepository = DiaryRepository()

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

        Log.d("DiaryEditorActivity", "onCreate called")

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
        val editTextDiaryPenulis = findViewById<EditText>(R.id.editTextPenulis)
        val edittextDIarySinposis = findViewById<EditText>(R.id.editTextSinopsis)
        buttonCreateDiary.setOnClickListener {
            val diaryTitle = editTextDiaryTitle.text.toString().trim()
            val diaryPenulis = editTextDiaryPenulis.text.toString().trim()
            val diarySinposis = edittextDIarySinposis.text.toString().trim()

            if (diaryTitle.isEmpty()){
                editTextDiaryTitle.error = "Judul diary tidak boleh kosong"
                return@setOnClickListener
            }
            if (diaryPenulis.isEmpty()){
                editTextDiaryPenulis.error = "Nama penulis tidak boleh kosong"
                return@setOnClickListener
            }
            if (diarySinposis.isEmpty()){
                edittextDIarySinposis.error = "Sinopsis diary tidak boleh kosong"
                return@setOnClickListener
            }

            val newDiary = DiaryData (
                System.currentTimeMillis().toString(),
                selectedCoverRequest,
                diaryTitle,
                diaryPenulis,
                emptyList(),
                diarySinposis
            )

            diaryRepository.addDiary(newDiary)

            finish()
        }


    }
}