package com.example.a1l7;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class CardsSourceImpl implements CardsSource {
    private List<Note> dataSource;
    private Resources resources;

    public CardsSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(7);
        this.resources = resources;
    }

    public CardsSourceImpl init(){

        String[] titles = resources.getStringArray(R.array.notes_name);

        String[] descriptions = resources.getStringArray(R.array.notes_description);

        String[] date = resources.getStringArray(R.array.notes_date);

        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new Note(titles[i], descriptions[i], date[i]));
        }
        return this;
    }


    public Note getCardData(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return  dataSource == null ? 0 : dataSource.size();
    }
}
