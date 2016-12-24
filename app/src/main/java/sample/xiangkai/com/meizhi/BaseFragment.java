package sample.xiangkai.com.meizhi;

import android.support.v4.app.Fragment;

import rx.Subscription;

/**
 * Created by xiangkai on 2016/12/23.
 */
public class BaseFragment extends Fragment {
    protected Subscription subscription;

    @Override
    public void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    public void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
