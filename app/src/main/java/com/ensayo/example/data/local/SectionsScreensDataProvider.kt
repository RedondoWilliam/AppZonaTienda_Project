package com.ensayo.example.data.local

import androidx.compose.ui.res.stringResource
import com.ensayo.example.data.SectionScreen
import com.ensayo.example.data.SectionType
import com.example.ensayo.R

object SectionsScreensDataProvider {

    val elements = listOf(
        SectionScreen(
            sectionScreenType = SectionType.FloatingBottom ,
            descriptionCurrentScreen = R.string.element_ordena,

        ),
        SectionScreen(
            sectionScreenType = SectionType.FloatingBottom,
            descriptionCurrentScreen = R.string.element_carrito,
        ),
        SectionScreen(
            sectionScreenType = SectionType.FloatingBottom,
            descriptionCurrentScreen = R.string.element_gps,
        ),
        SectionScreen(
            sectionScreenType = SectionType.Promotions,
            descriptionCurrentScreen = R.string.element_promociones,
        ),
        SectionScreen(
            sectionScreenType = SectionType.StoresCard,
            descriptionCurrentScreen = R.string.element_vista_de_tiendas_section_sugerido_para_ti,
        ),
        SectionScreen(
            sectionScreenType = SectionType.DescriptionSection,
            descriptionCurrentScreen = R.string.element_sugerido_para_ti,
        ),
        SectionScreen(
            sectionScreenType = SectionType.DescriptionSection,
            descriptionCurrentScreen = R.string.element_tiendas_cerca,
        ),
        SectionScreen(
            sectionScreenType = SectionType.StoresCard,
            descriptionCurrentScreen = R.string.element_vista_de_tiendas_section_tiendas_cerca,
        ),
        SectionScreen(
            sectionScreenType = SectionType.StoresBottom,
            descriptionCurrentScreen = R.string.element_storesbottom,
            listItemsSectionScreen = StoresBottom.allValuesStoresBotton
        ),
        SectionScreen(
            sectionScreenType = SectionType.Options,
            descriptionCurrentScreen = R.string.storeOptions,
            listItemsSectionScreen = StoreOptions.allValuesStoreOptions
        ),


    )
}