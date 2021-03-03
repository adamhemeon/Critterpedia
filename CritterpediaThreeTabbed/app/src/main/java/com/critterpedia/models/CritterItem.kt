package com.critterpedia.models

/**
 * An abstract critter item representing a piece of content.
 *
 * Google Doc Read Me
 *
 * https://tinyurl.com/acnh-sheet <- base URL
 * https://docs.google.com/spreadsheets/d/13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4/edit#gid=622143695
 */
abstract class CritterItem(

    val type: String,
    val id: Int,
    val fileName: String,
    val price: Int,
    val catchPhrase: String,
    val museumPhrase: String,
    val image_uri: String,
    val icon_uri: String

) {
    abstract override fun toString(): String
}