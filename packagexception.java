package mypackage;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello from MyClass in mypackage!");
    }
}

''''''''''''''''''''''''''''''''''''''''''''

package mypackage.subpackage;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello from MyClass in mypackage.subpackage!");
    }
}

''''''''''''''''''''''''''''''''''''''''''''

public class BuiltInExceptions {
    public static void main(String[] args) {
        // ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            int value = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }

        // NullPointerException
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}

Caught ArithmeticException: / by zero
Caught ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
Caught NumberFormatException: For input string: "abc"
Caught NullPointerException: Cannot invoke "String.length()" because "str" is null

''''''''''''''''''''''''''''''''''''''''''''''''''

public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            int result = 10 / 0;        // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}

Array Index Out of Bounds: Index 5 out of bounds for length 3
Execution completed.


''''''''''''''''''''''''''''''''''''''''''''''''''

// User-defined exception class
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            int number = 5;

            // Trigger the user-defined exception
            if (number < 10) {
                throw new MyException("Number is less than 10!");
            }

            System.out.println("Number is valid: " + number);
        } catch (MyException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

Caught Exception: Number is less than 10!

