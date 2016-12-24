package sample.xiangkai.com.meizhi.network;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import sample.xiangkai.com.meizhi.model.DateData;
import sample.xiangkai.com.meizhi.model.MeizhiData;

/**
 * Created by xiangkai on 2016/11/10.
 */

public interface GankApi {
    @GET("data/福利/10/{page}")
    Observable<MeizhiData> getMeizhi(@Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<DateData> getDateData(@Path("year") int year, @Path("month") int month, @Path("day") int day);
}
