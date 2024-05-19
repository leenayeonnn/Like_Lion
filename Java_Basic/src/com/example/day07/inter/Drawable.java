package com.example.day07.inter;

// 기존에 있던 interface에 기능을 추가하면
// 구현하는 모든 클래스에 문제가 발생함
// 따라서 default를 이용하여 구현이 가능하도록 만듦
public interface Drawable {
    default public void draw(){
        System.out.println("도형 그리기");
    }
}
