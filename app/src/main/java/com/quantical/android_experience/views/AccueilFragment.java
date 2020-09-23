package com.quantical.android_experience.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.quantical.android_experience.R;

public class AccueilFragment extends Fragment {

    Context context;
    private TextView accueil_side_ch1;
    private TextView accueil_side_ch2;
    private TextView accueil_side_ch3;
    private TextView accueil_side_ch4;
    private TextView accueil_side_ch5;
    private TextView accueil_side_ch6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_accueil, container, false);
        context = root.getContext();

        accueil_side_ch1 = root.findViewById(R.id.accueil_side_ch1);
        accueil_side_ch1.setText(R.string.accueil_side_ch1);

        accueil_side_ch2 = root.findViewById(R.id.accueil_side_ch2);
        accueil_side_ch2.setText(R.string.accueil_side_ch2);

        accueil_side_ch3 = root.findViewById(R.id.accueil_side_ch3);
        accueil_side_ch3.setText(R.string.accueil_side_ch3);

        accueil_side_ch4 = root.findViewById(R.id.accueil_side_ch4);
        accueil_side_ch4.setText(R.string.accueil_side_ch4);

        accueil_side_ch5 = root.findViewById(R.id.accueil_side_ch5);
        accueil_side_ch5.setText(R.string.accueil_side_ch5);

        accueil_side_ch6 = root.findViewById(R.id.accueil_side_ch6);
        accueil_side_ch6.setText(R.string.accueil_side_ch6);

        return root;
    }
}
