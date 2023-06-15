package cena.mcs.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter {
    ArrayList<ToDo> result;
    Context ctx;

    ToDoAdapter(Context ctx, ArrayList<ToDo> toDos) {
        this.ctx = ctx;
        this.result = toDos;
    }

    class ToDoVH extends RecyclerView.ViewHolder {
        private TextView tvWhat, tvTime;

        ToDoVH(View rowView) {
            super(rowView);
            tvWhat = (TextView) rowView.findViewById(R.id.tv_what);
            tvTime = (TextView) rowView.findViewById(R.id.tv_time);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.ctx).inflate(R.layout.item, parent, false);
        return new ToDoVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ToDo list = result.get(position);
        ToDoVH vh = (ToDoVH) holder;
        vh.tvWhat.setText(list.what);
        vh.tvTime.setText(list.time);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
