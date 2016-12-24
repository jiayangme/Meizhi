package sample.xiangkai.com.meizhi.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import sample.xiangkai.com.meizhi.BaseActivity;
import sample.xiangkai.com.meizhi.R;
import sample.xiangkai.com.meizhi.model.Meizhi;
import sample.xiangkai.com.meizhi.model.MeizhiData;
import sample.xiangkai.com.meizhi.network.NetWorkFactory;

public class MainActivity extends BaseActivity {
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
    private static final int PRELOAD_SIZE = 6;
    private static final String DATE = "date";
    private MeizhiListAdapter adapter;
    private int page = 0;
    private Subscription subscription;
    private GridLayoutManager layoutManager;
    private List<Meizhi> meizhis;
    public static final String URL = "url";
    public static final String TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                loadData();
            }
        });
        Snackbar.make(coordinatorLayout, "指引：点击卡片的标题文字，可以打开干货页面：)", Snackbar.LENGTH_INDEFINITE)
                .setAction("知道了", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).setActionTextColor(Color.GREEN).show();
        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        meizhis = new ArrayList<>();
        adapter = new MeizhiListAdapter(meizhis);
        layoutManager = new GridLayoutManager(this, 2);
        rvContent.setLayoutManager(layoutManager);
        rvContent.setAdapter(adapter);
        rvContent.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                if (lastPosition >= adapter.getItemCount() - PRELOAD_SIZE && !swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(true);
                    page++;
                    loadData();
                }
            }
        });
    }

    private void loadData() {
        subscription = NetWorkFactory.getGankApi()
                .getMeizhi(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<MeizhiData, MeizhiData>() {
                    @Override
                    public MeizhiData call(MeizhiData meizhiData) {
                        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
                        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                        String format;
                        for (int i = 0; i < meizhiData.getResults().size(); i++) {
                            try {
                                Date parse = inputFormat.parse(meizhiData.getResults().get(i).getPublishedAt());
                                format = outputFormat.format(parse);
                            } catch (ParseException e) {
                                format = "";
                            }
                            meizhiData.getResults().get(i).setPublishedAt(format);
                        }
                        return meizhiData;
                    }
                })
                .subscribe(new Action1<MeizhiData>() {
                    @Override
                    public void call(MeizhiData meizhiData) {
                        meizhis.addAll(meizhiData.getResults());
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Snackbar.make(coordinatorLayout, "加载失败，请重试", Snackbar.LENGTH_LONG)
                                .setAction("重试", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        page = 0;
                                        loadData();
                                    }
                                }).setActionTextColor(getResources().getColor(R.color.deep_red)).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    @OnClick(R.id.fab)
    public void onClick() {
        Intent intent = new Intent(this, GankActivity.class);
        startActivity(intent);
    }

    class MeizhiListAdapter extends RecyclerView.Adapter {
        private List<Meizhi> meizhis;

        public MeizhiListAdapter(List<Meizhi> meizhis) {
            this.meizhis = meizhis;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            final String url = meizhis.get(position).getUrl();
            Glide.with(MainActivity.this).load(url).into(viewHolder.ivImage);
            final String title = meizhis.get(position).getCreatedAt();
            viewHolder.tvTitle.setText(title);
            viewHolder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                    intent.putExtra(URL, url);
                    intent.putExtra(TITLE, title);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return meizhis == null ? 0 : meizhis.size();
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
