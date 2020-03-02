package com.example.basicapp.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.basicapp.R;
import com.example.basicapp.databinding.ActivityListViewBinding;
import com.example.basicapp.view.fragment.DetailsFragment;
import com.example.basicapp.viewmodel.DetailsActivityViewModel;


public class DetailsActivity extends AppCompatActivity
{
    public static Intent getStartIntent(Context context)
    {
        return new Intent(context, DetailsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityListViewBinding activityListViewBinding= DataBindingUtil.setContentView(this, R.layout.activity_list_view);
        DetailsActivityViewModel detailsActivityViewModel= ViewModelProviders.of(this).get(DetailsActivityViewModel.class);
        activityListViewBinding.setViewModel(detailsActivityViewModel);

        String des=getIntent().getStringExtra("description");
        setTitle(getIntent().getStringExtra("sourceid"));
        addFragment(DetailsFragment.newInstance(des));
    }

    private void addFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}
