package cn.com.scitc;

import cn.com.scitc.client.URLHandle;
import cn.com.scitc.model.Jobs;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.*;

public class JobMain {

    public static void main(String[] args) {


        System.out.println("正在生成客户端...");
        HttpClient client = null;
        System.out.println("客户端生成完毕.");


        String[] city = {"重庆"};


        String[] value = {
                "060000"
        };


        int pagesize = 1;
        boolean splider = true;
        for (int num = 0; num <410; num ++) {
            while (splider) {
//                000000,0000,01,9,99 其中01是计算机的 打开51job网,搜索对应的之后看他的url地址栏变化
                String url = "https://search.51job.com/list/"+ value[num] +  ",000000,0000,01,9,99," + city[num] + ",2," + pagesize++ + ".html";

                System.err.println("正在爬取当前第" + pagesize + "页数据");
                System.err.println("正在爬取:" + city[num] + "城市" );
                System.out.println(url);

                List<Jobs> jobsList = null;

                System.out.println("正在生成客户端...");
                client = HttpClientBuilder.create().build();
                System.out.println("客户端生成完毕.");

                //开始解析
                try {
                    System.out.println("开始响应客户端...");
                    try {
                        Thread.sleep(200);
                        jobsList = URLHandle.urlParser(client, url);

                       if (jobsList.iterator().next().getJobName() == null) {
                           pagesize  = 1;
                           break;
                       }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("响应完成.");
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println("开始输出结果...");

                for (Jobs job : jobsList) {


                }
                System.out.println("整个结果输出完毕，程序结束.");
            }


        }

    }



}
