package com.ensayo.example.data.local

import android.app.LauncherActivity.ListItem
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.res.painterResource
import com.example.ensayo.R

object StoreOptions {
    val allValuesStoreOptions = listOf(
        ValuesSectionStoreOptions(
            imageSubSection =  R.drawable.estas_aqui_icon,
            nameSubSection = R.string.element_estas_aqui,
            descriptionSubSection = R.string.description_estas_aqui
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.tus_tiendas,
            nameSubSection = R.string.element_tus_tiendas,
            descriptionSubSection = R.string.description_tus_tiendas,
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.delivery,
            nameSubSection = R.string.element_domicilio,
            descriptionSubSection = R.string.description_domicilio
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.preguntame,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.return_svgrepo_com,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.status_waiting_svgrepo_com,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame
        ),


    )
}

data class ValuesSectionStoreOptions(
    @DrawableRes val imageSubSection: Int,
    @StringRes val nameSubSection: Int,
    @StringRes val descriptionSubSection: Int

)

