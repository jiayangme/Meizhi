package sample.xiangkai.com.meizhi.model;

import java.util.List;

/**
 * Created by xiangkai on 2016/12/17.
 */
public class DateData {

    /**
     * category : ["Android","iOS","前端","瞎推荐","休息视频","福利","拓展资源"]
     * error : false
     * results : {"Android":[{"_id":"58427e8b421aa939bb4637ed","createdAt":"2016-12-03T16:12:59.321Z","desc":"在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。","publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"Android","url":"http://www.haotianyi.win/2016/11/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%E4%B9%8B%E7%8A%B6%E6%80%81%E6%A8%A1%E5%BC%8F.html","used":true,"who":"HaoTianYi"},{"_id":"584acd8e421aa963efd90dbd","createdAt":"2016-12-09T23:28:14.631Z","desc":"利用动态加载实现手机淘宝的节日特效","images":["http://img.gank.io/9a9f8833-fc71-42fa-9762-548a179f019a"],"publishedAt":"2016-12-16T11:47:53.776Z",
     * "source":"web","type":"Android","url":"http://www.jianshu.com/p/195eb1d8d0de","used":true,"who":"kot32"},{"_id":"584d7a36421aa963eaaee16f","createdAt":"2016-12-12T00:09:26.762Z","desc":"文章主要介绍freeline是如何实现快速增量编译的","images":["http://img.gank.io/d5e2e665-a8d5-4943-ac82-278b99361843"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/37e31d924be9","used":true,"who":"梧桐"},{"_id":"585217a3421aa9723d29b955","createdAt":"2016-12-15T12:10:11.280Z","desc":"3D 视差效果的多选按钮","images":["http://img.gank.io/413149f4-5b69-44d0-80d7-93a200e1cd11"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web",
     * "type":"Android","url":"https://github.com/gjiazhe/MultiChoicesCircleButton","used":true,"who":"郭佳哲"}],"iOS":[{"_id":"58465ce1421aa939bb463806","createdAt":"2016-12-06T14:38:25.801Z","desc":"iOS动画-从不会到熟练应用:一个总结的很好的动画文章~","images":["http://img.gank.io/35fc300d-9d98-4fb9-bafd-b45191bfc821"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"iOS","url":"http://www.jianshu.com/p/3f48fabaca19","used":true,"who":"抱紧我的小鲤鱼"},{"_id":"5852e1d5421aa97240ef9edc","createdAt":"2016-12-16T02:32:53.816Z","desc":"史上最详细的教程：iOS难点之内存管理","images":["http://img.gank.io/60fa5a49-55c4-4909-84f0-5edf9164499a"],"publishedAt":"2016-12-16T11:47:53.776Z",
     * "source":"web","type":"iOS","url":"http://www.imlifengfeng.com/blog/?p=302","used":true,"who":"李峰峰"}],"休息视频":[{"_id":"58501466421aa9343afb7106","createdAt":"2016-12-13T23:31:50.447Z","desc":"暖心广告短片《今年圣诞，愿望成真》","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTg1Mjg1OTEwOA==.html","used":true,"who":"lxxself"}],"前端":[{"_id":"584f5506421aa934405ccfac","createdAt":"2016-12-13T09:55:18.309Z","desc":"内容非常详细，浅显易懂，苹果2017年1月1日起强制使用HTTPS，这篇文章非常非常有用","images":["http://img.gank.io/e6c7b9c9-6fbf-46bd-ac1e-d830c19d931b"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"前端",
     * "url":"http://www.imlifengfeng.com/blog/?p=268","used":true,"who":"猿星人"}],"拓展资源":[{"_id":"585353a4421aa97240ef9ede","createdAt":"2016-12-16T10:38:28.505Z","desc":"一个第三方组织，正在全力打造全平台的 Material Design 风格的组件集合。","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"拓展资源","url":"https://github.com/material-components","used":true,"who":"代码家"}],"瞎推荐":[{"_id":"584f7ca6421aa93437406720","createdAt":"2016-12-13T12:44:22.461Z","desc":"非常详细的TCP与UDP详解，原创文章","images":["http://img.gank.io/438895f5-094e-4f45-bfff-37bf4335d29a"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"瞎推荐","url":"http://www.imlifengfeng.com/blog/?p=270",
     * "used":true,"who":"猿星人"}],"福利":[{"_id":"585331db421aa9723d29b95c","createdAt":"2016-12-16T08:14:19.281Z","desc":"12-17","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","used":true,"who":"代码家"}]}
     */

    private boolean error;
    private ResultsData results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsData getResults() {
        return results;
    }

    public void setResults(ResultsData results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsData {
        /**
         * _id : 58427e8b421aa939bb4637ed
         * createdAt : 2016-12-03T16:12:59.321Z
         * desc : 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : web
         * type : Android
         * url : http://www.haotianyi.win/2016/11/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%E4%B9%8B%E7%8A%B6%E6%80%81%E6%A8%A1%E5%BC%8F.html
         * used : true
         * who : HaoTianYi
         */

        private List<AndroidData> Android;
        /**
         * _id : 58465ce1421aa939bb463806
         * createdAt : 2016-12-06T14:38:25.801Z
         * desc : iOS动画-从不会到熟练应用:一个总结的很好的动画文章~
         * images : ["http://img.gank.io/35fc300d-9d98-4fb9-bafd-b45191bfc821"]
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : web
         * type : iOS
         * url : http://www.jianshu.com/p/3f48fabaca19
         * used : true
         * who : 抱紧我的小鲤鱼
         */

        private List<IOSBean> iOS;
        /**
         * _id : 58501466421aa9343afb7106
         * createdAt : 2016-12-13T23:31:50.447Z
         * desc : 暖心广告短片《今年圣诞，愿望成真》
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : chrome
         * type : 休息视频
         * url : http://v.youku.com/v_show/id_XMTg1Mjg1OTEwOA==.html
         * used : true
         * who : lxxself
         */

        private List<休息视频Bean> 休息视频;
        /**
         * _id : 584f5506421aa934405ccfac
         * createdAt : 2016-12-13T09:55:18.309Z
         * desc : 内容非常详细，浅显易懂，苹果2017年1月1日起强制使用HTTPS，这篇文章非常非常有用
         * images : ["http://img.gank.io/e6c7b9c9-6fbf-46bd-ac1e-d830c19d931b"]
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : chrome
         * type : 前端
         * url : http://www.imlifengfeng.com/blog/?p=268
         * used : true
         * who : 猿星人
         */

        private List<前端Bean> 前端;
        /**
         * _id : 585353a4421aa97240ef9ede
         * createdAt : 2016-12-16T10:38:28.505Z
         * desc : 一个第三方组织，正在全力打造全平台的 Material Design 风格的组件集合。
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : chrome
         * type : 拓展资源
         * url : https://github.com/material-components
         * used : true
         * who : 代码家
         */

        private List<拓展资源Bean> 拓展资源;
        /**
         * _id : 584f7ca6421aa93437406720
         * createdAt : 2016-12-13T12:44:22.461Z
         * desc : 非常详细的TCP与UDP详解，原创文章
         * images : ["http://img.gank.io/438895f5-094e-4f45-bfff-37bf4335d29a"]
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : chrome
         * type : 瞎推荐
         * url : http://www.imlifengfeng.com/blog/?p=270
         * used : true
         * who : 猿星人
         */

        private List<瞎推荐Bean> 瞎推荐;
        /**
         * _id : 585331db421aa9723d29b95c
         * createdAt : 2016-12-16T08:14:19.281Z
         * desc : 12-17
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : chrome
         * type : 福利
         * url : http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg
         * used : true
         * who : 代码家
         */

        private List<福利Bean> 福利;

        public List<AndroidData> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidData> Android) {
            this.Android = Android;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<拓展资源Bean> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<拓展资源Bean> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<瞎推荐Bean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<瞎推荐Bean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

//        面向接口编程
        public static class AndroidData implements IDateData{
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

    @Override
    public String toString() {
        return "AndroidData{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}

        public static class IOSBean implements IDateData{
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            @Override
            public String toString() {
                return "IOSBean{" +
                        "_id='" + _id + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        ", desc='" + desc + '\'' +
                        ", publishedAt='" + publishedAt + '\'' +
                        ", source='" + source + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        ", used=" + used +
                        ", who='" + who + '\'' +
                        ", images=" + images +
                        '}';
            }
        }

        public static class 休息视频Bean implements IDateData{
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 前端Bean implements IDateData{
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 拓展资源Bean implements IDateData {
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 瞎推荐Bean implements IDateData {
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 福利Bean implements IDateData {
            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }

    @Override
    public String toString() {
        return "DateData{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }
}
