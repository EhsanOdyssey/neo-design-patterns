package neo.ehsanodyssey.patterns.prototype;

import neo.ehsanodyssey.patterns.prototype.shapes.Circle;
import neo.ehsanodyssey.patterns.prototype.shapes.Rectangle;
import neo.ehsanodyssey.patterns.prototype.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Mon 22 Nov 2021
 */
public class DemoPrototype {

    /**
     * Also known as: Clone
     * Prototype is a creational design pattern that lets you copy existing objects
     * without making your code dependent on their classes.
     */

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical");
                } else {
                    System.out.println(i + ": But they are not identical");
                }
            } else {
                System.out.println(i + ": Shape objects are the same");
            }
        }
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "yellow";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }
}
