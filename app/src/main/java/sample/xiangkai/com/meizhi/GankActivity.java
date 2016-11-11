package sample.xiangkai.com.meizhi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiangkai on 2016/11/11.
 */

public class GankActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.vp_content)
    ViewPager vpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        PagerAdapter adapter = new GankPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(vpContent);
    }

    class GankPagerAdapter extends FragmentPagerAdapter {

        public GankPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GankFragment();
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
