package neo.ehsanodyssey.patterns.singleton;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoSingleton {

    /**
     * Singleton is a creational design pattern that lets you ensure that a class has only one instance,
     * while providing a global access point to this instance.
     * The Singleton pattern solves two problems at the same time, violating the Single Responsibility Principle:
     * 1- Ensure that a class has just a single instance.
     * 2- Provide a global access point to that instance.
     */

    public static void naiveSingleton_SingleThreaded() {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n" +
                "RESULT:");
        NaiveSingleton singleton = NaiveSingleton.getInstance("FOO");
        NaiveSingleton anotherSingleton = NaiveSingleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

    static class ThreadFooForNaiveSingleton implements Runnable {
        @Override
        public void run() {
            NaiveSingleton singleton = NaiveSingleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBarForNaiveSingleton implements Runnable {
        @Override
        public void run() {
            NaiveSingleton singleton = NaiveSingleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

    public static void naiveSingleton_MultiThreaded() {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n" +
                "RESULT:");
        Thread threadFoo = new Thread(new ThreadFooForNaiveSingleton());
        Thread threadBar = new Thread(new ThreadBarForNaiveSingleton());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFooForThreadSafe implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBarForThreadSafe implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

    public static void threadSafeSingleton_MultiThreaded() {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n" +
                "RESULT:");
        Thread threadFoo = new Thread(new ThreadFooForThreadSafe());
        Thread threadBar = new Thread(new ThreadBarForThreadSafe());
        threadFoo.start();
        threadBar.start();
    }

    public static void main(String[] args) {
        System.out.println("---> SingleThread");
        naiveSingleton_SingleThreaded();
        System.out.println("---> MultiThread");
        naiveSingleton_MultiThreaded();
        System.out.println("---> ThreadSafe");
        threadSafeSingleton_MultiThreaded();
    }
}
