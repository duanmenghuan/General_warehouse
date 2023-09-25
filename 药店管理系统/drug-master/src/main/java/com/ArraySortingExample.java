package com;

class SnailClimbing {
    public static void main(String[] args) {
        double wellHeight = 56.7;  // 井的高度（米）
        double climbDistance = 5.0;  // 白天爬升的距离（米）
        double slipDistance = 3.5;  // 晚上滑落的距离（米）
        double totalDistance = 0.0;  // 蜗牛爬升的总距离（米）
        int days = 0;  // 天数计数器

        while (totalDistance < wellHeight) {
            days++;
            totalDistance += climbDistance;

            if (totalDistance >= wellHeight) {
                break;  // 如果已经爬出井口，则跳出循环
            }

            totalDistance -= slipDistance;
        }

        System.out.println("蜗牛需要 " + days + " 天才能从井底爬出来。");
    }
}
