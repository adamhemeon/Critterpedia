package com.critterpedia.models

class BugItem(

    type: String,
    id: Int,
    fileName: String,
    val name: Name,
    val availability: Availability,
    price: Int,
    val priceFlick: Int,
    catchPhrase: String,
    museumPhrase: String,
    image_uri: String,
    icon_uri: String

) : CritterItem(type,id,fileName,price,catchPhrase,museumPhrase,image_uri,icon_uri) {

    class Availability(
        val monthNorthern: String,
        val monthSouthern: String,
        val time: String,
        val isAllDay: Boolean,
        val isAllYear: Boolean,
        val location: String,
        val rarity: String,
        val monthArrayNorthern: List<Int>,
        val monthArraySouthern: List<Int>,
        val timeArray: List<Int>
    )

    class Name(
        val nameUSen: String,
        val nameEUen: String,
        val nameCNzh: String,
        val nameEUde: String,
        val nameEUes: String,
        val nameEUfr: String,
        val nameEUit: String,
        val nameEUnl: String,
        val nameEUru: String,
        val nameJPja: String,
        val nameKRko: String,
        val nameTWzh: String,
        val nameUSes: String,
        val nameUSfr: String
    )

    override fun toString(): String {

        val builder: StringBuilder = StringBuilder()
        builder.append("Details about Bug: ")
        builder.append("\nPrice: ").append(price)
        builder.append("\n\n").append(catchPhrase)
        builder.append("\n\n").append(museumPhrase)

        return builder.toString()
    }
}


///**
// * An insect item representing a piece of content.
// *
// * Google doc data:
// * https://docs.google.com/spreadsheets/d/13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4/edit#gid=1425020391
// */
//class InsectItem(
//
//    name: String,
//    catchPhrase: String,
//    icon: Int,
//    image: Int,
//    price: Int,
//    blathersSays: String,
//
//    val location: String
//
//) : CritterItem(name,catchPhrase,icon,image,price,blathersSays){
//
//    override fun toString(): String {
//
//        val builder: StringBuilder = StringBuilder()
//        builder.append("Details about Item: ")
//        builder.append("\nPrice: ").append(price)
//        builder.append("\nLocation: ").append(location)
//        builder.append("\n\n").append(catchPhrase)
//        builder.append("\n\n").append(blathersSays)
//
//        return builder.toString()
//    }
//}