package com.example.composeworksearcher.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composeworksearcher.R

sealed class MainScreen(
    val screenName: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Search : MainScreen("search", R.string.search, R.drawable.ic_round_search_24)
    object Favorite : MainScreen("favorite", R.string.favorite, R.drawable.ic_round_star_24)
    object Messages : MainScreen("messages", R.string.messages, R.drawable.ic_round_question_answer_24)
    object Profile : MainScreen("profile", R.string.profile,R.drawable.ic_round_account_circle_24)
}
