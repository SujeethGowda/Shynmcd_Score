package com.example.shynmcd.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shynmcd.R;
import com.example.shynmcd.ui.AppFragment;
import com.example.shynmcd.ui.viewmodel.PlayerUpdateViewModel;
import com.example.shynmcd.databinding.AddPlayerLayoutBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class AddPlayerFragment extends AppFragment<PlayerUpdateViewModel> {
    private AddPlayerLayoutBinding layoutBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutBinding = DataBindingUtil.inflate(inflater, R.layout.add_player_layout, container, false);
        layoutBinding.setLifecycleOwner(this);
        return layoutBinding.getRoot();
    }

    @Override
    public Class<PlayerUpdateViewModel> getViewModel() {
        return PlayerUpdateViewModel.class;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutBinding.setPlayerInfo(viewModel);
    }
}
