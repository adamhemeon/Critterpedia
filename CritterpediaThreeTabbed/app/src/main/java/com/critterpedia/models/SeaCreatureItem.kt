package com.critterpedia.models

class SeaCreatureItem(

    type: String,
    id: Int,
    fileName: String,
    val name: Name,
    val availability: Availability,
    val speed: String,
    val shadow: String,
    price: Int,
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
        builder.append("Details about Sea Creature: ")
        builder.append("\nPrice: ").append(price)
        builder.append("\n\n").append(catchPhrase)
        builder.append("\n\n").append(museumPhrase)

        return builder.toString()
    }
}

///**
// * A sea creature item representing a piece of content.
// *
// * Google doc data:
// * https://docs.google.com/spreadsheets/d/13d_LAJPlxMa_DubPTuirkIV4DERBMXbrWQsmSh8ReK4/edit#gid=641340358
// */
//class SeaCreatureItem(
//
//    name: String,
//    catchPhrase: String,
//    icon: Int,
//    image: Int,
//    price: Int,
//    blathersSays: String,
//
//    val shadowSize: String,
//    val swimPattern: String
//
//) : CritterItem(name,catchPhrase,icon,image,price,blathersSays){
//
//    override fun toString(): String {
//
//        val builder: StringBuilder = StringBuilder()
//        builder.append("Details about Item: ")
//        builder.append("\nPrice: ").append(price)
//        builder.append("\nShadow Size: ").append(shadowSize)
//        builder.append("\nSwim Pattern: ").append(swimPattern)
//        builder.append("\n\n").append(catchPhrase)
//        builder.append("\n\n").append(blathersSays)
//
//        return builder.toString()
//    }
//}