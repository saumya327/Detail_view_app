package com.example.basicapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class MainActivityViewModel extends AndroidViewModel
{
    public MainActivityViewModel(@NonNull Application application)
    {
        super(application);
    }

    public MainActivityViewModel build()
    {
       return this;
    }
}
