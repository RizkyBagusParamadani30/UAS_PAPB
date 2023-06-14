package com.example.uas_papb;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<ToDoItem> listToDo;
    public RecyclerAdapter(List<ToDoItem> listToDo){
        this.listToDo = listToDo;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView what;
        CheckBox complete;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            what = itemView.findViewById(R.id.what);
            complete = itemView.findViewById(R.id.completeCheck);
        }

        public void bindData(ToDoItem item) {
            what.setText(item.getWhat());
            time.setText(item.getTime());
            complete.setChecked(item.checkbox());

            if (item.checkbox()) {
                what.setPaintFlags(what.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                time.setPaintFlags(time.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                what.setPaintFlags(what.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                time.setPaintFlags(time.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
            }
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ToDoItem item = listToDo.get(holder.getAdapterPosition());
        holder.bindData(item);
        holder.complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoItem currentItem = listToDo.get(holder.getAdapterPosition());
                currentItem.setCheckbox(holder.complete.isChecked());
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
       return listToDo.size();
    }


}
