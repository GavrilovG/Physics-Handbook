package com.example.phys;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VideosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
    private DatabaseHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_videos, container, false);

        dbHelper = new DatabaseHelper(getActivity());
        List<String> videosList = dbHelper.getVideosData(); // Метод getTheoryData() должен быть реализован в вашем DatabaseHelper
        // Пример отображения данных из базы данных на экране
        LinearLayout videosLayout = rootView.findViewById(R.id.videos_layout);
        TextView textView0 = new TextView(getActivity());
        textView0.setTextSize(25);
        textView0.setTextColor(Color.parseColor("#DAA520"));
        textView0.setText("Видеоролики по темам\n");
        videosLayout.addView(textView0);
        TextView textView = new TextView(getActivity());
        int i = 0;
        String v = "";
        for (String video : videosList) {
            if (i == 0)
            {
                i = 1;
                v += video + "\n";
            }
            else
            {
                i = 0;
                v += video + "\n" + "\n";
            }
        }
        textView.setTextSize(19);
        textView.setText(v);
        Linkify.addLinks(textView, Linkify.WEB_URLS);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        videosLayout.addView(textView);

        return rootView;
    }
}