package neo.ehsanodyssey.patterns.factory_method.factory;

import neo.ehsanodyssey.patterns.factory_method.buttons.Button;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Mon 22 Nov 2021
 */
public abstract class Dialog {

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();

    public void renderWindow() {
        // ... other code ...
        Button okButton = createButton();
        okButton.render();
    }
}
