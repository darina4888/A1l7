package com.example.a1l7;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private final String noteName,
            noteDescription,
            noteDate;

    public Note(String noteName, String noteDescription, String noteDate) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.noteDate = noteDate;
    }

    protected Note(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNoteName());
        dest.writeString(getNoteDescription());
        dest.writeString(getNoteDate());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNoteName() {
        return noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public String getNoteDate() {
        return noteDate;
    }
}
