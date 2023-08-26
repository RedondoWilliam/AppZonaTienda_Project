package com.ensayo.example.data

data class SectionScreen(
    val sectionScreenType: SectionType,
    val descriptionCurrentScreen: Int,
    val listItemsSectionScreen: List<Int>? = null
)