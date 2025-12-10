package id.ac.pnm.novele.view.diary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryChapterData
import id.ac.pnm.novele.data.repository.diary.DiaryChapterRepository
import id.ac.pnm.novele.data.repository.diary.DiaryRepository

class DiaryChapterEditorActivity : AppCompatActivity() {
    private var DiaryRepository = DiaryRepository()
    private var DiaryChapterRepository = DiaryChapterRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diary_chapter_editor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageViewBackArrowIcon = findViewById<ImageView>(R.id.imageViewBackArrowIcon)
        imageViewBackArrowIcon.setOnClickListener {
            finish()
        }

        val diaryId = intent.getStringExtra("diaryId")
        val textViewHeaderDiaryEditor = findViewById<TextView>(R.id.textViewHeaderDiaryEditor)

        val editTextJudulChapter = findViewById<EditText>(R.id.editTextJudulChapter)
        val editTextChapterContent = findViewById<EditText>(R.id.editTextChapterContent)
        val buttonSaveDiaryChapter = findViewById<Button>(R.id.buttonSaveDiaryChapter)

        if (diaryId != null){
            val rowDiary = DiaryRepository.getDiaryById(diaryId)

            if (rowDiary != null){
                val chapterCount = DiaryChapterRepository.countChapterByDiaryId(diaryId) + 1
                textViewHeaderDiaryEditor.text = "Chapter $chapterCount"

                buttonSaveDiaryChapter.setOnClickListener {
                    val judulChapter = editTextJudulChapter.text.toString().trim()
                    val chapterContent = editTextChapterContent.text.toString().trim()

                    if (judulChapter.isEmpty()){
                        editTextJudulChapter.error = "Judul chapter tidak boleh kosong"
                        return@setOnClickListener
                    }
                    if (chapterContent.isEmpty()){
                        editTextChapterContent.error = "isi chapter tidak boleh kosong"
                        return@setOnClickListener
                    }

                    val newChapterDiary = DiaryChapterData(
                        System.currentTimeMillis().toString(),
                        diaryId,
                        chapterCount,
                        judulChapter,
                        chapterContent,
                        1
                    )

                    DiaryChapterRepository.addChapterDiary(newChapterDiary)

                    finish()
                }
            }

        }



    }
}