package com.gmail.mekhanich.andrii;

@MyAnnotations
public class Test {
    public Test() {
    }

    @Method
    public static int test(int a, int b) {
        int res = a + b;
        return res;
    }

    @Method
    public void tst(int a, int b) {
        System.out.println(test(a, b));
    }
}
