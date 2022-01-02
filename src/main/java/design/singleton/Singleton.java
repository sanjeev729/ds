package design.singleton;

import thread.countdownlatch.CountDownLatchDemo;

public class Singleton {
	
	private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }

}

final class Singleton2 {

    private static volatile Singleton2 instance = null;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
    
    
  //Java program for Enum type singleton to overcome reflection
    public enum Singleton 
    {
      INSTANCE;
    }
}
