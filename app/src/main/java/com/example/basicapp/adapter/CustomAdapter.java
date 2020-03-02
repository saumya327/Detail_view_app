package com.example.basicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicapp.R;
import com.example.basicapp.common.Model;
import com.example.basicapp.databinding.ListRowBinding;
import com.example.basicapp.viewmodel.CustomAdapterViewModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> implements CustomAdapterViewModel.DataListener
{
    private CustomAdapterViewModel.DataListener dataListener;
    private List<Model> modelItems;
    private CustomAdapterViewModel customAdapterViewModel;
    private Context context;

    public CustomAdapter(Context context, List<Model> modelItems, CustomAdapterViewModel.DataListener dataListener)
    {
        this.dataListener=dataListener;
        this.context=context;
        this.modelItems=modelItems;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        context=viewGroup.getContext();
        View view=LayoutInflater.from(context).inflate(R.layout.list_row,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i)
    {
        if(!modelItems.isEmpty()) {
            customAdapterViewModel = new CustomAdapterViewModel(modelItems.get(i).getId(),modelItems.get(i).getAuthor(),modelItems.get(i).getDescription(), context,this);
        }
        customViewHolder.getBinding().setViewModel(customAdapterViewModel);

    }

    @Override
    public int getItemCount()
    {
        return modelItems.size();
    }

    @Override
    public void startActivity(Intent intent)
    {
        dataListener.startActivity(intent);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private ListRowBinding listRowBinding;

        public CustomViewHolder(@NonNull View itemView)
        {
            super(itemView);
            listRowBinding=DataBindingUtil.bind(itemView);
        }

        public ListRowBinding getBinding()
        {
            return listRowBinding;
        }
    }
}
