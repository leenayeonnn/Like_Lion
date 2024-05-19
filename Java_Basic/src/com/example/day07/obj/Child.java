package com.example.day07.obj;

public class Child extends Parent {
    /**
     * 자식이 호출될 때 무조건 부모가 호출되기에
     * 상황에 따라서 생성자 작성에 유의
     */
    public Child(){
        super("no name", 0);
    }

    @Override
    public String getName(){
        System.out.println("자식 클래스에서 구현한 getName");
        return super.getName();
    }
}
