package id.ac.pnm.novele.viewmodel.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.data.model.diary.DiaryData
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
}