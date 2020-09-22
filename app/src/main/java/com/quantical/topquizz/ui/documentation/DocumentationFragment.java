package com.quantical.topquizz.ui.documentation;

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

public class DocumentationFragment extends Fragment {

    private DocumentationViewModel mDocumentationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mDocumentationViewModel =
                ViewModelProviders.of(this).get(DocumentationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_documentation, container, false);
        final TextView textView = root.findViewById(R.id.text_documentation);
        mDocumentationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}