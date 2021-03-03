package com.example.critterpedia;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A fish item representing a piece of content.
 * Retrieved from: https://animalcrossing.fandom.com/wiki/Fish_(New_Horizons)#Northern_Hemisphere
 * Note: Named Inner Class
 */
public class FishItem extends CritterItem{

    public final String location;
    public final int shadowSize;

    public FishItem(String name, String catchPhrase, int icon, int image,
                    int price, String location, int shadowSize) {
        super(name,catchPhrase,icon,image,price);

        this.shadowSize = shadowSize;
        this.location = location;
    }

    public FishItem(Parcel in) {

        super(in);

        this.shadowSize = in.readInt();
        this.location = in.readString();
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
        dest.writeString(location);
        dest.writeInt(shadowSize);
    }

    public static final Parcelable.Creator<FishItem> CREATOR = new Parcelable.Creator<FishItem>()
    {
        public FishItem createFromParcel(Parcel in)
        {
            return new FishItem(in);
        }
        public FishItem[] newArray(int size)
        {
            return new FishItem[size];
        }
    };

    // Getters
    public int getShadowSize() {
        return shadowSize;
    }

    public String getLocation() {
        return location;
    }
}
