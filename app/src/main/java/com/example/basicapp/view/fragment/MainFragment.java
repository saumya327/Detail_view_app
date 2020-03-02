package com.example.basicapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basicapp.R;
import com.example.basicapp.databinding.FragmentListViewBinding;
import com.example.basicapp.viewmodel.CustomAdapterViewModel;
import com.example.basicapp.viewmodel.MainFragmentViewModel;

public class MainFragment extends Fragment implements CustomAdapterViewModel.DataListener
{

    public static MainFragment newInstance()
    {
       MainFragment mainFragment=new MainFragment();
        return  mainFragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        FragmentListViewBinding fragmentListViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_view,container,false);
        MainFragmentViewModel mainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel.class).build(this);
        fragmentListViewBinding.setViewModel(mainFragmentViewModel);
        return fragmentListViewBinding.getRoot();
    }



}
