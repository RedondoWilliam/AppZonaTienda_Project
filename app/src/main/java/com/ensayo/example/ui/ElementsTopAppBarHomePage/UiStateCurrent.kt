package com.example.barradenavegacion.ui.theme

import androidx.compose.ui.focus.FocusRequester
import com.example.barradenavegacion.data.SearchWidgetState

data class UiStateCurrent (
    var stateSearchBar: SearchWidgetState = SearchWidgetState.CLOSED,
    var searchTextState: String = "",
)