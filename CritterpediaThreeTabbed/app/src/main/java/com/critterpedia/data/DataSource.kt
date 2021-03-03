package com.critterpedia.data

import com.critterpedia.models.CritterItem
import com.critterpedia.models.FishItem
import com.critterpedia.models.BugItem
import com.critterpedia.models.SeaCreatureItem

class DataSource {

    companion object{

        fun createFishDataSet(): ArrayList<CritterItem>{
            val list = ArrayList<CritterItem>()
            list.add(
                FishItem("fish",
                    1,
                    "bitterling",
                    FishItem.Name("bitterling",
                        "bitterling",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""),
                    FishItem.Availability("11-3",
                        "5-9",
                        "",
                        true,
                        false,
                        "River",
                        "Common",
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0)),
                    "Smallest (1)",
                    900,
                    1350,
                    "I caught a bitterling! It's mad at me, but only a little.",
                "Bitterlings hide their eggs inside large bivalves—like clams—where the young can stay safe until grown. The bitterling isn't being sneaky. No, their young help keep the bivalve healthy by eating invading parasites! It's a wonderful bit of evolutionary deal making, don't you think? Each one keeping the other safe... Though eating parasites does not sound like a happy childhood... Is that why the fish is so bitter?",
                "https://acnhapi.com/v1/images/fish/1",
                "https://acnhapi.com/v1/icons/fish/1")
            )

//            list.add(
//                FishItem("Anchovy",
//                "I caught an anchovy! Stay away from my pizza!",
//                R.drawable.nh_icon_anchovy, R.drawable.nh_real_anchovy, 200,
//                "Blathers says: ''",
//                    "Sea", 2)
//            )
//
//            list.add(
//                FishItem("Angelfish",
//                "I caught an angelfish! That other fish told me to do it!",
//                R.drawable.nh_icon_angelfish, R.drawable.nh_real_angelfish, 3000,
//                "Blathers says: ''",
//                    "River", 2)
//            )
//
//            list.add(
//                FishItem("Arapaima",
//                "I caught an arapaima! How did it get here? Arapaiknow!",
//                R.drawable.nh_icon_arapaima, R.drawable.nh_real_arapiama, 10000,
//                "Blathers says: ''",
//                    "River", 6)
//            )
//
//            list.add(
//                FishItem("Arowana",
//                "I caught an arowana! I'd make a joke, but I don't 'wana.",
//                R.drawable.nh_icon_arowana, R.drawable.nh_real_arowana, 10000,
//                "Blathers says: ''",
//                    "River", 4)
//            )
//
//            list.add(
//                FishItem("Barred Knifejaw",
//                "I caught a barred knifejaw! They must have a hard time eating!",
//                R.drawable.nh_icon_barredknifejaw, R.drawable.nh_real_barredknifejaw, 5000,
//                "Blathers says: ''",
//                    "Sea", 3)
//            )
//
//            list.add(
//                FishItem("Barreleye",
//                "I caught a barreleye! Like eyeing fish in a barrel!",
//                R.drawable.nh_icon_barreleye, R.drawable.nh_real_barreleye, 15000,
//                "Blathers says: ''",
//                    "Sea", 2)
//            )
//
//            list.add(
//                FishItem("Betta",
//                "I caught a betta! I betta not drop it!",
//                R.drawable.nh_icon_betta, R.drawable.nh_real_betta, 2500,
//                "Blathers says: ''",
//                    "River", 2)
//            )
//
//            list.add(
//                FishItem("Bitterling",
//                "I caught a bitterling! It's mad at me, but only a little.",
//                R.drawable.nh_icon_bitterling, R.drawable.nh_real_bitterling, 900,
//                "Blathers says: ''",
//                    "River", 1)
//            )
//
//            list.add(
//                FishItem("Black Bass",
//                "I caught a black bass! The most metal of all fish!",
//                R.drawable.nh_icon_blackbass, R.drawable.nh_real_blackbass, 400,
//                "Blathers says: ''",
//                    "River", 4)
//            )
//
//            list.add(
//                FishItem("Blowfish",
//                "I caught a blowfish! I'm blown away!",
//                R.drawable.nh_icon_blowfish, R.drawable.nh_real_blowfish,5000,
//                "Blathers says: ''",
//                "Sea", 3)
//            )

            return list
        }

        fun createBugsDataSet(): ArrayList<CritterItem>{
            val list = ArrayList<CritterItem>()

            list.add(
                BugItem("bug",
                    1,
                    "common_butterfly",
                    BugItem.Name("common butterfly",
                        "common butterfly",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""),
                    BugItem.Availability("9-6",
                        "3-12",
                        "4am - 7pm",
                        false,
                        false,
                        "Flying",
                        "Common",
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0)),
                    160,
                    240,
                    "I caught a common butterfly! They often flutter by!",
                    "The common butterfly would have you believe it is but a beautiful friend flitting prettily about the flowers. Bah, I say! They may seem innocent things with their pretty white wings, but they hide a dark side! The common butterfly caterpillar is called a cabbage worm, you see, and it's a most voracious pest. The ravenous beasts chew through cabbage, broccoli, kale and the like with a devastating gusto. And my feathers! Their green coloring is truly GROSS! A hoo-rrific hue, I say.",
                    "https://acnhapi.com/v1/images/bugs/1",
                    "https://acnhapi.com/v1/icons/bugs/1")
            )

//            list.add(
//                InsectItem("Bitterling",
//                    "I caught a bitterling! It's mad at me, but only a little.",
//                    R.drawable.nh_icon_bitterling, R.drawable.nh_real_bitterling, 900,
//                    "Blathers says: ''",
//                    "River")
//            )
//
//            list.add(
//                InsectItem("Black Bass",
//                    "I caught a black bass! The most metal of all fish!",
//                    R.drawable.nh_icon_blackbass, R.drawable.nh_real_blackbass, 400,
//                    "Blathers says: ''",
//                    "River")
//            )
//
//            list.add(
//                InsectItem("Blowfish",
//                    "I caught a blowfish! I'm blown away!",
//                    R.drawable.nh_icon_blowfish, R.drawable.nh_real_blowfish,5000,
//                    "Blathers says: ''",
//                    "Sea")
//            )

            return list
        }

        fun createDeepSeaCreaturesDataSet(): ArrayList<CritterItem>{
            val list = ArrayList<CritterItem>()

            list.add(
                SeaCreatureItem("sea creature",
                    1,
                    "seaweed",
                    SeaCreatureItem.Name("seaweed",
                        "seaweed",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""),
                    SeaCreatureItem.Availability("10-7",
                        "4-1",
                        "",
                        true,
                        false,
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0),
                        arrayListOf(0,0,0)),
                    "Stationary",
                    "Large",
                    600,
                    "I got some seaweed! I couldn't kelp myself.",
                    "Let it be known that seaweed is a misnomer of the highest order! That is, it is not a noxious weed so much as it is a marine algae most beneficial to life on land and sea. Seaweed, you see, provides essential habitat and food for all manner of marine creatures. And it creates a great deal of the oxygen we land lovers love to breath too, hoo! And yet, I can't help but shudder when the slimy stuff touches my toes during a swim. Hoot! The horror!",
                    "https://acnhapi.com/v1/images/sea/1",
                    "https://acnhapi.com/v1/icons/sea/1")
            )

//            list.add(
//                SeaCreatureItem("Barred Knifejaw",
//                    "I caught a barred knifejaw! They must have a hard time eating!",
//                    R.drawable.nh_icon_barredknifejaw, R.drawable.nh_real_barredknifejaw, 5000,
//                    "Blathers says: ''",
//                    "Large", "swimPattern")
//            )
//
//            list.add(
//                SeaCreatureItem("Barreleye",
//                    "I caught a barreleye! Like eyeing fish in a barrel!",
//                    R.drawable.nh_icon_barreleye, R.drawable.nh_real_barreleye, 15000,
//                    "Blathers says: ''",
//                    "Large", "swimPattern")
//            )
//
//            list.add(
//                SeaCreatureItem("Betta",
//                    "I caught a betta! I betta not drop it!",
//                    R.drawable.nh_icon_betta, R.drawable.nh_real_betta, 2500,
//                    "Blathers says: ''",
//                    "Large", "swimPattern")
//            )

            return list
        }
    }
}