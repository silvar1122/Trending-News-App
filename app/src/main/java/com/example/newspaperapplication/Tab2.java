package com.example.newspaperapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment {
    GridView gridView;
    ArrayList<Model2> category;
    MainAdapter mainAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab2, container, false);


        category=new ArrayList<>();
        PopulateData();
        gridView=(GridView) view.findViewById(R.id.grid_view);
        mainAdapter=new MainAdapter(getContext(),category);
        gridView.setAdapter(mainAdapter);

        return view;
    }

    public void PopulateData(){
        category.add(new Model2(R.drawable.ic_newspolitics,"News & Politics","#ffa500"));
        category.add(new Model2(R.drawable.ic_sports,"Sports","#00008b"));
        category.add(new Model2(R.drawable.ic_transport,"Transport","#ff69b4"));
        category.add(new Model2(R.drawable.ic_health,"Health","#ffff00"));
        category.add(new Model2(R.drawable.ic_technology,"Technology","#006994"));
        category.add(new Model2(R.drawable.ic_bussines,"Bussiness","#3b5323"));

    }



}