package com.example.shynmcd.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shynmcd.UI.AppFragment;
import com.example.shynmcd.UI.ViewModel.PlayerUpdateViewModel;
import com.example.shynmcd.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

public class BaseFragment extends AppFragment<PlayerUpdateViewModel> {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.add_player);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_baseFragment_to_addInfoFragment);
            }
        });
    }

    @Override
    public Class<PlayerUpdateViewModel> getViewModel() {
        return PlayerUpdateViewModel.class;
    }
}
