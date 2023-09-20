package com.ensayo.example.ui.ElementsHomePage.navigationPanelControl

import androidx.lifecycle.ViewModel
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.UiStateTopBAr
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ViewModelNavigationPanelControl: ViewModel() {

    private val _uiState = MutableStateFlow(UiStateNavigationPanelControl())
    val uiState: StateFlow<UiStateNavigationPanelControl> = _uiState

    fun updateNavigationState(newValue: PrincipalNavigationState){
        _uiState.update {
            it.copy(
                statePrincipalNavigation = newValue
            )
        }
    }
}