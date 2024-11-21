package com.example.percobaan7

import com.example.percobaan7.model.JenisKelamin.jenisKelamin
import com.example.percobaan7.ui.view.FormulirView
import com.example.percobaan7.ui.view.TampilDataView
import com.example.percobaan7.viewmodel.SiswaViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val context = LocalContext.current
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        modifier = modifier.padding(16.dp),
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ){
        composable(
            route = Halaman.FORMULIR.name
        ){
            FormulirView(
                listJK = jenisKelamin.map { id ->
                    context.getString(id)
                                          },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name){
            TampilDataView(uiState = uiState, onBackButton = {
                navHost.popBackStack()
            })
        }
    }
}

