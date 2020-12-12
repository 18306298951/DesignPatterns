package DesignPatterns.singleton;

/**
 * 懒汉模式 线程安全
 */
public class Sin03 {
    private static Sin03 INSTANCE;

    private Sin03() {

    }

    public static  synchronized Sin03 getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE =  new Sin03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i <100 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t"+Sin03.getINSTANCE().hashCode());
            }, i+"").start();
        }

    }
}
