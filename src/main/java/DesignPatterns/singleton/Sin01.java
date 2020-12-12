package DesignPatterns.singleton;

/**
 * 饿汉模式
 */
public class Sin01 {
    private static Sin01 INSTANCE = new Sin01();

    private Sin01() {

    }

    public static Sin01 getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Sin01 sin01 = Sin01.getINSTANCE();
        Sin01 sin02 = Sin01.getINSTANCE();
        System.out.println(sin01==sin02);
    }

}
