package cn.yiplatform.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @date 2022/3/28-20:09
 * 工具类 MD5加密
 */
public class MD5Util {
    /**
     * 加密
     * @param password
     * @return
     */
    public static String md5(String password) {
        try {
            // 生成一个16位的随机数
            Random random = new Random();
            StringBuilder sBuilder = new StringBuilder(16);
            sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
            int len = sBuilder.length();
            if (len < 16) {
                for (int i = 0; i < 16 - len; i++) {
                    sBuilder.append("0");
                }
            }
            // 生成最终的加密盐
            String salt = sBuilder.toString();
            MessageDigest md = MessageDigest.getInstance("MD5");

            password = Hex.encodeHexString(md.digest(password.getBytes(StandardCharsets.UTF_8)));
            char[] cs = new char[48];
            for (int i = 0; i < 48; i += 3) {
                cs[i] = password.charAt(i / 3 * 2);
                char c = salt.charAt(i / 3);
                cs[i + 1] = c;
                cs[i + 2] = password.charAt(i / 3 * 2 + 1);
            }

            return password ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
