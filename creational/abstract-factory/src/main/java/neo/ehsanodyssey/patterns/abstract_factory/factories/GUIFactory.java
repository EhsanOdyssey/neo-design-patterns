package neo.ehsanodyssey.patterns.abstract_factory.factories;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Button;
import neo.ehsanodyssey.patterns.abstract_factory.gui.Checkbox;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public interface GUIFactory {
    String getName();
    Button createButton();
    Checkbox createCheckbox();
}
