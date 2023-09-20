package com.ensayo.example.data.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ensayo.R


object NearStoresSuggestForYOu {
    val allValuesNearStores = listOf(
        AllValuesStoreSuggestForYou(
            imageSubsectionPrincipal = R.drawable.peluquerias,
            nameStoreSubsection = R.string.peluquerias,
            nearStoresForYou = R.string.sitios_cerca
        ),
        AllValuesStoreSuggestForYou(
            imageSubsectionPrincipal = R.drawable.tintorerias,
            nameStoreSubsection = R.string.tintorerias,
            nearStoresForYou = R.string.sitios_cerca
        ),
        AllValuesStoreSuggestForYou(
            imageSubsectionPrincipal = R.drawable.spa,
            nameStoreSubsection = R.string.spa,
            nearStoresForYou = R.string.sitios_cerca
        ),
        AllValuesStoreSuggestForYou(
            imageSubsectionPrincipal = R.drawable.panaderias,
            nameStoreSubsection = R.string.panaderias,
            nearStoresForYou = R.string.sitios_cerca
        ),

    )
}

data class AllValuesStoreSuggestForYou(
    @DrawableRes val imageSubsectionPrincipal: Int,
    @StringRes val nameStoreSubsection: Int,
    @StringRes val nearStoresForYou: Int,
)