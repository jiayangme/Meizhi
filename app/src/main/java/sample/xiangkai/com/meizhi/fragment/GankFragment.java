package sample.xiangkai.com.meizhi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sample.xiangkai.com.meizhi.BaseFragment;
import sample.xiangkai.com.meizhi.R;
import sample.xiangkai.com.meizhi.activity.WebActivity;
import sample.xiangkai.com.meizhi.model.DateData;
import sample.xiangkai.com.meizhi.model.IDateData;
import sample.xiangkai.com.meizhi.network.NetWorkFactory;


/**
 * Created by xiangkai on 2016/11/11.
 */

public class GankFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.rv_gank)
    RecyclerView rvGank;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private DateAdapter adapter;
    private View view;
    public static final String URL = "url";
    public static final String TITLE = "title";
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";

    public static Fragment newInstance(int year, int month, int day) {
        GankFragment gankFragment = new GankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(YEAR, year);
        bundle.putInt(MONTH, month);
        bundle.putInt(DAY, day);
        gankFragment.setArguments(bundle);
        return gankFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_gank, null);
        ButterKnife.bind(this, view);

        initView();
        Bundle bundle = getArguments();
        loadData(bundle.getInt(YEAR), bundle.getInt(MONTH), bundle.getInt(DAY));
        return view;
    }

    private void loadData(int year, int month, int day) {
        subscription = NetWorkFactory.getGankApi().getDateData(year, month, day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DateData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(DateData dateData) {
                        swipeRefreshLayout.setRefreshing(false);
                        DateData.ResultsData resultsData = dateData.getResults();
                        List<IDateData> datas = new ArrayList();
                        if (resultsData.getAndroid() != null) datas.addAll(resultsData.getAndroid());
                        if (resultsData.getIOS() != null) datas.addAll(resultsData.getIOS());
                        if (resultsData.get前端() != null) datas.addAll(resultsData.get前端());
                        if (resultsData.get拓展资源() != null) datas.addAll(resultsData.get拓展资源());
                        if (resultsData.get休息视频() != null) datas.addAll(resultsData.get休息视频());
                        if (resultsData.get瞎推荐() != null) datas.addAll(resultsData.get瞎推荐());
                        adapter.setDatas(datas);
                    }
                });
    }

    private void initView() {
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new DateAdapter();
        rvGank.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvGank.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        unsubscribe();
        Bundle bundle = getArguments();
        loadData(bundle.getInt(YEAR), bundle.getInt(MONTH), bundle.getInt(DAY));
    }

    class DateAdapter extends RecyclerView.Adapter {
        List<IDateData> resultsData;

        public void setDatas(List<IDateData> resultsData) {
            this.resultsData = resultsData;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_title_desc, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            final IDateData dateData = resultsData.get(position);
            viewHolder.tvTitle.setText(dateData.getType());
            viewHolder.tvDesc.setText("*  " + dateData.getDesc());
            viewHolder.tvDesc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra(URL, dateData.getUrl());
                    intent.putExtra(TITLE,dateData.getDesc());
                    startActivity(intent);
                }
            });
            if (position == 0 || !resultsData.get(position).getType().equals(resultsData.get(position - 1).getType())) {
                viewHolder.tvTitle.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvTitle.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return resultsData == null ? 0 : resultsData.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_desc)
        TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}