package DesignPatterns.singleton;

/**
 * 懒汉模式 线程 不安全
 */
public class Sin02 {
    private static Sin02 INSTANCE;

    private Sin02() {

    }

    public static Sin02 getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE =  new Sin02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Sin02 sin01 = Sin02.getINSTANCE();
        Sin02 sin02 = Sin02.getINSTANCE();
        System.out.println(sin01==sin02);
    }
}
