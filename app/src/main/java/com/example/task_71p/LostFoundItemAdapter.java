package com.example.task_71p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Provides an adapter for LostFoundItem objects and the recycler view
 */
public class LostFoundItemAdapter extends RecyclerView.Adapter<LostFoundItemAdapter.LostFoundItemViewHolder> {

    private List<LostFoundItem> lostFoundItemList;
    private Context context;

    public LostFoundItemAdapter(Context context, List<LostFoundItem> lostFoundItemList) {
        this.context = context;
        this.lostFoundItemList = lostFoundItemList;
    }

    @NonNull
    @Override
    public LostFoundItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lost_found_item, parent, false);
        return new LostFoundItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LostFoundItemViewHolder holder, int position) {
        LostFoundItem item = lostFoundItemList.get(position);
        holder.lostFoundItemTextView.setText(item.getName());
        // set other views in the holder as needed
    }

    @Override
    public int getItemCount() {
        return lostFoundItemList.size();
    }

    public static class LostFoundItemViewHolder extends RecyclerView.ViewHolder {
        TextView lostFoundItemTextView;

        public LostFoundItemViewHolder(@NonNull View itemView) {
            super(itemView);
            lostFoundItemTextView = itemView.findViewById(R.id.lostFoundItemTextView);
            // initialize other views in the layout as needed
        }
    }
}
