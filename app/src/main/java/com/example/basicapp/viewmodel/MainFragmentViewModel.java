package com.example.basicapp.viewmodel;

import android.app.Application;
import android.app.ProgressDialog;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.basicapp.adapter.CustomAdapter;
import com.example.basicapp.common.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentViewModel extends AndroidViewModel implements CustomAdapterViewModel.DataListener
{
    private Context context;
    private List modelItems;
    private String srcid;
    private String author;
    private static final String url="https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=74907020722c4c4295501dda5abf3ea4";
    private ProgressDialog progressDialog;
    private Model model;
    private RequestQueue requestQueue;
    private CustomAdapter adapter;
    private List modelList=new ArrayList();
    private CustomAdapterViewModel.DataListener dataListener;

    private ObservableField<CustomAdapter> recyclerView = new ObservableField<>();
    private ObservableField<LinearLayoutManager> listLayoutManager =new ObservableField<>();


    public MainFragmentViewModel(Application application)
    {
        super(application);
        this.context=application.getApplicationContext();
    }

    public MainFragmentViewModel build(CustomAdapterViewModel.DataListener dataListener)
    {
        this.dataListener=dataListener;
         fetchResponse();
         return this;
    }


    public void fetchResponse()
    {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONArray jsonArray=response.getJSONArray("articles");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        JSONObject jsonObject1=jsonObject.getJSONObject("source");
                        model=new Model();
                        model.setId(jsonObject1.getString("id"));
                        model.setAuthor(jsonObject.getString("author"));
                        model.setDescription(jsonObject.getString("description"));
                        modelList.add(model);
                        displayList(modelList);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
            }
        });

        requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
    }

    private void displayList(List modelList)
    {
        listLayoutManager.set(new LinearLayoutManager(context));
        adapter=new CustomAdapter(context,modelList,dataListener);
        recyclerView.set(adapter);
        adapter.notifyDataSetChanged();
    }

    public ObservableField<CustomAdapter> getRecyclerView() {
        return recyclerView;
    }


    public ObservableField<LinearLayoutManager> getListLayoutManager()
    {
        return listLayoutManager;
    }


    @Override
    public void startActivity(Intent intent)
    {
        dataListener.startActivity(intent);
    }
}
