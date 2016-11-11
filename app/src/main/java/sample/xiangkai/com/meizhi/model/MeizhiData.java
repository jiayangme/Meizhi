package sample.xiangkai.com.meizhi.model;

import java.util.List;

/**
 * Created by xiangkai on 2016/11/10.
 */

public class MeizhiData {

    private boolean error;
    private List<Meizhi> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Meizhi> getResults() {
        return results;
    }

    public void setResults(List<Meizhi> results) {
        this.results = results;
    }


}
