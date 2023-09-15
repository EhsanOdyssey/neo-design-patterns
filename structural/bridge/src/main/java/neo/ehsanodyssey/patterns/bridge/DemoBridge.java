package neo.ehsanodyssey.patterns.bridge;

import neo.ehsanodyssey.patterns.bridge.devices.Device;
import neo.ehsanodyssey.patterns.bridge.devices.Radio;
import neo.ehsanodyssey.patterns.bridge.devices.Tv;
import neo.ehsanodyssey.patterns.bridge.remotes.AdvancedRemote;
import neo.ehsanodyssey.patterns.bridge.remotes.BasicRemote;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoBridge {

    /**
     * Bridge is a structural design pattern that lets you split a large class or a set of closely related classes
     * into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
     * Problem:
     *  Shape class with a pair of subclasses: Circle and Square. You want to extend this class hierarchy to
     *  incorporate colors, so you plan to create Red and Blue shape subclasses.
     *  However, since you already have two subclasses, you’ll need to create four class combinations
     *  such as BlueCircle, BlueSquare and RedCircle, RedSquare.
     *  Adding new shape types and colors to the hierarchy will grow it exponentially.
     * Solution:
     *  This problem occurs because we’re trying to extend the shape classes in two independent dimensions:
     *  by form and by color. That’s a very common issue with class inheritance.
     *  The Bridge pattern attempts to solve this problem by switching from inheritance to the object composition.
     *  What this means is that you extract one of the dimensions into a separate class hierarchy, so that
     *  the original classes will reference an object of the new hierarchy, instead of having all of its state
     *  and behaviors within one class.
     *
     * Abstraction (also called interface) is a high-level control layer for some entity.
     * This layer isn’t supposed to do any real work on its own.
     * It should delegate the work to the implementation layer (also called platform).
     *      Abstraction: the GUI layer of the app.
     *      Implementation: the operating systems’ APIs.
     * The abstraction object controls the appearance of the app, delegating the actual work to the linked
     * implementation object. Different implementations are interchangeable as long as they follow a common interface,
     * enabling the same GUI to work under Windows and Linux.
     *
     * Usage examples:
     *      The Bridge pattern is especially useful when dealing with cross-platform apps,
     *      supporting multiple types of database servers or working with several API providers of a certain kind
     *      (for example, cloud platforms, social networks, etc.)
     *
     * Identification:
     *      Bridge can be recognized by a clear distinction between some controlling entity and several
     *      different platforms that it relies on.
     */

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }
}
