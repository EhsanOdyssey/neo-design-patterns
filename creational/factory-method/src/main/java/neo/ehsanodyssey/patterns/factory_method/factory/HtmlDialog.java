package neo.ehsanodyssey.patterns.factory_method.factory;

import neo.ehsanodyssey.patterns.factory_method.buttons.Button;
import neo.ehsanodyssey.patterns.factory_method.buttons.HtmlButton;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Mon 22 Nov 2021
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
