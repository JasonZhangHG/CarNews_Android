package com.example.carman.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/5/10.
 */

public class CarNews  implements Serializable{

    /**
     * reason : 请求成功
     * result : {"list":[{"id":"wechat_20170512016368","title":"张大千外孙范汝愚： 微风拂来，乡愁的名字叫百花深处","source":"艺术野疯狂","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23434627.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512016368"},{"id":"wechat_20170512015602","title":"人品决定你的财气，说得太好了！","source":"爱我潘田","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23274516.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015602"},{"id":"wechat_20170512013335","title":"这么伟大的古建筑，我总觉得不能独享，不如画给你们看","source":"丝路遗产","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-22574784.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013335"},{"id":"wechat_20170512013754","title":"《西南商报》副刊（荐读）：【黄前】鸟鸣扎入记忆的痛处（外二首）","source":"成都祥涵文化传媒","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432990.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013754"},{"id":"wechat_20170512013871","title":"刘业勇：微笑是一缕和煦的风","source":"大军猫","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432998.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013871"},{"id":"wechat_20170512014745","title":"《长袜子皮皮》作者林格伦与倾慕者哈通：为不幸的爱而死是可能的","source":"文艺报1949","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433639.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014745"},{"id":"wechat_20170512014802","title":"【荐读】培养重义轻利的君子人格\u2014\u2014正确对待义与利","source":"中国报业","firstImg":"","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014802"},{"id":"wechat_20170512015696","title":"《左传》 经典30句，全是大智慧！","source":"民国文艺","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23434161.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015696"},{"id":"wechat_20170512015817","title":"\u201c让文物活起来讲好兖州故事\u201d 有奖征文启事","source":"兖州头条","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-13770896.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015817"},{"id":"wechat_20170512013046","title":"面对这4种情况，请务必收起你的善良。","source":"壹课","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-13578048.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013046"},{"id":"wechat_20170512013163","title":"据我观察，有两种人，生活品质都不高","source":"理财天下","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432699.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013163"},{"id":"wechat_20170512013128","title":"玛丽外语 --《一元城市生存挑战 》免费邀你来参加啦！","source":"豆豆创客生活馆","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432681.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013128"},{"id":"wechat_20170512013399","title":"一曲《爱上爱情爱上你》想你在相思的夜.....","source":"每晚一曲好音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432762.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013399"},{"id":"wechat_20170512013584","title":"再好的关系，也要讲分寸","source":"品茶时刻","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-19765432.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013584"},{"id":"wechat_20170512013580","title":"一辈子，真的好难，句句戳心！","source":"品茶时刻","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432851.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013580"},{"id":"wechat_20170512014740","title":"人生相识一场，不如彼此惦念，彼此相忘 | 生活","source":"文艺报1949","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433622.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014740"},{"id":"wechat_20170512015358","title":"请不要和儿女住在一起...一夜间刷爆朋友圈 ！","source":"传奇领袖商学院","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433862.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015358"},{"id":"wechat_20170512000972","title":"重大消息：2017年实体店将暴富！","source":"文琳资讯","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23418231.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512000972"},{"id":"wechat_20170512011389","title":"赵薇最念念不忘的男人，不是初恋陈坤黄晓明，而是逝世九年的他！","source":"娱乐圈那点事","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23431011.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512011389"},{"id":"wechat_20170512010983","title":"龙珠传奇：历史的血泪不容践踏\u2014\u2014\u201c明朝遗民\u201d的妆扮指南","source":"传统服饰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23430670.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512010983"}],"totalPage":3274,"ps":20,"pno":1}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean  implements Serializable {
        /**
         * list : [{"id":"wechat_20170512016368","title":"张大千外孙范汝愚： 微风拂来，乡愁的名字叫百花深处","source":"艺术野疯狂","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23434627.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512016368"},{"id":"wechat_20170512015602","title":"人品决定你的财气，说得太好了！","source":"爱我潘田","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23274516.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015602"},{"id":"wechat_20170512013335","title":"这么伟大的古建筑，我总觉得不能独享，不如画给你们看","source":"丝路遗产","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-22574784.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013335"},{"id":"wechat_20170512013754","title":"《西南商报》副刊（荐读）：【黄前】鸟鸣扎入记忆的痛处（外二首）","source":"成都祥涵文化传媒","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432990.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013754"},{"id":"wechat_20170512013871","title":"刘业勇：微笑是一缕和煦的风","source":"大军猫","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432998.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013871"},{"id":"wechat_20170512014745","title":"《长袜子皮皮》作者林格伦与倾慕者哈通：为不幸的爱而死是可能的","source":"文艺报1949","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433639.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014745"},{"id":"wechat_20170512014802","title":"【荐读】培养重义轻利的君子人格\u2014\u2014正确对待义与利","source":"中国报业","firstImg":"","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014802"},{"id":"wechat_20170512015696","title":"《左传》 经典30句，全是大智慧！","source":"民国文艺","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23434161.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015696"},{"id":"wechat_20170512015817","title":"\u201c让文物活起来讲好兖州故事\u201d 有奖征文启事","source":"兖州头条","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-13770896.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015817"},{"id":"wechat_20170512013046","title":"面对这4种情况，请务必收起你的善良。","source":"壹课","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-13578048.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013046"},{"id":"wechat_20170512013163","title":"据我观察，有两种人，生活品质都不高","source":"理财天下","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432699.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013163"},{"id":"wechat_20170512013128","title":"玛丽外语 --《一元城市生存挑战 》免费邀你来参加啦！","source":"豆豆创客生活馆","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432681.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013128"},{"id":"wechat_20170512013399","title":"一曲《爱上爱情爱上你》想你在相思的夜.....","source":"每晚一曲好音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432762.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013399"},{"id":"wechat_20170512013584","title":"再好的关系，也要讲分寸","source":"品茶时刻","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-19765432.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013584"},{"id":"wechat_20170512013580","title":"一辈子，真的好难，句句戳心！","source":"品茶时刻","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23432851.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512013580"},{"id":"wechat_20170512014740","title":"人生相识一场，不如彼此惦念，彼此相忘 | 生活","source":"文艺报1949","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433622.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512014740"},{"id":"wechat_20170512015358","title":"请不要和儿女住在一起...一夜间刷爆朋友圈 ！","source":"传奇领袖商学院","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23433862.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512015358"},{"id":"wechat_20170512000972","title":"重大消息：2017年实体店将暴富！","source":"文琳资讯","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23418231.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512000972"},{"id":"wechat_20170512011389","title":"赵薇最念念不忘的男人，不是初恋陈坤黄晓明，而是逝世九年的他！","source":"娱乐圈那点事","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23431011.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512011389"},{"id":"wechat_20170512010983","title":"龙珠传奇：历史的血泪不容践踏\u2014\u2014\u201c明朝遗民\u201d的妆扮指南","source":"传统服饰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-23430670.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170512010983"}]
         * totalPage : 3274
         * ps : 20
         * pno : 1
         */

        private int totalPage;
        private int ps;
        private int pno;
        private List<ListBean> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getPno() {
            return pno;
        }

        public void setPno(int pno) {
            this.pno = pno;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean  implements Serializable{
            /**
             * id : wechat_20170512016368
             * title : 张大千外孙范汝愚： 微风拂来，乡愁的名字叫百花深处
             * source : 艺术野疯狂
             * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-23434627.jpg/640
             * mark :
             * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20170512016368
             */

            private String id;
            private String title;
            private String source;
            private String firstImg;
            private String mark;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getFirstImg() {
                return firstImg;
            }

            public void setFirstImg(String firstImg) {
                this.firstImg = firstImg;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
