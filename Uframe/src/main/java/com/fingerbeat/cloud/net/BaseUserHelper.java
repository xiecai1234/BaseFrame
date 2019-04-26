package com.fingerbeat.cloud.net;

/**
 * Created by xiecaibao on 2018/10/31  TODO 子类继承
 */
public class BaseUserHelper {
//    private static final class UserInfo {
//        private static final String FILE_NAME = "UserInfo";
//        private static final String ACCESS_TOKEN = "access_token";
//        private static final String TOKEN_TYPE = "token_type";
//        private static final String USER_TYPE = "user_type";
//        private static final String PHONE = "phone";
//        private static final String USER_CODE_ID = "user_code_id";
//        private static final String BIND_STATE = "bind_state";
//        private static final String EXPIRES_IN = "expires_in";
//        private static final String REG_CODE_NUMBER = "reg_code_number";
//        private static final String REG_CODE = "reg_code";
//        //上次鉴权时间
//        private static final String LAST_AUTH_TIME = "lastAuthTime";
//    }

    private static BaseUserHelper instance;

    private BaseUserHelper() {
    }

    public static BaseUserHelper getInstance() {
        if (instance == null) {
            synchronized (BaseUserHelper.class) {
                if (instance == null) {
                    instance = new BaseUserHelper();
                }
            }
        }
        return instance;
    }

    /**
     * 用户是否登录
     */
    public boolean isLogin() {
//        String accessToken = PreferenceUtil.readString(BaseApplication.getContext(), UserInfo.FILE_NAME, UserInfo.ACCESS_TOKEN);
//        return !TextUtils.isEmpty(accessToken);
        return false;
    }


    public void saveToken(String accessToken, String tokenType) {
//        PreferenceUtil.saveString(App.getContext(), UserInfo.FILE_NAME, UserInfo.ACCESS_TOKEN, accessToken);
//        PreferenceUtil.saveString(App.getContext(), UserInfo.FILE_NAME, UserInfo.TOKEN_TYPE, tokenType);
    }



    public String getAccessToken() {
//        return PreferenceUtil.readString(App.getContext(), UserInfo.FILE_NAME, UserInfo.ACCESS_TOKEN);
        return "";
    }

    public String getTokenType() {
//        return PreferenceUtil.readString(App.getContext(), UserInfo.FILE_NAME, UserInfo.TOKEN_TYPE);
        return "";
    }

}
