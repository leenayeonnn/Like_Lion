package com.example.day09.frequently_used_class;

public class StringEx {
    //물품번호를 받아들여서 물품번호규칙에 맞으면 true,
    // 아니면 false를 리턴하는 메소드를 완성하세요.
    // 조건1. 물품번호의 길이는 6이다.
    // 조건2. 물품번호의 1,2 번째 자리는 알파벳이어야 한다. (대소문자 모두 가능)
    // 조건3. 물품번호의 3-6 자리수는 숫자만 가능하다.

    public static void main(String[] args) {
        StringEx se = new StringEx();
        System.out.println(se.checkProductNumber("te3456")); // true
        System.out.println(se.checkProductNumber("t33456")); //false
        System.out.println(se.checkProductNumber("ar49786"));//false
        System.out.println(se.checkProductNumber("test56"));//false
    }

    public boolean checkProductNumber(String productNumber) {
        if (productNumber.length() != 6) {
            return false;
        }

        if (!(checkIsAlphabet(productNumber.charAt(0)) && checkIsAlphabet(productNumber.charAt(1)))) {
            return false;
        }

        for (int i = 2; i < 6; i++) {
            if (!(checkIsNumber(productNumber.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIsNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean checkIsAlphabet(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}