package com.example.critterpedia;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A bug item representing a piece of content.
 * Retrieved from: https://animalcrossing.fandom.com/wiki/Bugs_(New_Horizons)
 * Note: Named Inner Class
 */
public class BugItem extends CritterItem{

    public final String location;

    public BugItem(String name, String catchPhrase, int icon, int image,
                   int price, String location) {
        super(name,catchPhrase,icon,image,price);

        this.location = location;
    }

    public BugItem(Parcel in) {

        super(in);

        this.location = in.readString();
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
    }

    public static final Parcelable.Creator<BugItem> CREATOR = new Parcelable.Creator<BugItem>()
    {
        public BugItem createFromParcel(Parcel in)
        {
            return new BugItem(in);
        }
        public BugItem[] newArray(int size)
        {
            return new BugItem[size];
        }
    };

    // Getters
    public String getLocation() {
        return location;
    }

}
