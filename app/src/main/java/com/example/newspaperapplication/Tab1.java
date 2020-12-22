package com.example.newspaperapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Model> theDays;
    MyRecyclerAdapter myRecyclerAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
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


            // Inflate the layout for this fragment
        theDays=new ArrayList<>();
            View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            PopulateData();
            init();


            return rootView;

        }









    public void init(){


        myRecyclerAdapter=new MyRecyclerAdapter(getContext(),theDays);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myRecyclerAdapter);




    }
    public  void PopulateData(){

      theDays.add(new Model(R.drawable.orange,"Benefits of adding oranges in youtr meals","10/10/2020"));
      theDays.add(new Model(R.drawable.movies,"The upcoming Drama series of all Time","09/10/2020"));
      theDays.add(new Model(R.drawable.corona,"Update about Corona Virus","08/10/2020"));
      theDays.add(new Model(R.drawable.infinix,"Infinix Zero 8 in the market","08/10/2020"));
    }




}
