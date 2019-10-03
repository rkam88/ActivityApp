package net.rusnet.sb.activityapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TestModel implements Parcelable {


    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    private String stringOne;
    private String stringTwo;
    private ArrayList<String> stringArrayOne = new ArrayList<>();
    private ArrayList<String> stringArrayTwo = new ArrayList<>();
    private static final String[] RANDOM_ARRAY = {"apple", "bunny", "house", "ball"};

    public TestModel() {
        stringOne = generateString();
        stringTwo = generateString();
        for (int i = 0; i < 5; i++) {
            stringArrayOne.add(generateString());
            stringArrayTwo.add(generateString());
        }
    }

    private String generateString() {
        return RANDOM_ARRAY[((int) (Math.random() * 4))] + " " + ((int) (Math.random() * 90 + 10));
    }

    public String getStringOne() {
        return stringOne;
    }

    public String getStringTwo() {
        return stringTwo;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(" \n");
        result.append("First string: " + stringOne + "\n");
        result.append("Second string: " + stringTwo + "\n");
        result.append("First array:\n");
        for (int i = 0; i < stringArrayOne.size(); i++) {
            result.append("   " + (i + 1)  + ". " + stringArrayOne.get(i) + "\n");
        }
        result.append("Second array:\n");
        for (int i = 0; i < stringArrayTwo.size(); i++) {
            result.append("   " + (i + 1) + ". " + stringArrayTwo.get(i) + "\n");
        }
        return result.toString();
    }

    protected TestModel(Parcel in) {
        stringOne = in.readString();
        stringTwo = in.readString();
        in.readStringList(stringArrayOne);
        in.readStringList(stringArrayTwo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stringOne);
        dest.writeString(stringTwo);
        dest.writeStringList(stringArrayOne);
        dest.writeStringList(stringArrayTwo);
    }
}
