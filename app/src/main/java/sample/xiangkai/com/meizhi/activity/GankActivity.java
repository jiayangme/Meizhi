package sample.xiangkai.com.meizhi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.xiangkai.com.meizhi.BaseActivity;
import sample.xiangkai.com.meizhi.R;
import sample.xiangkai.com.meizhi.fragment.GankFragment;

/**
 * Created by xiangkai on 2016/11/11.
 */

public class GankActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
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
        triggleBackButton(toolbar);
        initViewPager();
        initTabLayout();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = calendar.getTime();
        calendar.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String time = format.format(date);
        setTitle(toolbar, time);
    }

    private void initViewPager() {
        PagerAdapter adapter = new GankPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
        vpContent.addOnPageChangeListener(this);
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(vpContent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -position - 1);
        Date date = calendar.getTime();
        calendar.setTime(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String time = format.format(date);
        setTitle(toolbar, time);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class GankPagerAdapter extends FragmentPagerAdapter {

        public GankPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -position - 1);
            Date date = calendar.getTime();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            return GankFragment.newInstance(year, month, day);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
