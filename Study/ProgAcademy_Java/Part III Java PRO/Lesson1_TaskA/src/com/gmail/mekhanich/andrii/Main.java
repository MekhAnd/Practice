package com.gmail.mekhanich.andrii;

public class Main {

    private static MyAnnotations myAnnotations;

    public static void main(String[] args) {
        final Class<?> cls = Test.class;

        if (cls.isAnnotationPresent(MyAnnotations.class)) {
            MyAnnotations man = cls.getAnnotation(MyAnnotations.class);

            System.out.println(Test.test(man.parametrOne(), man.parametrTwo()));
            System.out.println();
            Test a = new Test();
            a.tst(man.parametrOne(), man.parametrTwo());

        }
    }

}
