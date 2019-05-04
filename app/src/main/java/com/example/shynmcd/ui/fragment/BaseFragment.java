package com.example.shynmcd.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.shynmcd.databinding.BaseFragmentBinding;
import com.example.shynmcd.model.PlayerInfo;
import com.example.shynmcd.ui.AppFragment;
import com.example.shynmcd.ui.adapter.PlayerDetailsRecyclerAdapter;
import com.example.shynmcd.ui.viewmodel.PlayerUpdateViewModel;
import com.example.shynmcd.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class BaseFragment extends AppFragment<PlayerUpdateViewModel> {
    private Button button;
    private BaseFragmentBinding baseFragmentBinding;
    private PlayerDetailsRecyclerAdapter adapter = new PlayerDetailsRecyclerAdapter() ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.base_fragment, container, false);
        baseFragmentBinding.setLifecycleOwner(this);
        baseFragmentBinding.playerList.setAdapter(adapter);
        baseFragmentBinding.playerList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        return baseFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.add_player);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_baseFragment_to_addPlayerFragment);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseFragmentBinding.setPlayerViewModel(viewModel);
        viewModel.getPlayerLiveData().observe(this, new Observer<List<PlayerInfo>>() {
            @Override
            public void onChanged(List<PlayerInfo> playerInfos) {
                if (playerInfos != null){
                    adapter.setPlayerList(playerInfos);
                }
                baseFragmentBinding.executePendingBindings();
            }
        });
    }

    @Override
    public Class<PlayerUpdateViewModel> getViewModel() {
        return PlayerUpdateViewModel.class;
    }
}
