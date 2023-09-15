package neo.ehsanodyssey.patterns.abstract_factory.gui.win;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Checkbox;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Painting a checkbox in Windows style.");
    }
}
