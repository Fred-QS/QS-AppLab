package com.quantical.topquizz.ui.documentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DocumentationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DocumentationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Documentation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}