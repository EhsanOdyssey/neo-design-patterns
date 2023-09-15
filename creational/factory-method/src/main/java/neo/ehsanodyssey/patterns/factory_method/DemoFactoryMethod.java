package neo.ehsanodyssey.patterns.factory_method;

import neo.ehsanodyssey.patterns.factory_method.factory.Dialog;
import neo.ehsanodyssey.patterns.factory_method.factory.HtmlDialog;
import neo.ehsanodyssey.patterns.factory_method.factory.WindowsDialog;

import java.util.Scanner;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Mon 22 Nov 2021
 */
public class DemoFactoryMethod {

    /**
     * Also known as: Virtual Constructor
     * Factory Method is a creational design pattern that provides an interface for creating objects in a superclass,
     * but allows subclasses to alter the type of objects that will be created.
     * The Factory Method pattern let you replace direct object construction calls with calls to a special factory method.
     */

    private static Dialog dialog;

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure(String factory) {
        if (factory.equalsIgnoreCase("windows")) {
            dialog = new WindowsDialog();
        } else if (factory.equalsIgnoreCase("html")) {
            dialog = new HtmlDialog();
        } else {
            throw new IllegalStateException("Cannot provide factory for: "+factory);
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available factories:\n1- windows\n2- html\n3- exit");
        System.out.println("Choose your factory: ");
        String choice = scanner.nextLine();
        String factory = "";
        if (choice != null) {
            if (choice.equals("1") || choice.equalsIgnoreCase("windows")) {
                factory = "windows";
            } else if (choice.equals("2") || choice.equalsIgnoreCase("html")) {
                factory = "html";
            } else if (choice.equals("3") || choice.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                factory = choice;
            }
        }
        configure(factory);
        runBusinessLogic();
    }
}
