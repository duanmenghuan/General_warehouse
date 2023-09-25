package cn.yiplatform.utils;

import cn.yiplatform.contants.RegExpContants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @date 2022/3/21-16:38
 */
public class CommonUtil {
    /**
     * 取出花括号中的字符串(包含花括号) eg: xxxx{yyyyyy} => {yyyyyy}
     * @param str
     * @return
     */
    public static String getContentInBrace(String str) {
        String resultStr;
        Pattern reg = Pattern.compile(RegExpContants.CONTENT_IN_BRACE, Pattern.DOTALL);
        boolean b = reg.matcher(str).find();
        if (!b) {
            return str;
        }
        resultStr = str.replaceFirst(RegExpContants.CONTENT_IN_BRACE, "{");
        return resultStr;
    }
    // 获取值为空的属性名称
    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null
                    || StringUtils.equals(StringUtils.EMPTY, String.valueOf(srcValue)))
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
