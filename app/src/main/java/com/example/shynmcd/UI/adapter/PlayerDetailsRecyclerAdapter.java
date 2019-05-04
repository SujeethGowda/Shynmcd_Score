package com.example.shynmcd.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shynmcd.R;
import com.example.shynmcd.databinding.PlayerrecycleritemBinding;
import com.example.shynmcd.model.PlayerInfo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerDetailsRecyclerAdapter extends RecyclerView.Adapter<PlayerDetailsRecyclerAdapter.ViewHolder> {
    private List<PlayerInfo> playerInfoList;
//
//    public PlayerDetailsRecyclerAdapter(List<PlayerInfo> playerInfoList) {
//        this.playerInfoList = playerInfoList;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlayerrecycleritemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.playerrecycleritem,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setPlayerDetails(playerInfoList.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return playerInfoList != null? playerInfoList.size():0;
    }

    @Override
    public long getItemId(int position) {
        return playerInfoList.get(position).getId();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final PlayerrecycleritemBinding binding;
        public ViewHolder(PlayerrecycleritemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setPlayerList(final List<PlayerInfo> playerList) {
        if (this.playerInfoList == null) {
            this.playerInfoList = playerList;
            notifyItemRangeInserted(0, playerList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return playerInfoList.size();
                }

                @Override
                public int getNewListSize() {
                    return playerList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return playerInfoList.get(oldItemPosition).getId() == playerList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    PlayerInfo newPlayer = playerList.get(newItemPosition);
                    PlayerInfo oldPlayer = playerInfoList.get(oldItemPosition);
                    return  newPlayer.getId() == oldPlayer.getId() &&
                            newPlayer.getUid() == oldPlayer.getUid() &&
                            newPlayer.getName() == oldPlayer.getName();
                }
            });
            playerInfoList = playerList;
            result.dispatchUpdatesTo(this);
        }
    }
}
