package com.android.app.dengzhaojun.inspiring.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */

public class Inspiring_Json {
    /**
     * showapi_res_error :
     * showapi_res_id : 185c2fc805dc4ee4ae62c08e4c0634ad
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"data":[{"english":"However mean your life is,meet it and live it;do not shun it and call it hard names.","chinese":"不论你的生活如何悲凉，你都要面对它好好过，不要躲避它，更别用恶言咒骂它。"},{"english":"While there is life, there is hope.","chinese":"有生命就有希望/留得青山在，不怕没柴烧。"},{"english":"Life is boring,and the heart is also lonely.","chinese":"生活是无聊的，并且心也是孤独的。"},{"english":"Who travels for love finds a thousand miles not longer thanone.","chinese":"在爱人眼里，一千里的旅程不过一里。"},{"english":"All things are difficult before they are easy.","chinese":"凡事必先难后易。"}],"ret_message":"Success"}
     */

    private String showapi_res_error;
    private String showapi_res_id;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * data : [{"english":"However mean your life is,meet it and live it;do not shun it and call it hard names.","chinese":"不论你的生活如何悲凉，你都要面对它好好过，不要躲避它，更别用恶言咒骂它。"},{"english":"While there is life, there is hope.","chinese":"有生命就有希望/留得青山在，不怕没柴烧。"},{"english":"Life is boring,and the heart is also lonely.","chinese":"生活是无聊的，并且心也是孤独的。"},{"english":"Who travels for love finds a thousand miles not longer thanone.","chinese":"在爱人眼里，一千里的旅程不过一里。"},{"english":"All things are difficult before they are easy.","chinese":"凡事必先难后易。"}]
         * ret_message : Success
         */

        private int ret_code;
        private String ret_message;
        private List<DataBean> data;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getRet_message() {
            return ret_message;
        }

        public void setRet_message(String ret_message) {
            this.ret_message = ret_message;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * english : However mean your life is,meet it and live it;do not shun it and call it hard names.
             * chinese : 不论你的生活如何悲凉，你都要面对它好好过，不要躲避它，更别用恶言咒骂它。
             * mUserIcon:  自定义图片资源
             */

            private String english;
            private String chinese;
            private int mUserIcon;

            public DataBean(int mItemBg){
                this.mUserIcon = mItemBg;
            }

            public void setmUserIcon(int mUserIcon) {
                this.mUserIcon = mUserIcon;
            }

            public int getmUserIcon() {
                return mUserIcon;
            }

            public String getEnglish() {
                return english;
            }

            public void setEnglish(String english) {
                this.english = english;
            }

            public String getChinese() {
                return chinese;
            }

            public void setChinese(String chinese) {
                this.chinese = chinese;
            }
        }
    }
}
