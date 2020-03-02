package com.example.basicapp.view.fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basicapp.R;
import com.example.basicapp.databinding.FragmentDetailsViewBinding;
import com.example.basicapp.viewmodel.DetailsFragmentViewModel;

public class DetailsFragment  extends Fragment
{
    private String description;

   public static DetailsFragment newInstance(String description)
   {
       DetailsFragment detailsFragment=new DetailsFragment();
       Bundle bundle=new Bundle();
       bundle.putString("description",description);
       detailsFragment.setArguments(bundle);
       return detailsFragment;
   }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        description=getArguments().getString("description");

        FragmentDetailsViewBinding fragmentDetailsViewBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_details_view,container,false);
        DetailsFragmentViewModel detailsFragmentViewModel= ViewModelProviders.of(this).get(DetailsFragmentViewModel.class).build(description);
        fragmentDetailsViewBinding.setViewModel(detailsFragmentViewModel);
        return fragmentDetailsViewBinding.getRoot();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

}
