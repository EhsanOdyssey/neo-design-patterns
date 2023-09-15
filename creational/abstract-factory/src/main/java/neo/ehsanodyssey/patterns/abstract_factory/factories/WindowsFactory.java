package neo.ehsanodyssey.patterns.abstract_factory.factories;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Checkbox;
import neo.ehsanodyssey.patterns.abstract_factory.gui.Button;
import neo.ehsanodyssey.patterns.abstract_factory.gui.win.WindowsButton;
import neo.ehsanodyssey.patterns.abstract_factory.gui.win.WindowsCheckbox;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public String getName() {
        return "WINDOWS";
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
