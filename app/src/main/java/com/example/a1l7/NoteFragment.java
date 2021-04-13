package com.example.a1l7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class NoteFragment extends Fragment {

    public static NoteFragment newInstance() {
        return new NoteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
        CardsSource data = new CardsSourceImpl(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, CardsSource data) {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        NoteAdapter adapter = new NoteAdapter(data);
        recyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener((view, position) -> Toast.makeText(getContext(), String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show());
    }
}
