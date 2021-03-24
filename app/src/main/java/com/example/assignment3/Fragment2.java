package com.example.assignment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.assignment3.models.Result;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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

        View v = inflater.inflate(R.layout.fragment_2, container, false);

        TextView Name_textView = v.findViewById(R.id.name);
        TextView Cell_textView = v.findViewById(R.id.cell);
        TextView Gender_textView = v.findViewById(R.id.gender);
        TextView DOB_textView = v.findViewById(R.id.DOB);
        ImageView Display_picture = v.findViewById(R.id.imageView);


        Bundle bundle = this.getArguments();
      Result result = (Result) bundle.getSerializable("result");
        String Name = result.getName().getTitle() + " " + result.getName().getFirst()
                + " " + result.getName().getLast();
        String Cell = result.getCell();
        String Gender = result.getGender();
        String DOB_Age = result.getDob().getDate();
        String DOB = DOB_Age.substring(0,(DOB_Age.indexOf('T')));

        Picasso.get().load(result.getPicture().getLarge()).into(Display_picture);

        Name_textView.setText(Name);
        Cell_textView.append(Cell);
        Gender_textView.append(Gender);
        DOB_textView.append(DOB);


        return v;
    }


}