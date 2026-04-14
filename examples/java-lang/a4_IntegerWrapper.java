package a1_java.lang;
public class a4_IntegerExample {  
    public static void main(String[] args) {  
        // 1. Constructor Methods Demonstration  
        // Method 1: Integer(int value) - Creates Integer object from primitive int  
        @SuppressWarnings("removal")
		Integer numberFromPrimitive = new Integer(100);  
        System.out.println("Integer from Primitive: " + numberFromPrimitive);  
        // Method 2: Integer(String s) - Creates Integer object from String  
        @SuppressWarnings("removal")
		Integer numberFromString = new Integer("250");  
        System.out.println("Integer from String: " + numberFromString);  
        // 2. Constant Values Demonstration  
        System.out.println("Minimum Integer Value: " + Integer.MIN_VALUE);  
        System.out.println("Maximum Integer Value: " + Integer.MAX_VALUE);  
        System.out.println("Integer Size in Bits: " + Integer.SIZE);  
        System.out.println("Integer Bytes: " + Integer.BYTES);  
        System.out.println("Integer Type: " + Integer.TYPE);  
        // 3. Conversion Methods (A)  
        int originalNumber = 500;  
        if (originalNumber > 0) {  
            System.out.println("Original Number is positive: " + originalNumber); }  
        // Method 1-7: Various Conversion Methods  
        byte byteValue = numberFromPrimitive.byteValue();  
        double doubleValue = numberFromPrimitive.doubleValue();  
        float floatValue = numberFromPrimitive.floatValue();  
        int intValue = numberFromPrimitive.intValue();  
        long longValue = numberFromPrimitive.longValue();  
        short shortValue = numberFromPrimitive.shortValue();  
        String stringValue = numberFromPrimitive.toString();  
        System.out.println("Byte Value: " + byteValue);  
        System.out.println("Double Value: " + doubleValue);  
        System.out.println("Float Value: " + floatValue);  
        System.out.println("Int Value: " + intValue);  
        System.out.println("Long Value: " + longValue);  
        System.out.println("Short Value: " + shortValue);  
        System.out.println("String Value: " + stringValue);  
        // 4. Static Conversion Methods (B)  
        // Method 8-9: Parse Methods  
        int parsedNumber = Integer.parseInt("1000");  
        int parsedNumberWithRadix = Integer.parseInt("1010", 2); // Binary to decimal  
        // Method 10-11: Value Of Methods  
        Integer valueFromString = Integer.valueOf("750");  
        Integer valueFromInt = Integer.valueOf(750);  
        if (valueFromString.intValue() > 0 && valueFromInt.intValue() > 0) {  
            System.out.println("Value From String: " + valueFromString);  
            System.out.println("Value From Int: " + valueFromInt); }  
        // Method 12-15: String Representation Methods  
        String decimalString = Integer.toString(1000);  
        String hexString = Integer.toHexString(255);  
        String octalString = Integer.toOctalString(64);  
        String binaryString = Integer.toBinaryString(10);  
        System.out.println("Parsed Number: " + parsedNumber);  
        System.out.println("Parsed Binary Number: " + parsedNumberWithRadix);  
        System.out.println("Decimal String: " + decimalString);  
        System.out.println("Hex String: " + hexString);  
        System.out.println("Octal String: " + octalString);  
        System.out.println("Binary String: " + binaryString);  
        // 5. Comparison Methods (C)  
        // Method 16-19: Comparison Methods  
        Integer num1 = 100;  
        Integer num2 = 200;  
        int comparisonResult = num1.compareTo(num2);  
        int staticComparisonResult = Integer.compare(100, 200);  
        boolean equalityCheck = num1.equals(100);  
        int hashCodeValue = num1.hashCode();  
        System.out.println("Comparison Result: " + comparisonResult);  
        System.out.println("Static Comparison Result: " + staticComparisonResult);  
        System.out.println("Equality Check: " + equalityCheck);  
        System.out.println("Hash Code: " + hashCodeValue);  
        // 6. Bit Manipulation Methods (D)  
        // Method 20-26: Bit Manipulation  
        int manipulationNumber = 15; // Binary: 1111  
        int bitCount = Integer.bitCount(manipulationNumber);  
        int highestOneBit = Integer.highestOneBit(manipulationNumber);  
        int lowestOneBit = Integer.lowestOneBit(manipulationNumber);  
        int leadingZeros = Integer.numberOfLeadingZeros(manipulationNumber);  
        int trailingZeros = Integer.numberOfTrailingZeros(manipulationNumber);  
        int reversedBits = Integer.reverse(manipulationNumber);  
        int reversedBytes = Integer.reverseBytes(manipulationNumber);  
        System.out.println("Bit Count: " + bitCount);  
        System.out.println("Highest One Bit: " + highestOneBit);  
        System.out.println("Lowest One Bit: " + lowestOneBit);  
        System.out.println("Leading Zeros: " + leadingZeros);  
        System.out.println("Trailing Zeros: " + trailingZeros);  
        System.out.println("Reversed Bits: " + reversedBits);  
        System.out.println("Reversed Bytes: " + reversedBytes);  
        // 7. Utility Methods (E)  
        // Method 27-29: Utility Methods  
        int signumPositive = Integer.signum(250);  
        int rotatedLeft = Integer.rotateLeft(10, 2);  
        int rotatedRight = Integer.rotateRight(10, 2);  
        System.out.println("Signum (Positive): " + signumPositive);  
        System.out.println("Rotated Left: " + rotatedLeft);  
        System.out.println("Rotated Right: " + rotatedRight); } }
