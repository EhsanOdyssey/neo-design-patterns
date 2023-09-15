package neo.ehsanodyssey.patterns.flyweight;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoFlyweight {

    /**
     * Also known as: Cache
     * Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM
     * by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
     *
     * On closer inspection of the Particle class, you may notice that the color and sprite fields consume
     * a lot more memory than other fields. What’s worse is that these two fields store almost identical data across
     * all particles. For example, all bullets have the same color and sprite.
     * Other parts of a particle’s state, such as coordinates, movement vector and speed, are unique to each particle.
     * After all, the values of these fields change over time. This data represents the always changing context
     * in which the particle exists, while the color and sprite remain constant for each particle.
     *
     * This constant data of an object is usually called the intrinsic state. It lives within the object;
     * other objects can only read it, not change it. The rest of the object’s state, often altered “from the outside”
     * by other objects, is called the extrinsic state.
     * The Flyweight pattern suggests that you stop storing the extrinsic state inside the object.
     * Instead, you should pass this state to specific methods which rely on it. Only the intrinsic state stays
     * within the object, letting you reuse it in different contexts. As a result, you’d need fewer of these objects
     * since they only differ in the intrinsic state, which has much fewer variations than the extrinsic.
     *
     * Since the same flyweight object can be used in different contexts, you have to make sure that
     * its state can’t be modified and is immutable.
     */

    /**
     * In this example, we’re going to render a forest (1.000.000 trees)! Each tree will be represented by
     * its own object that has some state (coordinates, texture and so on). Although the program does its primary job,
     * naturally, it consumes a lot of RAM.
     * The reason is simple: too many tree objects contain duplicate data (name, texture, color).
     * That’s why we can apply the Flyweight pattern and store these values inside separate flyweight objects
     * (the TreeType class). Now, instead of storing the same data in thousands of Tree objects, we’re going to
     * reference one of the flyweight objects with a particular set of values.
     * The client code isn’t going to notice anything since the complexity of reusing flyweight objects is buried
     * inside a flyweight factory.
     */

    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        forest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }
}
