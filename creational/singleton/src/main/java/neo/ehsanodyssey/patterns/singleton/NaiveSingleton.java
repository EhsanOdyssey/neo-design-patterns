package neo.ehsanodyssey.patterns.singleton;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class NaiveSingleton {
    private static NaiveSingleton instance;
    public String value;

    private NaiveSingleton(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static NaiveSingleton getInstance(String value) {
        if (instance == null) {
            instance = new NaiveSingleton(value);
        }
        return instance;
    }
}
