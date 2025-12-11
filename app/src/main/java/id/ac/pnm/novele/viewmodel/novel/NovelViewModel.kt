package id.ac.pnm.novele.viewmodel.novel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.data.model.novel.ChapterData
import id.ac.pnm.novele.data.model.novel.Genre
import id.ac.pnm.novele.data.model.novel.NovelData
import id.ac.pnm.novele.data.repository.novel.NovelRepository

class NovelViewModel : ViewModel() {

    private val _novelData = MutableLiveData<List<NovelData>>()
    val novelData: LiveData<List<NovelData>> = _novelData

    private val _searchResult = MutableLiveData<List<NovelData>>()
    val searchResult: LiveData<List<NovelData>> = _searchResult

    private val _detailNovel = MutableLiveData<NovelData?>()
    val detailNovel: LiveData<NovelData?> = _detailNovel
    
    private val _chapterData = MutableLiveData<List<ChapterData>>()
    val chapterData: LiveData<List<ChapterData>> = _chapterData

    private val _totalChapter = MutableLiveData<Int>()
    val totalChapter: LiveData<Int> = _totalChapter

    private val _novelsSortedByChapter = MutableLiveData<List<NovelData>>()
    val novelsSortedByChapter: LiveData<List<NovelData>> = _novelsSortedByChapter

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
    //hapus hasil filter biar direset dari awal
    fun clearSortedResult() {
        _novelsSortedByChapter.value = emptyList()
    }

    //ngambil novel dari id di novelRepository terus mengisi LiveData detailNovel dengan nilai dari idResult
    fun loadNovelById(id: String?) {
        val idResult = novelRepository.getNovelById(id)
        _detailNovel.value = idResult

        //jaga-jaga kalau id nya tidak ada
        if (idResult != null) {
            _chapterData.value = idResult.chapter
            _totalChapter.value = idResult.chapter.size
        } else {
            _chapterData.value = emptyList()
            _totalChapter.value = 0
        }
    }

    //ascendant itu terbanyak ke tersedikit
    fun loadChaptersTerbanyak() {
        val sortedList = novelRepository.getNovelByChapterCount(ascending = false)
        _novelsSortedByChapter.postValue(sortedList)
    }
    //descendant itu tersedikit ke terbanyak
    fun loadChaptersTersedikit() {
        val sortedList = novelRepository.getNovelByChapterCount(ascending = true)
        _novelsSortedByChapter.postValue(sortedList)
    }
}