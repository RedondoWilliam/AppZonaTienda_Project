package com.ensayo.example.data

import com.ensayo.example.data.local.ValuesSectionStoreOptions

data class SectionScreen(
    val sectionScreenType: SectionType,
    val descriptionCurrentScreen: Int,
    val listItemsSectionScreen: List<Any>? = null
)