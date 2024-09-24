package logical;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonExample {
    public static void main(String[] args) {
        try {
            Singleton originalSingletonInstance = Singleton.getInstance("For Raghav");
            System.out.println("Hashcode of originalSingletonInstance is: " + originalSingletonInstance.hashCode());
            SingletonExample runner = new SingletonExample();
            runner.showSingletonWorkingHappily(originalSingletonInstance);
            runner.breakTheSingletonClassUsingCloning(originalSingletonInstance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showSingletonWorkingHappily(Singleton originalSingletonInstance) {
        System.out.println("======================================================================================================================");
        Singleton duplicateSingletonInstance = Singleton.getInstance("For Raghav");
        System.out.println("Hashcode of originalSingletonInstance was: " + originalSingletonInstance.hashCode());
        System.out.println("Hashcode of duplicateSingletonInstance is: " + duplicateSingletonInstance.hashCode());
        System.out.println("======================================================================================================================");
    }

    private void breakTheSingletonClassUsingReflection(Singleton originalSingletonInstance) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // let break the singleton class using reflection
        System.out.println("======================================================================================================================");
        Class<?> clazz = Class.forName("logical.Singleton");
        Constructor<Singleton> constructor = (Constructor<Singleton>) clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton brokenSingletonInstance = constructor.newInstance();
        System.out.println("Hashcode of originalSingletonInstance was: " + originalSingletonInstance.hashCode());
        System.out.println("Hashcode of brokenSingletonInstance is: " + brokenSingletonInstance.hashCode());
        System.out.println("======================================================================================================================");
    }

    private void breakTheSingletonClassUsingDeserialization(Singleton originalSingletonInstance) throws IOException, ClassNotFoundException {
        System.out.println("======================================================================================================================");
        // let break the singleton class using Serialization
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(".\\files\\serializationInSingleton.ser"));
        outputStream.writeObject(originalSingletonInstance);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\files\\serializationInSingleton.ser"));
        Singleton brokenSingletonInstanceUsingSerialization = (Singleton) inputStream.readObject();
        inputStream.close();
        System.out.println("Hashcode of originalSingletonInstance was: " + originalSingletonInstance.hashCode());
        System.out.println("Hashcode of brokenSingletonInstanceUsingSerialization is: " + brokenSingletonInstanceUsingSerialization.hashCode());
        System.out.println("======================================================================================================================");
    }

    private void breakTheSingletonClassUsingCloning(Singleton originalSingletonInstance) throws CloneNotSupportedException {
        System.out.println("======================================================================================================================");
        // let break the singleton class using Cloneable
        Singleton brokenSingletonInstanceUsingClone = originalSingletonInstance.clone();
        System.out.println("Hashcode of originalSingletonInstance was: " + originalSingletonInstance.hashCode());
        System.out.println("Hashcode of brokenSingletonInstanceUsingClone is: " + brokenSingletonInstanceUsingClone.hashCode());
        System.out.println("======================================================================================================================");
    }
}

class Singleton implements Serializable, Cloneable {
    private static Singleton instance;

    private String value;

    private Singleton() {}
    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if(instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

    @Override
    public Singleton clone() throws CloneNotSupportedException {
        return (Singleton) super.clone();
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "value='" + value + '\'' +
                '}';
    }
}
