package com.example.day07.inter;

// 인터페이스 끼리는 다중 상속이 가능함
// 어차피 구현되어 있지 않기에
// 같은 이름의 메스드로 인한 충돌이 생기지 않음
public interface Dinter extends Cinter, Binter, Ainter{
    public void dMethod();
}
