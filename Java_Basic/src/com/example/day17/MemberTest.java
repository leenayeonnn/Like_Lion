package com.example.day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MemberTest {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("lee", 100),
                new Member("kim", 90),
                new Member("park", 80),
                new Member("kang", 70),
                new Member("son", 60)
        );

        int scoreSum = members.stream().mapToInt(Member::getScore).reduce(0, Integer::sum);
        System.out.println(scoreSum);

        int scoreSum2 = members.stream().mapToInt(Member::getScore).sum();
        System.out.println(scoreSum2);

        int scoreSum3 = members.stream().mapToInt(Member::getScore)
                .reduce(Integer::sum).getAsInt();
        System.out.println(scoreSum3);

    }
}
