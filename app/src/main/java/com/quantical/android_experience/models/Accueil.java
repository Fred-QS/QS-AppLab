package com.quantical.android_experience.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Accueil extends ViewModel {

    private MutableLiveData<String> mText;

    public Accueil() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Accueil fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
