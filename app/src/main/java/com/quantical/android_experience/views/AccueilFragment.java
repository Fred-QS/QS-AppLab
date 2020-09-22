package com.quantical.android_experience.views;

import android.content.Context;
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

import com.quantical.android_experience.R;
import com.quantical.android_experience.models.Accueil;

public class AccueilFragment extends Fragment {

    private Accueil mAccueil;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mAccueil =
                ViewModelProviders.of(this).get(Accueil.class);
        View root = inflater.inflate(R.layout.fragment_accueil, container, false);
        context = root.getContext();
        final TextView textView = root.findViewById(R.id.text_accueil);

        mAccueil.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}
