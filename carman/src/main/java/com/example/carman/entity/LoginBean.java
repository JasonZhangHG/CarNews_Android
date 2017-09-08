package com.example.carman.entity;

/**
 * Created by Administrator on 2017/5/14.
 */

public class LoginBean {

    /**
     * flag : 10001
     * code : 200
     * user : {"user_id":845,"user_tel":"15611820351","user_pwd":"123456","user_name":"傻狍子","user_img":"upload/20170311/385e35f5a0c0ea460fa8991a2fa7fed4112b.jpg"}
     */

    private int flag;
    private int code;
    private UserBean user;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * user_id : 845
         * user_tel : 15611820351
         * user_pwd : 123456
         * user_name : 傻狍子
         * user_img : upload/20170311/385e35f5a0c0ea460fa8991a2fa7fed4112b.jpg
         */

        private int user_id;
        private String user_tel;
        private String user_pwd;
        private String user_name;
        private String user_img;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_tel() {
            return user_tel;
        }

        public void setUser_tel(String user_tel) {
            this.user_tel = user_tel;
        }

        public String getUser_pwd() {
            return user_pwd;
        }

        public void setUser_pwd(String user_pwd) {
            this.user_pwd = user_pwd;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }
    }
}
