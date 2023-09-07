package com.ensayo.example.data.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ensayo.R


object NearStoresValues {
    val allValuesNearStores = listOf(
       AllValuesNearStoresOptions(
           imageSubsectionPrincipal = R.drawable.image_near_store_first,
           nameStoreSubsection = R.string.element_nameitem_nearstore_first,
           productsStoreSubsection = R.string.element_descriptionresumestore_nearstore_first,
           likesScoreStoreSubsection = R.string.element_likes_score_first,
           stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_first,
           statePositionNearYouStoreSubsection = R.string.element_estimated_position_nearstore_first,
           startsScoreStoreSubsection = R.string.element_starts_score_first
       ),
        AllValuesNearStoresOptions(
            imageSubsectionPrincipal = R.drawable.image_near_store_second,
            nameStoreSubsection = R.string.element_nameitem_nearstore_second,
            productsStoreSubsection = R.string.element_descriptionresumestore_nearstore_second,
            likesScoreStoreSubsection = R.string.element_likes_score_second,
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_second,
            statePositionNearYouStoreSubsection = R.string.element_estimated_position_nearstore_second,
            startsScoreStoreSubsection = R.string.element_starts_score_first
        ),
        AllValuesNearStoresOptions(
            imageSubsectionPrincipal = R.drawable.image_near_store_thirst,
            nameStoreSubsection = R.string.element_nameitem_nearstore_third,
            productsStoreSubsection = R.string.element_descriptionresumestore_nearstore_third,
            likesScoreStoreSubsection = R.string.element_likes_score_third,
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_third,
            statePositionNearYouStoreSubsection = R.string.element_estimated_position_nearstore_third,
            startsScoreStoreSubsection = R.string.element_starts_score_first
        ),
        AllValuesNearStoresOptions(
            imageSubsectionPrincipal = R.drawable.image_near_store_four,
            nameStoreSubsection = R.string.element_nameitem_nearstore_four,
            productsStoreSubsection = R.string.element_descriptionresumestore_nearstore_four,
            likesScoreStoreSubsection = R.string.element_likes_score_four,
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_four,
            statePositionNearYouStoreSubsection = R.string.element_estimated_position_nearstore_four,
            startsScoreStoreSubsection = R.string.element_starts_score_first
        ),
    )
}
data class AllValuesNearStoresOptions(
    @DrawableRes val imageSubsectionPrincipal: Int,
    @StringRes val nameStoreSubsection: Int,
    @StringRes val productsStoreSubsection: Int,
    @StringRes val likesScoreStoreSubsection: Int,
    @StringRes val stateOpenCloseStoreSubsection: Int,
    @StringRes val statePositionNearYouStoreSubsection: Int,
    @StringRes val startsScoreStoreSubsection: Int,
)