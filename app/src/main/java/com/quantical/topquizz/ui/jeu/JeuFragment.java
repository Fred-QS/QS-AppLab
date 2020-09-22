package com.quantical.topquizz.ui.jeu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.quantical.topquizz.R;

public class JeuFragment extends Fragment {

    private JeuViewModel mJeuViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mJeuViewModel =
                ViewModelProviders.of(this).get(JeuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_jeu, container, false);
        final TextView textView = root.findViewById(R.id.text_jeu);
        mJeuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}