package org.example.aopexam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String doSomething() {
        System.out.println("simpleService - doSomething Method");
        return "doing something";
    }

    public void hello(){
        System.out.println("hello method run@@@");
    }

    public void setName(String name){
        System.out.println("run setName");
    }
}
