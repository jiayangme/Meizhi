package sample.xiangkai.com.meizhi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.xiangkai.com.meizhi.BaseActivity;
import sample.xiangkai.com.meizhi.R;
import sample.xiangkai.com.meizhi.fragment.GankFragment;

/**
 * Created by xiangkai on 2016/12/17.
 */

public class WebActivity extends BaseActivity {
    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.number_progress_bar)
    NumberProgressBar numberProgressBar;
    @Bind(R.id.toolbar_title)
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        triggleBackButton(toolbar);
        tvTitle.setText(getIntent().getStringExtra(GankFragment.TITLE));
        webView.loadUrl(getIntent().getStringExtra(GankFragment.URL));
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    numberProgressBar.setVisibility(View.GONE);
                } else {
                    numberProgressBar.setProgress(newProgress);
                    numberProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
