package com.example.barradenavegacion.ui.theme

import com.example.barradenavegacion.data.SearchWidgetState

data class UiStateTopBAr (
    var stateSearchBar: SearchWidgetState = SearchWidgetState.CLOSED,
    var searchTextState: String = "",
)