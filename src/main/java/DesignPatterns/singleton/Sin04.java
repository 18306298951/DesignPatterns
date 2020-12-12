package DesignPatterns.singleton;

/**
 * 懒汉模式 线程不安全
 */
public class Sin04 {
    private static Sin04 INSTANCE;

    private Sin04() {

    }

    public static  Sin04 getINSTANCE() {
        if (INSTANCE == null){
            synchronized(Sin04.class){
                INSTANCE =  new Sin04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i <100 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t"+ Sin04.getINSTANCE().hashCode());
            }, i+"").start();
        }

    }
}
