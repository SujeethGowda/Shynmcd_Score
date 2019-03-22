package com.example.shynmcd.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shynmcd.UI.AppFragment;
import com.example.shynmcd.UI.ViewModel.PlayerUpdateViewModel;
import com.example.shynmcd.R;
import com.example.shynmcd.databinding.AddInfoFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class AddInfoFragment extends AppFragment<PlayerUpdateViewModel> {

    private AddInfoFragmentBinding addInfoFragmentBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addInfoFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.add_info_fragment,container,false);
        addInfoFragmentBinding.setLifecycleOwner(this);
        return addInfoFragmentBinding.getRoot();
    }

    @Override
    public Class<PlayerUpdateViewModel> getViewModel() {
        return PlayerUpdateViewModel.class;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addInfoFragmentBinding.setAddInfo(viewModel);
    }
}
