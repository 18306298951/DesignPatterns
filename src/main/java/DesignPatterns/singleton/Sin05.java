package DesignPatterns.singleton;

/**
 * 懒汉模式 线程安全  双重检查锁 DCL
 * 要不要加volatile 要加
 * 单例的对象的初始化 分三步 1 分配内存 2 设值 3 把指针指向他 不加volatile 会出现 2和3 颠倒
 */
public class Sin05 {
    private static volatile Sin05 INSTANCE;

    private Sin05() {

    }

    public static Sin05 getINSTANCE() {
        if (INSTANCE == null){
            synchronized(Sin05.class){
                if (INSTANCE == null){
                    INSTANCE =  new Sin05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i <100 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t"+ Sin05.getINSTANCE().hashCode());
            }, i+"").start();
        }

    }
}
