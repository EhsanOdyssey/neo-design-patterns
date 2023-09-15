package neo.ehsanodyssey.patterns.singleton.other;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class TestSingletons {
    /**
     * 1. Eager initialization
     * 2. Static block initialization
     * 3. Lazy Initialization
     * 4. Thread Safe Singleton
     * 5. Bill Pugh Singleton Implementation
     * <p>
     * ** Reflection can be used to destroy all the above singleton implementation approaches.
     */
    public static void reflectionSingletonTest() {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    /**
     * To overcome this situation with Reflection, Joshua Bloch suggests the use of Enum to implement Singleton
     * 7. Enum Singleton
     * <p>
     * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that
     * we can store its state in the file system and retrieve it at a later point of time.
     * 8. Serialization and Singleton
     * <p>
     * ** The problem with serialized singleton class is that whenever we deserialize it, it will create
     * a new instance of the class.
     */
    public static void serializedSingletonTest() throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

    }

    /**
     * So it destroys the singleton pattern, to overcome this scenario all we need to do
     * it provide the implementation of readResolve() method.
     * protected Object readResolve() {
     *     return getInstance();
     * }
     */
    public static void serializedSingletonResolvedTest() throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingletonResolved instanceOne = SerializedSingletonResolved.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingletonResolved instanceTwo = (SerializedSingletonResolved) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("---- Reflection Singleton Test ----");
        reflectionSingletonTest();
        System.out.println("---- Singleton Serialized Test ----");
        serializedSingletonTest();
        System.out.println("---- Singleton Serialized Resolved Test ----");
        serializedSingletonResolvedTest();
    }
}
