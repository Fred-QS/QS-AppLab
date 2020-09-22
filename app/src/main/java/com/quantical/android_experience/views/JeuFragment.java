package com.quantical.android_experience.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.quantical.android_experience.R;
import com.quantical.android_experience.controllers.GameActivity;
import com.quantical.android_experience.models.User;

import static android.app.Activity.RESULT_OK;

public class JeuFragment extends Fragment {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences mPreferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_jeu, container, false);

        mUser = new User();

        mPreferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        mGreetingText = (TextView) root.findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) root.findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) root.findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        greetUser();

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Un truc à faire...
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Un truc à faire...
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstname = mNameInput.getText().toString();
                mUser.setFirstname(firstname);

                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstname()).apply();

                // L'utilisateur clique sur le bouton
                Intent gameActivityIntent = new Intent(getActivity(), GameActivity.class);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Compteur de score
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();
        }
    }

    private void greetUser() {

        String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != firstname) {

            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Quel plaisir de te revoir " + firstname
                    + "!\n\nTon dernier score était de " + score + "."
                    + "\nTu penses faire mieux cette fois ?";

            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
            mPlayButton.setEnabled(true);
        }
    }
}