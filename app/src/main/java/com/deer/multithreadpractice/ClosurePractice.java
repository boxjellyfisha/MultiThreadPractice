package com.deer.multithreadpractice;

public class ClosurePractice {

    public void helloAnonymous(String world) {
        System.out.println(helloClosure(world, new ChangeStr() {
                    @Override
                    public void change(String origin) {
                        System.out.println("InAnonymous: " + origin);
                        origin = origin + " world";
                        System.out.println("InAnonymous change: " + origin);
                    }
                }
        ));
        System.out.println("OutAnonymous: " + world);
    }

    public void helloClosure(String world) {
        System.out.println(helloClosure(world, (String s) -> {
                    System.out.println("InClosure: " + s);
                    s = s + " world";
                    System.out.println("InClosure change: " + s);
                }
        ));
        System.out.println("OutClosure: " + world);
    }

    interface ChangeStr {
        void change(String origin);
    }

    private String helloClosure(String origin, ChangeStr ss) {
        ss.change(origin);
        origin = "first " + origin;
        return origin;
    }
}
