package com.example.basicapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.example.basicapp.view.activity.DetailsActivity;

public class CustomAdapterViewModel
{
    private DataListener dataListener;
    private Context context;
    private String id;
    private String description;

    private ObservableField<String> sourceid=new ObservableField<>();
    private ObservableField<String> authorname=new ObservableField<>();


    public CustomAdapterViewModel(String id, String author,String description, Context context,DataListener dataListener)
    {
        this.dataListener=dataListener;
        this.context=context;
        this.id=id;
        this.description=description;
        setValue(id, author);
    }

    private void setValue(String id, String author)
    {
        sourceid.set("id"+"  -"+id);
        authorname.set("author"+"  -"+author);
    }

    public ObservableField<String> getSourceid()
    {
        return sourceid;
    }

    public ObservableField<String> getAuthorname()
    {
        return authorname;
    }

    public View.OnClickListener onDetails()
    {
       return new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
              Intent intent=DetailsActivity.getStartIntent(context);
              intent.putExtra("sourceid",id);
              intent.putExtra("description",description);
              dataListener.startActivity(intent);
           }
       };
    }

    public interface DataListener
    {
        void startActivity(Intent intent);
    }
}
