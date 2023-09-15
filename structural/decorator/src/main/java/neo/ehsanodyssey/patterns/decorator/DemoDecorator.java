package neo.ehsanodyssey.patterns.decorator;

import neo.ehsanodyssey.patterns.decorator.datasource.DataSource;
import neo.ehsanodyssey.patterns.decorator.datasource.FileDataSource;
import neo.ehsanodyssey.patterns.decorator.decorators.CompressionDecorator;
import neo.ehsanodyssey.patterns.decorator.decorators.DataSourceDecorator;
import neo.ehsanodyssey.patterns.decorator.decorators.EncryptionDecorator;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoDecorator {

    /**
     * Also known as: Wrapper
     * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
     * these objects inside special wrapper objects that contain the behaviors.
     *
     * Extending a class is the first thing that comes to mind when you need to alter an object’s behavior.
     * However, inheritance has several serious caveats that you need to be aware of.
     *      1- Inheritance is static. You can’t alter the behavior of an existing object at runtime.
     *      You can only replace the whole object with another one that’s created from a different subclass.
     *      2- Subclasses can have just one parent class. In most languages, inheritance doesn’t let a class
     *      inherit behaviors of multiple classes at the same time.
     *
     * One of the ways to overcome these caveats is by using Aggregation or Composition  instead of Inheritance.
     * Both of the alternatives work almost the same way: one object has a reference to another and delegates
     * it some work, whereas with inheritance, the object itself is able to do that work, inheriting the behavior
     * from its superclass.
     *
     * “Wrapper” is the alternative nickname for the Decorator pattern that clearly expresses the main idea
     * of the pattern. A wrapper is an object that can be linked with some target object.
     * The wrapper contains the same set of methods as the target and delegates to it all requests it receives.
     * However, the wrapper may alter the result by doing something either before or after
     * it passes the request to the target.
     *
     * Decorator vs Adapter and Proxy
     *      Adapter changes the interface of an existing object, while Decorator enhances an object without changing its interface.
     *      In addition, Decorator supports recursive composition, which isn’t possible when you use Adapter.
     *      Adapter provides a different interface to the wrapped object, Proxy provides it with the same interface,
     *      and Decorator provides it with an enhanced interface.
     *
     */

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
