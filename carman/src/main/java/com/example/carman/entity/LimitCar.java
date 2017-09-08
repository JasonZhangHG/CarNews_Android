package com.example.carman.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */

public class LimitCar {
    /**
     * reason : 查询成功
     * result : [{"city":"beijing","cityname":"北京"},{"city":"guiyang","cityname":"贵阳"},{"city":"hangzhou","cityname":"杭州"},{"city":"lanzhou","cityname":"兰州"},{"city":"tianjin","cityname":"天津"},{"city":"chengdu","cityname":"成都"},{"city":"nanchang","cityname":"南昌"},{"city":"changchun","cityname":"长春"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * city : beijing
         * cityname : 北京
         */

        private String city;
        private String cityname;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityname() {
            return cityname;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }
    }
}
