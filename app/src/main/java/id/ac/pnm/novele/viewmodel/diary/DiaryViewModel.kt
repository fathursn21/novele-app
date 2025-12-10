package id.ac.pnm.novele.viewmodel.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData
import id.ac.pnm.novele.data.model.novel.Genre
import id.ac.pnm.novele.data.repository.diary.DiaryRepository

class DiaryViewModel : ViewModel() {
    private val _diaryData = MutableLiveData<List<DiaryData>>()

    val diaryData: LiveData<List<DiaryData>> = _diaryData

    val diaryRepository: DiaryRepository = DiaryRepository()

    fun getDiaryData(){
        if (_diaryData.value.isNullOrEmpty()){
            val diaryResult = diaryRepository.fetchDiaryData()
            _diaryData.postValue((diaryResult))
        }
    }

    fun addDiary(title: String, penulis :String, sinopsis : String){
        val newDiary = DiaryData(
            System.currentTimeMillis().toString(),
            R.drawable.ic_launcher_background,
            title,
            penulis,
            emptyList(),
            sinopsis
        )

        diaryRepository.addDiary(newDiary)
        _diaryData.postValue(diaryRepository.fetchDiaryData())
    }
}