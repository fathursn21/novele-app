package id.ac.pnm.novele.viewmodel.novel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.data.model.novel.NovelData
import id.ac.pnm.novele.data.repository.novel.NovelRepository

class NovelViewModel : ViewModel() {

    private val _novelData = MutableLiveData<List<NovelData>>()
    val novelData: LiveData<List<NovelData>> = _novelData
    val novelRepository: NovelRepository = NovelRepository()
    fun getNovelData() {
        if (_novelData.value.isNullOrEmpty()){
            val novelResult = novelRepository.fetchNovelData()
            _novelData.postValue((novelResult))
        }
    }
}