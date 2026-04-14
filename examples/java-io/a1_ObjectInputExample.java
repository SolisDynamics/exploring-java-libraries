package a3_java.io;  
import java.io.*;  
/**  
 * A comprehensive and advanced example showcasing the usage of java.io.DataInput and DataOutput.  
 * This program demonstrates reading and writing various data types to/from a binary file.  
 */  
public class a1_ObjectInputExample {  
    // Constants for filenames, buffer size and array sizes  
    private static final String FILE_NAME = "sample_data.bin";  
    private static final int BYTE_ARRAY_SIZE = 5;  
    private static final int FULL_DATA_SIZE = 10;  
    public static void main(String[] args) {  
        writeSampleData();  // Write sample data to the binary file  
        // Read and display sample data from the binary file 
        readSampleData();  }  
    /* Writes sample data of various types into a binary file using DataOutputStream.  */  
    private static void writeSampleData() {  
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {  
            // Writing various types of data to demonstrate DataOutputStream functionality  
            dos.writeBoolean(true);                  // Method A.1: writeBoolean()  
            dos.writeByte(127);                      // Method A.2: writeByte()  
            dos.writeChar('Z');                      // Method A.3: writeChar()  
            dos.writeDouble(3.141592653589793);     // Method A.4: writeDouble()  
            dos.writeFloat(2.71828f);                // Method A.5: writeFloat()  
            dos.writeInt(123456);                    // Method A.6: writeInt()  
            dos.writeLong(9223372036854775807L);    // Method A.7: writeLong()  
            dos.writeShort(32767);                   // Method A.8: writeShort()  
            dos.writeUTF("Sample String");           // Method A.11: writeUTF()  
            // Writing raw bytes for demonstration of reading fully  
            dos.write(new byte[]{10, 20, 30, 40, 50}); // Additional bytes for reading  
            dos.write(new byte[]{60, 70, 80, 90, 100});  
        } catch (IOException e) {  
            System.err.println("Error writing data: " + e.getMessage()); 
        } 
    }  
    /* Reads sample data from a binary file using DataInputStream and demonstrates various methods.  */  
    private static void readSampleData() {  
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {  
            // Reading data from the binary file and displaying each item  
            boolean booleanValue = dis.readBoolean(); // Method A.1: readBoolean()  
            displayData("Boolean Value", booleanValue);  
            byte byteValue = dis.readByte();           // Method A.2: readByte()  
            displayData("Byte Value", byteValue);  
            char charValue = dis.readChar();           // Method A.3: readChar()  
            displayData("Char Value", charValue);  
            double doubleValue = dis.readDouble();     // Method A.4: readDouble()  
            displayData("Double Value", doubleValue);  
            float floatValue = dis.readFloat();        // Method A.5: readFloat()  
            displayData("Float Value", floatValue);  
            int intValue = dis.readInt();              // Method A.6: readInt()  
            displayData("Int Value", intValue);  
            long longValue = dis.readLong();           // Method A.7: readLong()  
            displayData("Long Value", longValue);  
            short shortValue = dis.readShort();        // Method A.8: readShort()  
            displayData("Short Value", shortValue);  
            String utfString = dis.readUTF();          // Method A.11: readUTF()  
            displayData("UTF String", utfString);  
            // Reading additional byte arrays using readFully method  
            byte[] fullData = new byte[FULL_DATA_SIZE];  
            dis.readFully(fullData);                   // Method B.13: readFully(byte[] b)  
            displayArray("Fully Read Data", fullData);  
            // Partial read using readFully  
            byte[] partialData = new byte[BYTE_ARRAY_SIZE];  
            dis.readFully(partialData, 0, BYTE_ARRAY_SIZE); // Method B.14: readFully(byte[] b, int off, int len)  
            displayArray("Partially Read Data", partialData);  
            // Skip bytes  
            int skippedBytes = dis.skipBytes(3);      // Method C.15: skipBytes(int n)  
            System.out.println("Skipped Bytes: " + skippedBytes);  
        } catch (EOFException eof) {  
            System.out.println("End of file reached."); 
        } catch (IOException e) {  
            System.err.println("Error reading data: " + e.getMessage()); 
        } 
    }  
    /**  
     * Displays a data value with its label for better clarity.  
     * @param label The label description for the data  
     * @param value The value to display  
     */  
    private static void displayData(String label, Object value) {  
        System.out.println(label + ": " + value); }  
    /**  
     * Displays an array of bytes in a readable format.  
     * @param label The label description for the byte array  
     * @param array The array to display  
     */  
    private static void displayArray(String label, byte[] array) {  
        System.out.print(label + ": ");  
        for (byte b : array) {  
            System.out.print(b + " "); }  
        System.out.println(); 
    } 
}
