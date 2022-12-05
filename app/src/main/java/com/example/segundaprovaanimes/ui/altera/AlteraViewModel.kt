package com.example.segundaprovaanimes.ui.altera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundaprovaanimes.model.Anime
import com.example.segundaprovaanimes.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlteraViewModel @Inject constructor(var repository: AnimeRepository) : ViewModel() {

    //lateinit var anime : LiveData<Anime>

   // var anime : LiveData<Anime> = Anime("", 0, "", 0, "","")

    private var _anime = MutableLiveData<LiveData<Anime>>()
    val anime : LiveData<LiveData<Anime>>
    get() = _anime

    private var _initId = MutableLiveData<Long>()
    val initId : LiveData<Long>
        get() = _initId


    init {
        //anime.value = Anime("", 0, "", 0, "","")
        viewModelScope.launch(Dispatchers.IO){
            _anime.postValue(repository.findById(1))
        }

    }

//    fun alteraButtonEvent(){
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                anime.value?.let { repository.create(it) }
//            }
//        }
//    }

    fun changeValueId(id: Long){
        _initId.value = id
    }
}