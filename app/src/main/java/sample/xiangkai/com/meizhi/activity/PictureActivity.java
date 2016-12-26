package sample.xiangkai.com.meizhi.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.xiangkai.com.meizhi.BaseActivity;
import sample.xiangkai.com.meizhi.R;

/**
 * Created by xiangkai on 2016/12/24.
 */

public class PictureActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    @Bind(R.id.iv_image)
    ImageView ivImage;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView tvTitle;
    private boolean isHidden;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);

        triggleBackButton(toolbar);
        toolbar.setAlpha(0.5f);
        tvTitle.setText(getIntent().getStringExtra(MainActivity.TITLE));
        Glide.with(this).load(getIntent().getStringExtra(MainActivity.URL)).into(ivImage);
        ivImage.setOnClickListener(this);
        ivImage.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (isHidden) {
            toolbar.animate().translationY(0).start();
            isHidden = false;
        } else {
            toolbar.animate().translationY(-toolbar.getMeasuredHeight()).start();
            isHidden = true;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        setupSaveDialog();
        return false;
    }

    private void setupSaveDialog() {
        new AlertDialog.Builder(this)
                .setMessage("保存到手机？")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        saveImage();
                    }
                })
                .show();
    }
}
