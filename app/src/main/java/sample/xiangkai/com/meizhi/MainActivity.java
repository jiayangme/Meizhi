package sample.xiangkai.com.meizhi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sample.xiangkai.com.meizhi.model.GankMeizhi;
import sample.xiangkai.com.meizhi.network.NetWorkFactory;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    private MeizhiListAdapter adapter;
    private int page = 5;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        Snackbar.make(coordinatorLayout,"指引：点击卡片的标题文字，可以打开干货页面：)",Snackbar.LENGTH_INDEFINITE).show();
        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        adapter = new MeizhiListAdapter();
//        rvContent.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        // TODO: 2016/11/10
        rvContent.setLayoutManager(new GridLayoutManager(this, 2));
        rvContent.setAdapter(adapter);
    }

    private void loadData() {
        subscription = NetWorkFactory.getGankApi()
                .getMeizhi(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GankMeizhi>() {
                    @Override
                    public void call(GankMeizhi gankMeizhi) {
                        adapter.setDatas(gankMeizhi);
                        swipeRefreshLayout.setEnabled(false);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "数据加载失败", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setEnabled(false);
                    }
                });
    }

    @OnClick(R.id.fab)
    public void onClick() {
    }

    class MeizhiListAdapter extends RecyclerView.Adapter {
        private GankMeizhi gankMeizhi;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(MainActivity.this).load(gankMeizhi.getResults().get(position).getUrl()).into(viewHolder.ivImage);
            viewHolder.tvTitle.setText(gankMeizhi.getResults().get(position).getCreatedAt());
        }

        @Override
        public int getItemCount() {
            return gankMeizhi == null ? 0 : gankMeizhi.getResults().size();
        }

        public void setDatas(GankMeizhi gankMeizhi) {
            this.gankMeizhi = gankMeizhi;
            this.notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.tv_title)
            TextView tvTitle;
            @Bind(R.id.iv_image)
            ImageView ivImage;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
