package com.example.basicapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;

public class DetailsFragmentViewModel extends AndroidViewModel
{
    private String id;
    private Context context;
    private String description;

    private ObservableField<String> detailview = new ObservableField<>();

    public DetailsFragmentViewModel(Application application)
    {
        super(application);
        this.context=application.getApplicationContext();
    }
    public DetailsFragmentViewModel build(String description)
    {
        this.description=description;
        detailsView(description);
       return this;
    }

    private void detailsView(String description)
    {
        detailview.set(description);
    }

    public ObservableField<String> getDetailview()
    {
        return detailview;
    }
}
