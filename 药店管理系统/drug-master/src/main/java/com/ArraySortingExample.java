package com;

class SnailClimbing {
    public static void main(String[] args) {
        double wellHeight = 56.7;  // ���ĸ߶ȣ��ף�
        double climbDistance = 5.0;  // ���������ľ��루�ף�
        double slipDistance = 3.5;  // ���ϻ���ľ��루�ף�
        double totalDistance = 0.0;  // ��ţ�������ܾ��루�ף�
        int days = 0;  // ����������

        while (totalDistance < wellHeight) {
            days++;
            totalDistance += climbDistance;

            if (totalDistance >= wellHeight) {
                break;  // ����Ѿ��������ڣ�������ѭ��
            }

            totalDistance -= slipDistance;
        }

        System.out.println("��ţ��Ҫ " + days + " ����ܴӾ�����������");
    }
}
