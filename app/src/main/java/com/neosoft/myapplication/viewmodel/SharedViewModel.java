package com.neosoft.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Vishakha Gahukar on 10/10/19.
 * Email : vishakha.gahukar@neosofttech.com
 */
public class SharedViewModel extends ViewModel {

    MutableLiveData<String> textWatcher = new MutableLiveData<>();

    MutableLiveData<String> textWatcherTwo = new MutableLiveData<>();

    public LiveData<String> getTextOne() {
        return textWatcher;
    }

    public void setTextWatcher(String text) {
        textWatcher.postValue(text);
    }

    public LiveData<String> getTextTwo() {
        return textWatcherTwo;
    }

    public void setTextWatcherTwo(String text) {
        textWatcherTwo.postValue(text);
    }
}
