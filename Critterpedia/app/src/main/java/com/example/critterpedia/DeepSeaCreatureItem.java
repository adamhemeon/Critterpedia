package com.example.critterpedia;


import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A deep sea creature item representing a piece of content.
 * Retrieved from: https://animalcrossing.fandom.com/wiki/Bugs_(New_Horizons)
 * Note: Named Inner Class
 */
public class DeepSeaCreatureItem extends CritterItem{

    // Properties
    public final String shadowSize;
    public final String swimPattern;

    // Constructors
    public DeepSeaCreatureItem(String name, String catchPhrase, int icon,
                               int image, int price, String shadowSize, String swimPattern) {
        super(name,catchPhrase,icon,image,price);

        this.shadowSize = shadowSize;
        this.swimPattern = swimPattern;
    }

    public DeepSeaCreatureItem(Parcel in) {

        super(in);

        this.shadowSize = in.readString();
        this.swimPattern = in.readString();
    }

    // Methods
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

    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(catchPhrase);
        dest.writeInt(icon);
        dest.writeInt(image);
        dest.writeInt(price);
        dest.writeString(shadowSize);
        dest.writeString(swimPattern);
    }

    public static final Parcelable.Creator<DeepSeaCreatureItem> CREATOR = new Parcelable.Creator<DeepSeaCreatureItem>()
    {
        public DeepSeaCreatureItem createFromParcel(Parcel in)
        {
            return new DeepSeaCreatureItem(in);
        }
        public DeepSeaCreatureItem[] newArray(int size)
        {
            return new DeepSeaCreatureItem[size];
        }
    };

    // Getters
    public String getShadowSize() {
        return shadowSize;
    }

    public String getSwimPattern() {
        return swimPattern;
    }
}
