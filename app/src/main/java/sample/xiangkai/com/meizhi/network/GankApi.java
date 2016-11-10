package sample.xiangkai.com.meizhi.network;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import sample.xiangkai.com.meizhi.model.GankMeizhi;

/**
 * Created by xiangkai on 2016/11/10.
 */

public interface GankApi {
    @GET("data/福利/10/{page}")
    Observable<GankMeizhi> getMeizhi(@Path("page") int page);
}
