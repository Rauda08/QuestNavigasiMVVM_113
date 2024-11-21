package com.example.percobaan7.viewmodel


import androidx.lifecycle.ViewModel
import com.example.percobaan7.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel(){
    inner class JenisKelamin(any: Any) {

    }

    private val _statusUI = MutableStateFlow(DataSiswa())
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                NIM = ls[1],
                email = ls[2],
                alamat = ls[3],
                gender = ls[4],
                notelepon = ls[5]
            )
        }
    }
}