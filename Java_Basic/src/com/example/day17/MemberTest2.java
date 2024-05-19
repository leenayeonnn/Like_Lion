package com.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemberTest2 {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("lee", 100, Member.FEMALE),
                new Member("kim", 90, Member.MALE),
                new Member("park", 80, Member.FEMALE),
                new Member("kang", 70, Member.MALE),
                new Member("son", 60, Member.FEMALE)
        );

        Map<Integer, List<Member>> mapBySex = list.stream()
                .collect(Collectors.groupingBy(Member::getSex));

        System.out.println("- 남자 -");
        mapBySex.get(Member.MALE).forEach(member -> System.out.println(member.getName()));


        System.out.println("- 여자 -");
        mapBySex.get(Member.FEMALE).forEach(member -> System.out.println(member.getName()));

    }
}
