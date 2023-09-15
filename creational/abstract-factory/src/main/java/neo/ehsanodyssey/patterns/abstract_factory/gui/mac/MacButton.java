package neo.ehsanodyssey.patterns.abstract_factory.gui.mac;

import neo.ehsanodyssey.patterns.abstract_factory.gui.Button;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Painting a button in Mac style.");
    }
}
