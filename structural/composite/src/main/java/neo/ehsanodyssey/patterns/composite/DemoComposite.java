package neo.ehsanodyssey.patterns.composite;

import neo.ehsanodyssey.patterns.composite.editor.ImageEditor;
import neo.ehsanodyssey.patterns.composite.shapes.Circle;
import neo.ehsanodyssey.patterns.composite.shapes.CompoundShape;
import neo.ehsanodyssey.patterns.composite.shapes.Dot;
import neo.ehsanodyssey.patterns.composite.shapes.Rectangle;

import java.awt.*;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoComposite {

    /**
     * Also known as: Object Tree
     * Composite is a structural design pattern that lets you compose objects into tree structures
     * and then work with these structures as if they were individual objects.
     * Using the Composite pattern makes sense only when the core model of your app can be represented as a tree.
     */

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
