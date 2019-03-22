package com.example.shynmcd.UI.ViewModel;

import android.view.View;

import com.example.shynmcd.MasterRepository;
import com.example.shynmcd.Model.PlayerInfo;
import com.example.shynmcd.Shynmcd;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.Navigation;

public class PlayerUpdateViewModel extends AndroidViewModel {
    private final MasterRepository masterRepository;
    private ObservableField<PlayerInfo> infoObservableField = new ObservableField<>();

    public PlayerUpdateViewModel(@NonNull Shynmcd application) {
        super(application);
        masterRepository = application.getRepository().getMasterRepository();
        infoObservableField.set(new PlayerInfo());
    }

    public void UpdatePlayer(View view) {
        masterRepository.addPlayer(infoObservableField.get());
        infoObservableField.set(new PlayerInfo());
        Navigation.findNavController(view).popBackStack();
    }

    public ObservableField<PlayerInfo> getInfoObservableField() {
        return infoObservableField;
    }
}
