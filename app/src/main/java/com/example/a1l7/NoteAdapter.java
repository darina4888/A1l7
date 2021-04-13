package com.example.a1l7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private CardsSource dataSource;

    private OnItemClickListener itemClickListener;

   public NoteAdapter(CardsSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder viewHolder, int i) {
        viewHolder.setData(dataSource.getCardData(i));
    }

    @Override
    public int getItemCount() {
        return dataSource == null ? 0 : dataSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView title;
        private TextView description;
        private TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;

            textView.setOnClickListener(v -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            });

        }

        public void setData(Note note){
            title.setText(note.getNoteName());
            description.setText(note.getNoteDescription());
            date.setText(note.getNoteDate());
        }
    }

    public void SetOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
}

