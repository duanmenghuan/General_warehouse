package cn.com.scitc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class BaiduSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要搜索的关键字：");
        String keyword = scanner.nextLine();
        String url = "https://www.baidu.com/s?wd=" + keyword;
        String result = sendGetRequest(url);
        System.out.println(result);
    }

    private static String sendGetRequest(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.addRequestProperty("Content-Type", "text/html; charset=utf-8"); // 设置编码方式为UTF-8
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); // 使用UTF-8编码读取
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

