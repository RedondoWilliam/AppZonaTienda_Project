package com.ensayo.example.ui.EnsayoApp

import androidx.lifecycle.ViewModel
import com.ensayo.example.data.NavigationType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class EnsayoViewModel : ViewModel() {
    private val _iuState = MutableStateFlow(EnsayoUiState())
    val uiState: StateFlow<EnsayoUiState> = _iuState



    fun resetHomeScreensStates(){
        _iuState.update {
            it.copy(
                isShowingHomeScreen = true
            )
        }
    }


    fun updateCurrentEnsayoBox(navigationType: NavigationType){
        _iuState.update {
            it.copy(currentEnsayoBoxType = navigationType)
        }
    }
}