package com.quantical.topquizz.ui.jeu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JeuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JeuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Game fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}