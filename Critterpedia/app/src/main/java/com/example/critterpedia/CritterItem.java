package com.example.critterpedia;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A critter item representing a piece of content.
 * Retrieved from: https://stackoverflow.com/questions/12092612/pass-list-of-objects-from-one-activity-to-other-activity-in-android
 */
public abstract class CritterItem implements Parcelable {

    // Properties
    protected final String name;
    protected final String catchPhrase;
    protected final int icon;
    protected final int image;
    protected final int price;

    // Constructors
    public CritterItem(String name, String catchPhrase, int icon,
                       int image, int price) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.icon = icon;
        this.image = image;
        this.price = price;
    }

    public CritterItem(Parcel in) {

        this.name = in.readString();
        this.catchPhrase = in.readString();
        this.icon = in.readInt();
        this.image = in.readInt();
        this.price = in.readInt();
    }

    // Methods
    @Override
    public abstract String toString();

    public abstract int describeContents();

    // Getters
    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public int getIcon() {
        return icon;
    }

    public int getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
}
