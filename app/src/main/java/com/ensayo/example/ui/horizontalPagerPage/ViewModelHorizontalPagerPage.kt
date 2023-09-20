package com.ensayo.example.ui.horizontalPagerPage

import androidx.lifecycle.ViewModel
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.UiStateTopBAr
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ViewModelHorizontalPagerPage: ViewModel() {

    private val _uiState = MutableStateFlow(UiStateHorizontalPagerPage())
    val uiState: StateFlow<UiStateHorizontalPagerPage> = _uiState


    fun updateStateHorizontalPager(page: PagesHorizontalPagerPage){
        _uiState.update {
            it.copy(
                stateHorizontalPager = page
            )
        }
    }

    fun updateNamePage(newValue: Int){
        _uiState.update {
            it.copy(
                namePage = newValue
            )
        }
        asignedPageTopNavigation()
    }

    fun asignedPageTopNavigation(){
        when(uiState.value.namePage){
            0 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.HOME)
            1 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.MIS_TIENDAS)
            2 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.DOMICILIO)
            3 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.PREGUNTAME)
            4 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.DEVOLUCIONES)
            5 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.ACTIVIDAD)
            6 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.PARCHE)
            7 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.TRABAJOS)
            8 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.OFERTAS)
            9 -> updateStateHorizontalPager(page = PagesHorizontalPagerPage.EVENTOS)
        }
    }

}