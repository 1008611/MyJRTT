package com.wildwolf.myjrtt.news;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ${wild00wolf} on 2016/11/11.
 */
public class H5Activity extends Activity {
    public static final String EXTRA_BUNDLE = "bundle";
    public static final String EXTRA_URL = "url";
    public static final String EXTRA_TITLE = "title";

    private WebView mWebView;

    private String mUrl = "";
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWebView = new WebView(this);
        setContentView(mWebView);
        Bundle bundle = getIntent().getBundleExtra(EXTRA_BUNDLE);
        if (savedInstanceState != null) {
            bundle = savedInstanceState;
        }
        if (bundle != null) {
            initIntent(bundle);
        }
        initData();
    }

    private void initData() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new H5WebViewClient());

        // 设置setWebChromeClient对象
        mWebView.setWebChromeClient(new H5WebChromeClient());
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        mWebView.loadUrl(mUrl);
    }

    private void initIntent(Bundle bundle) {
        mUrl = bundle.getString(EXTRA_URL);
        mTitle = bundle.getString(EXTRA_TITLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(EXTRA_URL, mUrl);
        outState.putString(EXTRA_TITLE, mTitle);

        super.onSaveInstanceState(outState);
    }

    public static void forward(Context context, String url, String title) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putString(EXTRA_URL,url);
        bundle.putString(EXTRA_TITLE,title);
        intent.putExtra(EXTRA_BUNDLE, bundle);
        intent.setClass(context,H5Activity.class);
        context.startActivity(intent);
    }

    private class H5WebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            return H5Activity.this.shouldOverrideUrlLoading(webView, s);
        }
    }

    private boolean shouldOverrideUrlLoading(WebView webView, String url) {
        webView.loadUrl(url);
        return false;
    }

    private class H5WebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            onUpdateTitle(view, title);
        }

    }

    private void onUpdateTitle(WebView view, String title) {
    }

}
