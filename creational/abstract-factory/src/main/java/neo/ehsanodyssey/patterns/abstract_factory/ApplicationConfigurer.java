package neo.ehsanodyssey.patterns.abstract_factory;

import neo.ehsanodyssey.patterns.abstract_factory.factories.GUIFactory;
import neo.ehsanodyssey.patterns.abstract_factory.factories.MacFactory;
import neo.ehsanodyssey.patterns.abstract_factory.factories.WindowsFactory;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class ApplicationConfigurer {

    public static Application configureApplication(String os) {
        Application app;
        GUIFactory factory;
        if (os == null || os.trim().equals("")) {
            throw new IllegalArgumentException("os must not be null");
        }
        if (os.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
            app = new Application(factory);
        } else if (os.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            throw new IllegalStateException("Cannot provide factory for OS: "+os);
        }
        return app;
    }
}
