package neo.ehsanodyssey.patterns.abstract_factory;

import java.util.Scanner;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class DemoAbstractFactory {

    /**
     * Abstract Factory is a creational design pattern that lets you produce families of related objects
     * without specifying their concrete classes.
     * A family of related products with several variants of this family.
     * For example, products Chair + Sofa + CoffeeTable are available in these variants: Modern, Victorian, ArtDeco.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available factories:\n1- win\n2- mac\n3- exit");
        System.out.println("Choose your factory: ");
        String choice = scanner.nextLine();
        String os = "";
        if (choice != null) {
            if (choice.equals("1") || choice.equalsIgnoreCase("win")) {
                os = "win";
            } else if (choice.equals("2") || choice.equalsIgnoreCase("mac")) {
                os = "mac";
            } else if (choice.equals("3") || choice.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                os = choice;
            }
        }
        Application application = ApplicationConfigurer.configureApplication(os);
        application.paint();
        scanner.close();
    }
}
