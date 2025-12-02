package id.ac.pnm.novele.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//untuk menyimpan value search biar memudahkan pengiriman data antar fragemnt karena ga bisa pake intent bang
class SearchViewModel : ViewModel(){
    val query = MutableLiveData<String>()
}