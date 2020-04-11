package com.hbfeng.oauth.resource.util;

import java.util.regex.Pattern;

public class CheckFormat {
    static Pattern email =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    static Pattern phone = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号

    public static boolean isEmail(String input){
        return email.matcher(input).matches();
    }

    public static boolean isPhone(String input){
        return phone.matcher(input).matches();
    }

}
