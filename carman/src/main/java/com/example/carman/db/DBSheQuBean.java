package com.example.carman.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Json on 2017/5/18.
 */
@Entity // 标识实体类，greenDAO会映射成sqlite的一个表，表名为实体类名的大写形式
public class DBSheQuBean {
    @Id(autoincrement = false)
    public long creatTimeAsId;//录入的具体数据的时间作为ID
    @Property(nameInDb = "DBSheQuBean")
    private String userName;//当前用户名字
    private  String id;//社区新闻ID
    private  String title;//社区新闻标题
    private  String firstImg;//社区封面URL
    private  String url;//社区新闻详情URL
    private  String source;//社区新闻来源
    @Generated(hash = 366685973)
    public DBSheQuBean(long creatTimeAsId, String userName, String id, String title,
            String firstImg, String url, String source) {
        this.creatTimeAsId = creatTimeAsId;
        this.userName = userName;
        this.id = id;
        this.title = title;
        this.firstImg = firstImg;
        this.url = url;
        this.source = source;
    }
    @Generated(hash = 249861403)
    public DBSheQuBean() {
    }
    public long getCreatTimeAsId() {
        return this.creatTimeAsId;
    }
    public void setCreatTimeAsId(long creatTimeAsId) {
        this.creatTimeAsId = creatTimeAsId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirstImg() {
        return this.firstImg;
    }
    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "DBSheQuBean{" +
                "creatTimeAsId=" + creatTimeAsId +
                ", userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", firstImg='" + firstImg + '\'' +
                ", url='" + url + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
