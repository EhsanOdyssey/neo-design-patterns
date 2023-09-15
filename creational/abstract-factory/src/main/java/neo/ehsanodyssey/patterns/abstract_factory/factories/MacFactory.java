package neo.ehsanodyssey.patterns.abstract_factory.factories;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Checkbox;
import neo.ehsanodyssey.patterns.abstract_factory.gui.Button;
import neo.ehsanodyssey.patterns.abstract_factory.gui.mac.MacButton;
import neo.ehsanodyssey.patterns.abstract_factory.gui.mac.MacCheckbox;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class MacFactory implements GUIFactory {

    @Override
    public String getName() {
        return "MAC";
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
