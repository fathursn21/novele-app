package id.ac.pnm.novele.viewmodel.novel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.data.model.novel.NovelData
import id.ac.pnm.novele.data.repository.novel.NovelRepository

class NovelViewModel : ViewModel() {

    private val _novelData = MutableLiveData<List<NovelData>>()
    val novelData: LiveData<List<NovelData>> = _novelData

    private val _searchResult = MutableLiveData<List<NovelData>>()
    val searchResult: LiveData<List<NovelData>> = _searchResult

    val novelRepository: NovelRepository = NovelRepository()
    fun getNovelData() {
        if (_novelData.value.isNullOrEmpty()){
            val novelResult = novelRepository.fetchNovelData()
            _novelData.postValue((novelResult))
        }
    }
    //update daftar novel sesuai hasil search
    fun searchNovel(query: String) {
        val searchResultList = novelRepository.getSearchNovel(query)
        _searchResult.postValue(searchResultList)
    }
    //hapus hasil search
    fun clearSearchResult() {
        _searchResult.value = emptyList()
    }
}