package com.example.day07.obj.bird;

// abstract
//  추상적인 내용을 틀로만 만들어 놓음
//  일반화를 위해서 만들어 놓은 것
//  자식 클래스는 무조건 해당 내용을 구현 해야함
//  추상을 상속받은 자식 또한 추상으로 설정 할 수 있음
//      이때, 손자가 구현 해야함
abstract public class Bird {
    abstract public void sing();
}

