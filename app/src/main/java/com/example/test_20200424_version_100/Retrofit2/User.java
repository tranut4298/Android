package com.example.test_20200424_version_100.Retrofit2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

@SerializedName("Id")
@Expose
private String id;
@SerializedName("Username")
@Expose
private String username;
@SerializedName("Password")
@Expose
private String password;
@SerializedName("Image")
@Expose
private String image;

    protected User(Parcel in) {
        id = in.readString();
        username = in.readString();
        password = in.readString();
        image = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(image);
    }
}