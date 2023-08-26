package com.ensayo.example.ui

import com.ensayo.example.data.NavigationType
import com.ensayo.example.data.SectionScreen
import com.ensayo.example.data.SectionType
import com.ensayo.example.data.local.SectionsScreensDataProvider

data class EnsayoUiState(
    val descriptionCurrentScreen: List<SectionScreen> = SectionsScreensDataProvider.elements,
    val isShowingHomeScreen: Boolean = true,
    val currentEnsayoBoxType: NavigationType = NavigationType.INICIO
)