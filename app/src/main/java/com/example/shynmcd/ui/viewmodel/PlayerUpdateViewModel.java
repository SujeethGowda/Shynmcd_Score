package com.example.shynmcd.ui.viewmodel;

import android.view.View;

import com.example.shynmcd.AppDatabase;
import com.example.shynmcd.master.MasterRepository;
import com.example.shynmcd.model.PlayerInfo;
import com.example.shynmcd.Shynmcd;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

public class PlayerUpdateViewModel extends AndroidViewModel {
    private final MasterRepository masterRepository;
    private ObservableField<PlayerInfo> infoObservableField = new ObservableField<>();
    private AppDatabase appDatabase;

    private final MediatorLiveData<List<PlayerInfo>> playerLiveData;

    public PlayerUpdateViewModel(@NonNull Shynmcd application) {
        super(application);
        masterRepository = application.getRepository().getMasterRepository();
        infoObservableField.set(new PlayerInfo());
        playerLiveData = new MediatorLiveData<>();
        playerLiveData.addSource(masterRepository.getAllPlayerInfo(), new Observer<List<PlayerInfo>>() {
            @Override
            public void onChanged(List<PlayerInfo> playerInfos) {
                if (playerInfos != null) {
                    playerLiveData.setValue(playerInfos);
                }
            }
        });
    }

    public void UpdatePlayer(View view) {
        infoObservableField.get().setUid(String.valueOf(System.currentTimeMillis()));
        masterRepository.addPlayer(infoObservableField.get());
        infoObservableField.set(new PlayerInfo());
        Navigation.findNavController(view).popBackStack();
    }

    public ObservableField<PlayerInfo> getInfoObservableField() {
        return infoObservableField;
    }

    public LiveData<List<PlayerInfo>> getPlayerLiveData() {
        return playerLiveData;
    }

    public MasterRepository getMasterRepository() {
        return masterRepository;
    }

}
