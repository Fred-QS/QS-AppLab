package com.quantical.android_experience.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.quantical.android_experience.R;
import com.quantical.android_experience.controllers.MainActivity;

public class DocumentationFragment extends Fragment {

    private WebView mWebView;
    private LinearLayout progressBarContainer;
    private LinearLayout alertOffline;
    private TextView offline_alert_text;
    private static boolean isOnline = false;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_documentation, container, false);
        isOnline = MainActivity.isNetworkAvailable(getContext());

        alertOffline = (LinearLayout) root.findViewById(R.id.offline_alert);
        offline_alert_text = (TextView) root.findViewById(R.id.offline_alert_text);
        progressBarContainer = (LinearLayout) root.findViewById(R.id.progressBar);
        mWebView = (WebView) root.findViewById(R.id.activity_capsule_webview);

            if (isOnline) {

                alertOffline.setVisibility(View.GONE);
                progressBarContainer.setVisibility(View.VISIBLE);

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                mWebView.loadUrl("https://github.com/Fred-QS/Android-TopQuizz");
                mWebView.setWebViewClient(new WebViewClient() {

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        progressBarContainer.setVisibility(View.GONE);
                    }

                });

            } else {

                alertOffline.setVisibility(View.VISIBLE);
                offline_alert_text.setText(R.string.offline_message);
                progressBarContainer.setVisibility(View.GONE);
                mWebView.setVisibility(View.GONE);
            }

        return root;
    }
}