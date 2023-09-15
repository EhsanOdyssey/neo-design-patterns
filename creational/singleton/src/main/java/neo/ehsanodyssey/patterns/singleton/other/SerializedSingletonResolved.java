package neo.ehsanodyssey.patterns.singleton.other;

import java.io.Serializable;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class SerializedSingletonResolved implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingletonResolved() {
    }

    private static class SingletonHelper {
        private static final SerializedSingletonResolved INSTANCE = new SerializedSingletonResolved();
    }

    public static SerializedSingletonResolved getInstance() {
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
