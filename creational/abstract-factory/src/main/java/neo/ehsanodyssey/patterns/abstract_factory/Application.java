package neo.ehsanodyssey.patterns.abstract_factory;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Checkbox;
import neo.ehsanodyssey.patterns.abstract_factory.gui.Button;
import neo.ehsanodyssey.patterns.abstract_factory.factories.GUIFactory;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        this.button.paint();
        this.checkbox.paint();
    }
}
