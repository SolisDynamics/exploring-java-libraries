package a1_java.lang;

import java.lang.reflect.*;
import java.security.ProtectionDomain;
import java.io.Serializable;

public class a2_ClassExample {

    // Custom class for demonstration  
    public static class ExampleClass implements Serializable {
        private static final long serialVersionUID = 1L;
        private int privateField;
        public String publicField;

        // Parameterless Constructor  
        public ExampleClass() {
            this.privateField = 0;
        }

        // Public constructor  
        public ExampleClass(int value) {
            this.privateField = value;
        }

        // Public method  
        public void publicMethod() {
            System.out.println("Public method called");
        }

        // Getter for privateField to use the field  
        public int getPrivateField() {
            return privateField;
        }
    }

    public static void main(String[] args) {
        try {
            // Method A: Class Information Retrieval Methods  
            Class<?> exampleClass = ExampleClass.class;

            // A1. getName(): Fully qualified class name  
            System.out.println("1. Full Class Name: " + exampleClass.getName());

            // A2. getSimpleName(): Simple class name without package  
            System.out.println("2. Simple Class Name: " + exampleClass.getSimpleName());

            // A3. getCanonicalName(): Canonical class name  
            System.out.println("3. Canonical Name: " + exampleClass.getCanonicalName());

            // A4. getTypeName(): Type name of the class  
            System.out.println("4. Type Name: " + exampleClass.getTypeName());

            // A5. toString(): String representation of the class  
            System.out.println("5. Class toString(): " + exampleClass.toString());

            // Method B: Object Creation Methods  
            // B6. Create new instance and demonstrate its use  
            ExampleClass instance = (ExampleClass) exampleClass
                    .getConstructor(int.class)
                    .newInstance(42);
            System.out.println("B6. Created Instance Private Field Value: " + instance.getPrivateField());

            // B7. forName(): Dynamic class loading and demonstrate its use  
            Class<?> dynamicClass = Class.forName("a1_java.lang.a2_ClassExample$ExampleClass");
            System.out.println("B7. Dynamic Class Name: " + dynamicClass.getSimpleName());

            // B8. getConstructor(): Get public constructor and demonstrate its use  
            Constructor<?> publicConstructor = exampleClass.getConstructor(int.class);
            System.out.println("B8. Public Constructor: " + publicConstructor);

            // B9. getDeclaredConstructor(): Get any constructor  
            Constructor<?> privateConstructor = exampleClass.getDeclaredConstructor();
            privateConstructor.setAccessible(true);
            Object privateInstance = privateConstructor.newInstance();
            System.out.println("B9. Private Constructor Instance: " + privateInstance);

            // Method C: Member Information Retrieval Methods - C10. getMethods(): Get public methods  
            System.out.println("\nPublic Methods:");
            for (Method method : exampleClass.getMethods()) {
                System.out.println("C10. Public Method: " + method.getName());
            }

            // C11. getDeclaredMethods(): Get all methods  
            System.out.println("\nAll Declared Methods:");
            for (Method method : exampleClass.getDeclaredMethods()) {
                System.out.println("C11. Declared Method: " + method.getName());
            }

            // Method D: Class Characteristic Check Methods  
            // D16. isInterface()  
            System.out.println("D16. Is Interface: " + exampleClass.isInterface());

            // D17. isEnum()  
            System.out.println("D17. Is Enum: " + exampleClass.isEnum());

            // D18. isArray()  
            System.out.println("D18. Is Array: " + exampleClass.isArray());

            // Method E: Inheritance and Package Information Methods  
            // E24. getSuperclass()  
            System.out.println("E24. Superclass: " + exampleClass.getSuperclass());

            // E25. getPackage()  
            System.out.println("E25. Package: " + exampleClass.getPackage());

            // Method F: Access and Security Methods  
            // F28. getModifiers()  
            int modifiers = exampleClass.getModifiers();
            System.out.println("F28. Modifiers: " + Modifier.toString(modifiers));

            // F29. getProtectionDomain()  
            ProtectionDomain protectionDomain = exampleClass.getProtectionDomain();
            System.out.println("F29. Protection Domain: " + protectionDomain);

            // F30. getClassLoader()  
            ClassLoader classLoader = exampleClass.getClassLoader();
            System.out.println("F30. ClassLoader: " + classLoader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
