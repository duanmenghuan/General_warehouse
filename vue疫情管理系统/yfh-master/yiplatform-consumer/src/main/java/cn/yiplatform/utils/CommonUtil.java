package cn.yiplatform.utils;

import cn.yiplatform.contants.RegExpConstants;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @date 2022/3/9-23:04
 */
public class CommonUtil {

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static Date formatDate(Date date){
        // 指定格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = sdf.format(date);
        try {
            return sdf.parse(formatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取对象中属性值不为空的属性名，并将属性名与属性值组成Map
     * @param object
     * @return
     */
    public static Map<String, Object> getObjFieldNameAndValue(Object object){
        Field[] field = object.getClass().getDeclaredFields();
         Map<String, Object> nameValueHashMap = new HashMap<>();
        // 要排除的属性数据类型
        List<String> typeList = new ArrayList<>();
//        typeList.add("class java.lang.Long");
//        typeList.add("int");
        // 开始整合
        for(int j = 0; j < field.length; j++){
            String name = field[j].getName();
            // 将序列化id、 为空的属性名排除
            if (StringUtils.equals("serialVersionUID", name)
                    || StringUtils.isEmpty(name)){
                continue;
            }
            // 将属性名首字母大写，方便组成get方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m;
            Object value;
            try {
                // 获取方法
                m = object.getClass().getMethod("get" + name);
                // 获取属性的值
                value = m.invoke(object);
                // 获取属性的类型
                String type = field[j].getType().toString();
                // 值不为空
                if((!Objects.isNull(value)
                        && !typeList.contains(type))){
                   // 开始整合 map效果为 xxx_xxx -> xxx
                    String humpName = name.substring(0, 1).toLowerCase() + name.substring(1);
                    nameValueHashMap.put(CamelAndUnderLineConverterUtil.humpToLine(humpName), value);
                }
            } catch (IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException
                    | NoSuchMethodException
                    | SecurityException e) {
                e.printStackTrace();
            }
        }
        return nameValueHashMap;
    }

    /**
     * 获取前端传输必填字段为空的字段名
     * @param columnName
     * @param addContentMap
     * @return
     */
    public static Map<String, Object> getEmptyColumnMap(String columnName, Map<String, Object> addContentMap) {
        Map<String, Object> emptyColumnMap = new HashMap<>();
        Map<String, String> columnMap = JSON.parseObject(columnName, Map.class);
        for (String key : columnMap.keySet()) {
            // 将驼峰型变量名转换成下划线型
            String underLineKey = CamelAndUnderLineConverterUtil.humpToLine(key);
            if (Objects.isNull(addContentMap.get(underLineKey))
                    || Objects.isNull(addContentMap.get(underLineKey))
                    || StringUtils.isEmpty(addContentMap.get(underLineKey).toString())) {
                // 值为空则保存下来
                emptyColumnMap.put(key, columnMap.get(key));
            }
        }
        return emptyColumnMap;
    }

    /**
     * 取出花括号中的字符串(包含花括号) eg: xxxx{yyyyyy} => {yyyyyy}
     * @param str
     * @return
     */
    public static String getContentInBrace(String str) {
        String resultStr;
        Pattern reg = Pattern.compile(RegExpConstants.CONTENT_IN_BRACE, Pattern.DOTALL);
        boolean b = reg.matcher(str).find();
        if (!b) {
            return str;
        }
        resultStr = str.replaceFirst(RegExpConstants.CONTENT_IN_BRACE, "{");
        return resultStr;
    }
}
