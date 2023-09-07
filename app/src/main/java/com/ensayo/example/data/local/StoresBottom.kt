package com.ensayo.example.data.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ensayo.R

object StoresBottom {
    val allValuesStoresBotton = listOf(
        allValuesStoresBottomItem(
            imageSubSectionPrincipal = R.drawable.bares,
            titleSubSectionPrincipal = R.string.element_bares,
            subTitleSubSectionPrincipal = R.string.element_entretenimiento
        ),
        allValuesStoresBottomItem(
            imageSubSectionPrincipal = R.drawable.restaurantes,
            titleSubSectionPrincipal = R.string.element_restaurantes,
            subTitleSubSectionPrincipal = R.string.element_sitios_de_comida
        ),
        allValuesStoresBottomItem(
            imageSubSectionPrincipal = R.drawable.parqueaderos,
            titleSubSectionPrincipal = R.string.element_parqueaderos,
            subTitleSubSectionPrincipal = R.string.element_estancia
        )
    )
}


data class allValuesStoresBottomItem(
    @DrawableRes val imageSubSectionPrincipal: Int,
    @StringRes val titleSubSectionPrincipal: Int,
    @StringRes  val subTitleSubSectionPrincipal: Int
)
