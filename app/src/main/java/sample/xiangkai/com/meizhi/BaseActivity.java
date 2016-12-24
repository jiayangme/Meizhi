package sample.xiangkai.com.meizhi;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by xiangkai on 2016/12/17.
 */
public class BaseActivity  extends AppCompatActivity{
    public static String TAG = "tag";

    public void setTitle(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
    }

    public void triggleBackButton(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
