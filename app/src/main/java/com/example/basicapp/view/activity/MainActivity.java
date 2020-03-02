package com.example.basicapp.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.basicapp.R;
import com.example.basicapp.databinding.ActivityMainBinding;
import com.example.basicapp.view.fragment.MainFragment;
import com.example.basicapp.viewmodel.CustomAdapterViewModel;
import com.example.basicapp.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements CustomAdapterViewModel.DataListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class).build();
        activityMainBinding.setViewModel(mainActivityViewModel);
        addFragment(MainFragment.newInstance());
    }

    private void addFragment(Fragment fragment)
    {
       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
       fragmentTransaction.add(R.id.frame,fragment);
       fragmentTransaction.commit();
    }
}
