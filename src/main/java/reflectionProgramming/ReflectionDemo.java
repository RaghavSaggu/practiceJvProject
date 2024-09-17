package reflectionProgramming;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String... args) {
        try {
            Class clazz = Class.forName("java.lang.String");
            showAllConstructorsOfClazz(clazz);
            System.out.println("================================================================================================================================================================================");
            showAllMethodsOfClazz(clazz);
            System.out.println("================================================================================================================================================================================");
            showAllDeclaredClassesInClazz(clazz);
            System.out.println("================================================================================================================================================================================");
            showAllAnnotationOfClazz(clazz);
            System.out.println("================================================================================================================================================================================");

        } catch (ClassNotFoundException e) {
            System.out.println("The class you looking for is not available");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showAllConstructorsOfClazz(Class<?> clazz) {
        // Constructor array
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Total constructors: " + constructors.length);
        System.out.println();

        for (Constructor constructor : constructors) {
            System.out.println("Name of Constructor : " + constructor);
            System.out.println("Count of constructor parameter : " + constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter : " + parameter);
            }
            System.out.println();
        }
    }

    private static void showAllMethodsOfClazz(Class<?> clazz) {
        // Method Array
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Total methods: " + methods.length);
        System.out.println();

        for (Method method : methods) {
            System.out.println("Method name: \t" + method);
            System.out.println("Method return type : \t" + method.getReturnType());
            System.out.println("Method parameter count: \t" + method.getParameterCount());
            System.out.println("-------------------------------------------------");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method's Parameter : " + parameter);
            }
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
    }

    private static void showAllDeclaredClassesInClazz(Class<?> clazz) {
        // Declared classes
        Class[] classes = clazz.getDeclaredClasses();
        for (Class class1 : classes) {
            System.out.println("class: " + class1);
            System.out.println("Name of class: " + class1.getName());
            System.out.println();
        }
    }

    private static void showAllAnnotationOfClazz(Class<?> clazz) {
        // Annotations
        Annotation[] anno = clazz.getDeclaredAnnotations();
        for (Annotation annotation : anno) {
            System.out.println("Annotation: " + annotation);
            System.out.println();
        }
    }
}
