package com.example.day07.main.inter;

import com.example.day07.inter.Ainter;
import com.example.day07.inter.Binter;
import com.example.day07.inter.Cinter;
import com.example.day07.inter.Dinter;
import com.example.day07.obj.implement.Aimple;
import com.example.day07.obj.implement.Dimple;

public class Test8 {
    public static void main(String[] args) {
        // 인터페이스도 타입이 될 수 있음
        Ainter ainter = new Dimple();
        Binter binter = new Dimple();
        Cinter cinter = new Dimple();
        Dinter dinter = new Dimple();

        // 해당 인터페이스가 제공하는 것만 사용 가능
        ainter.aMethod();

        binter.aMethod();
        binter.bMethod();

        cinter.cMethod();

        dinter.aMethod();
        dinter.cMethod();
        dinter.dMethod();

        Ainter a = new Aimple();
        ((Aimple)a).say();
    }
}
