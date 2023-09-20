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
            descriptionSubSection = R.string.description_estas_aqui,
            idItemSubsection = R.string.id_home
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.tus_tiendas,
            nameSubSection = R.string.element_tus_tiendas,
            descriptionSubSection = R.string.description_tus_tiendas,
            idItemSubsection = R.string.id_mis_tiendas
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.delivery,
            nameSubSection = R.string.element_domicilio,
            descriptionSubSection = R.string.description_domicilio,
            idItemSubsection = R.string.id_domicilio
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.preguntame,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_preguntame
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.return_svgrepo_com,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_devoluciones
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.status_waiting_svgrepo_com,
            nameSubSection = R.string.element_preguntame,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_actividad
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.parche,
            nameSubSection = R.string.name_item_parche,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_parche
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.trabajos,
            nameSubSection = R.string.name_item_trabajos,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_trabajos
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.ofertas,
            nameSubSection = R.string.name_item_ofertas,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_ofertas
        ),
        ValuesSectionStoreOptions(
            imageSubSection = R.drawable.eventos,
            nameSubSection = R.string.name_item_eventos,
            descriptionSubSection = R.string.description_preguntame,
            idItemSubsection = R.string.id_eventos
        ),



    )
}

data class ValuesSectionStoreOptions(
    @DrawableRes val imageSubSection: Int,
    @StringRes val nameSubSection: Int,
    @StringRes val descriptionSubSection: Int,
    @StringRes  val idItemSubsection: Int,

)

