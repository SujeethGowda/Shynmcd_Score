package com.example.shynmcd.ui;

import android.os.Bundle;

import com.example.shynmcd.ui.viewmodel.ViewModelFactory;
import com.example.shynmcd.Shynmcd;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class AppFragment<T extends ViewModel> extends Fragment {
    protected T viewModel;
    private Shynmcd shynmcd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shynmcd = (Shynmcd) getActivity().getApplication();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
        ViewModelFactory factory = new ViewModelFactory(shynmcd);
        viewModel = ViewModelProviders.of(this, factory).get(getViewModel());
    }

    public abstract Class<T> getViewModel();
}
