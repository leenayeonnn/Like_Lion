package com.example.day08.exception;

public class Test4 {
    public static void main(String[] args) {
        try {
            errand();
        } catch (Exception e) {
            System.out.println("해당 카테고리는 없음");
        }
    }

    public static void errand() throws Exception{
        System.out.println("심부름 시작");

        String[] category = {"식료품", "생필품"};

        int select = 2;
        String buy = category[select];

        System.out.println("심부름 끝 - " + buy);
    }
}
