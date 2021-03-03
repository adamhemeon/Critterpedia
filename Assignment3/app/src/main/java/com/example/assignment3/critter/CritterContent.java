package com.example.assignment3.critter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.example.assignment3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * Animal Crossing critters for Northern Hemisphere.
 * Retieved from: https://animalcrossing.fandom.com/wiki/Animal_Crossing_Wiki
 * <p>
 *
 */
public class CritterContent {

    /**
     * An array of sample critter(fish) items.
     */
    public static final List<CritterItem> ITEMS = new ArrayList<CritterItem>();

    /**
     * A map of sample critter(fish) items, by ID.
     */
    public static final Map<String, CritterItem> ITEM_MAP = new HashMap<String, CritterItem>();

    // Fixed object values for test fish critters.
    static{
        FishItem anchovy = new FishItem("", "I caught an anchovy! Stay away from my pizza!",
                R.drawable.nh_icon_anchovy, R.drawable.nh_real_anchovy, 200, "Sea", 2);
        addItem(anchovy);

        FishItem angelfish = new FishItem("", "I caught an angelfish! That other fish told me to do it!",
                R.drawable.nh_icon_angelfish, R.drawable.nh_real_angelfish, 3000, "River", 2);
        addItem(angelfish);

        FishItem arapaima = new FishItem("", "I caught an arapaima! How did it get here? Arapaiknow!",
                R.drawable.nh_icon_arapaima, R.drawable.nh_real_arapiama, 10000, "River", 6);
        addItem(arapaima);

        FishItem arowana = new FishItem("", "I caught an arowana! I'd make a joke, but I don't 'wana.",
                R.drawable.nh_icon_arowana, R.drawable.nh_real_arowana, 10000, "River", 4);
        addItem(arowana);

        FishItem barredknifejaw = new FishItem("", "I caught a barred knifejaw! They must have a hard time eating!",
                R.drawable.nh_icon_barredknifejaw, R.drawable.nh_real_barredknifejaw, 5000, "Sea", 3);
        addItem(barredknifejaw);

        FishItem barreleye = new FishItem("", "I caught a barreleye! Like eyeing fish in a barrel!",
                R.drawable.nh_icon_barreleye, R.drawable.nh_real_barreleye, 15000, "Sea", 2);
        addItem(barreleye);

        FishItem betta = new FishItem("", "I caught a betta! I betta not drop it!",
                R.drawable.nh_icon_betta, R.drawable.nh_real_betta, 2500, "River", 2);
        addItem(betta);

        FishItem bitterling = new FishItem("", "I caught a bitterling! It's mad at me, but only a little.",
                R.drawable.nh_icon_bitterling, R.drawable.nh_real_bitterling, 900, "River", 1);
        addItem(bitterling);

        FishItem blackbass = new FishItem("", "I caught a black bass! The most metal of all fish!",
                R.drawable.nh_icon_blackbass, R.drawable.nh_real_blackbass, 400, "River", 4);
        addItem(blackbass);

        FishItem blowfish = new FishItem("", "I caught a blowfish! I'm blown away!",
                R.drawable.nh_icon_blowfish, R.drawable.nh_real_blowfish, 5000, "Sea", 3);
        addItem(blowfish);
    }

    /**
     * Add a critter item to both the ITEMS collection and map hash to ITEM_MAP.
     * @param item
     */
    private static void addItem(CritterItem item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.name, item);
    }

    /**
     * A fish item representing a piece of content.
     * Retrieved from: https://animalcrossing.fandom.com/wiki/Fish_(New_Horizons)#Northern_Hemisphere
     * Note: Named Inner Class
     */
    public static class FishItem extends CritterItem{

        public final String location;
        public final int shadowSize;

        public FishItem(String name, String catchPhrase, int icon, int image,
                        int price, String location, int shadowSize) {
            super(name,catchPhrase,icon,image,price);

            this.shadowSize = shadowSize;
            this.location = location;
        }

        @Override
        public String toString() {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(name);
            builder.append("\nPrice: ").append(price);
            builder.append("\nLocation: ").append(location);
            builder.append("\nShadow Size: ").append(shadowSize);
            builder.append("\n\n").append(catchPhrase);
            return builder.toString();
        }
    }

    /**
     * A bug item representing a piece of content.
     * Retrieved from: https://animalcrossing.fandom.com/wiki/Bugs_(New_Horizons)
     * Note: Named Inner Class
     */
    public static class BugItem extends CritterItem{

        public final String location;

        public BugItem(String name, String catchPhrase, int icon, int image,
                       int price, String location) {
            super(name,catchPhrase,icon,image,price);

            this.location = location;
        }

        @Override
        public String toString() {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(name);
            builder.append("\nPrice: ").append(price);
            builder.append("\nLocation: ").append(location);
            builder.append("\n\n").append(catchPhrase);
            return builder.toString();
        }
    }

    /**
     * A deep sea creature item representing a piece of content.
     * Retrieved from: https://animalcrossing.fandom.com/wiki/Bugs_(New_Horizons)
     * Note: Named Inner Class
     */
    public static class DeepSeaCreatureItem extends CritterItem{

        public final String shadowSize;
        public final String swimPattern;

        public DeepSeaCreatureItem(String name, String catchPhrase, int icon,
                                   int image, int price, String shadowSize, String swimPattern) {
            super(name,catchPhrase,icon,image,price);

            this.shadowSize = shadowSize;
            this.swimPattern = swimPattern;
        }

        @Override
        public String toString() {

            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(name);
            builder.append("\nPrice: ").append(price);
            builder.append("\nShadow Size: ").append(shadowSize);
            builder.append("\nSwim Pattern: ").append(swimPattern);
            builder.append("\n\n").append(catchPhrase);
            return builder.toString();
        }
    }

    /**
     * A critter item representing a piece of content.
     * Note: Named Inner Abstract Class
     */
    public static abstract class CritterItem {

        public String name;
        public final String catchPhrase;
        public final int icon;
        public final int image;
        public final int price;

        public CritterItem(String name, String catchPhrase, int icon,
                           int image, int price) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.icon = icon;
            this.image = image;
            this.price = price;
        }

        @Override
        public abstract String toString();

        public void setName(String name) {
            this.name = name;
        }
    }
}