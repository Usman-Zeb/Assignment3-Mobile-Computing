package com.example.assignment3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.assignment3.models.Result;
import com.example.assignment3.models.Results;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements RecyclerAdapter.OnListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="Bro: " ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Result> users;
    RecyclerView recyclerView;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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


        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // String[] data = {"this", "is", "just", "list", "is", "just", "list", "is", "just", "list", "is", "just", "list", "is", "just", "list"};

        //TextView textView = requireView().findViewById(R.id.req);

        recyclerView = requireView().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button button = requireView().findViewById(R.id.textfield_btn);
        EditText editText = requireView().findViewById(R.id.textfield);
        ProgressBar progressBar = getView().findViewById(R.id.pg);
        progressBar.setVisibility(View.INVISIBLE);
        Fragment1 fragment1 = this;
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String value = editText.getText().toString();
                        int final_value = Integer.parseInt(value);
                        editText.clearFocus();
                        //editText.setInputType(InputType.TYPE_NULL);
                        progressBar.setVisibility(View.VISIBLE);
                        request(fragment1, final_value);
                    }
                }
        );
        //if(isAdded() && !requireActivity().isDestroyed())
        {
           //request(this);

        }

    }



    void request (Fragment1 fragment1, int query_number)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonAPI service = retrofit.create(JsonAPI.class);

        Call<Results> call = service.getPosts(query_number);

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

                if(getView()!=null)
                {
                    ProgressBar progressBar = getView().findViewById(R.id.pg);
                    Results results = response.body();
                    users = results.getResults();
                    progressBar.setVisibility(View.INVISIBLE);
                    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(users, fragment1);
                    recyclerView.setAdapter(recyclerAdapter);
                }
                

                /*Bundle bundle = new Bundle();

                bundle.putSerializable("result",  result);



                Fragment2 fragment = new Fragment2();
                fragment.setArguments(bundle);

                if(isAdded())
                {
                    getParentFragmentManager().beginTransaction().replace(R.id.main,fragment).addToBackStack(null).commit();
                }*/

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

                Log.e("", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void onClick(int position) {

        //users.get(position);
        Log.d(TAG, "Hi");

        Bundle bundle = new Bundle();

        bundle.putSerializable("result", (Serializable) users.get(position));



                Fragment2 fragment = new Fragment2();
                fragment.setArguments(bundle);

                if(isAdded())
                {
                    getParentFragmentManager().beginTransaction().add(R.id.main,fragment).addToBackStack(null).commit();
                }

    }
}