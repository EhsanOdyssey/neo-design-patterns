package neo.ehsanodyssey.patterns.builder;

import neo.ehsanodyssey.patterns.builder.builders.CarBuilder;
import neo.ehsanodyssey.patterns.builder.builders.CarManualBuilder;
import neo.ehsanodyssey.patterns.builder.cars.Car;
import neo.ehsanodyssey.patterns.builder.cars.Manual;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Sun 21 Nov 2021
 */
public class DemoBuilder {

    /**
     * Builder is a creational design pattern that lets you construct complex objects' step by step.
     * The pattern allows you to produce different types and representations of an object using the same construction code.
     */

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
