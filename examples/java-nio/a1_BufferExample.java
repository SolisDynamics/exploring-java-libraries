package a4_java.nio;

import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a1_BufferExample {

    private static final Logger LOGGER = Logger.getLogger(a1_BufferExample.class.getName());

    public static void main(String[] args) {
        BufferExplorer bufferExplorer = new BufferExplorer();
        
        // Use try-with-resources for proper executor management  
        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
            executor.submit(bufferExplorer::demonstrateByteBufferOperations);
            executor.submit(bufferExplorer::demonstrateCharBufferOperations);
            executor.submit(bufferExplorer::demonstrateIntBufferOperations);
            executor.submit(bufferExplorer::demonstrateAdvancedBufferTechniques);
            executor.submit(bufferExplorer::demonstrateBufferConversions);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Executor service error", e);
        }
    }
}

class BufferExplorer {

    private static final Logger LOGGER = Logger.getLogger(BufferExplorer.class.getName());
    private static final int DEFAULT_BUFFER_CAPACITY = 100;

    // Method 1-3: Capacity, Limit, and Position Management  
    public void demonstrateByteBufferOperations() {
        try {
            // Method 1: capacity() - Buffer capacity initialization  
            ByteBuffer buffer = ByteBuffer.allocate(DEFAULT_BUFFER_CAPACITY);
            LOGGER.info(() -> "1. Buffer Capacity: " + buffer.capacity());

            // Method 3: position() tracking  
            LOGGER.info(() -> "2. Initial Position: " + buffer.position());

            // Method 2: limit() management  
            LOGGER.info(() -> "3. Initial Limit: " + buffer.limit());

            // Method 9-10: Advanced Put Operations  
            buffer.put((byte) 42);
            buffer.put(5, (byte) 99);

            // Method 4: hasRemaining() check  
            LOGGER.info(() -> "4. Remaining Elements: " + buffer.remaining());

            // Method 6: flip() for reading  
            buffer.flip();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Byte buffer operation error", e);
        }
    }

    // Char Buffer Specialized Operations  
    public void demonstrateCharBufferOperations() {
        try {
            CharBuffer charBuffer = CharBuffer.allocate(50);
            // Method 11-12: Get Operations  
            charBuffer.put('A');
            charBuffer.put('B');
            charBuffer.put('C');
            charBuffer.flip();
            
            while (charBuffer.hasRemaining()) {
                LOGGER.info(() -> "Char Read: " + charBuffer.get());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Char buffer operation error", e);
        }
    }

    // Integer Buffer Advanced Techniques  
    public void demonstrateIntBufferOperations() {
        try {
            IntBuffer intBuffer = IntBuffer.allocate(30);
            // Method 14-15: Mark and Reset Demonstration  
            intBuffer.put(100);
            intBuffer.put(200);
            intBuffer.mark();
            intBuffer.put(300);
            intBuffer.reset();
            
            // Method 7-8: Clear and Rewind  
            intBuffer.clear();
            intBuffer.rewind();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Int buffer operation error", e);
        }
    }

    // Advanced Buffer Techniques  
    public void demonstrateAdvancedBufferTechniques() {
        try {
            ByteBuffer originalBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_CAPACITY);
            
            // Method 16-17: Direct and Read-Only Checks  
            LOGGER.info(() -> "5. Is Direct Buffer: " + originalBuffer.isDirect());
            LOGGER.info(() -> "6. Is Read-Only: " + originalBuffer.isReadOnly());
            
            // Method 18: Duplicate Buffer  
            // Demonstrate buffer duplication for comparison  
            ByteBuffer duplicatedBuffer = originalBuffer.duplicate();
            LOGGER.info(() -> "Duplicated Buffer Capacity: " + duplicatedBuffer.capacity());
            
            // Method 19-20: Slice Operations  
            // Demonstrate buffer slicing for comparison  
            ByteBuffer slicedBuffer = originalBuffer.slice();
            LOGGER.info(() -> "Sliced Buffer Capacity: " + slicedBuffer.capacity());
            
            // Demonstrate specific slice with visible usage  
            ByteBuffer specificSlice = originalBuffer.slice(10, 20);
            LOGGER.info(() -> "Specific Slice Buffer Capacity: " + specificSlice.capacity());
            
            // Method 21-23: Array Backing Techniques  
            if (originalBuffer.hasArray()) {
                byte[] backingArray = originalBuffer.array();
                int arrayOffset = originalBuffer.arrayOffset();
                LOGGER.info(() -> "7. Array Backing Details: " + "Offset=" + arrayOffset +
                        ", Length=" + backingArray.length);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Advanced buffer technique error", e);
        }
    }

    // Buffer Conversion and Transformation  
    public void demonstrateBufferConversions() {
        try {
            // Method 24-25: Dynamic Limit and Position  
            ByteBuffer dynamicBuffer = ByteBuffer.allocate(200);
            dynamicBuffer.limit(150);
            dynamicBuffer.position(50);
            
            // String to Buffer Conversion  
            String message = "Advanced NIO Buffer Techniques";
            ByteBuffer stringBuffer = ByteBuffer.wrap(
                    message.getBytes(StandardCharsets.UTF_8));
            
            // Complex Buffer Chaining  
            stringBuffer.clear()
                    .position(10)
                    .limit(message.length());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Buffer conversion error", e);
        }
    }

    // Thread-Safe Buffer Creation  
    public synchronized ByteBuffer createThreadSafeBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    // Error Handling Wrapper  
    public void safeBufferOperation(Runnable operation) {
        try {
            operation.run();
        } catch (ReadOnlyBufferException | IndexOutOfBoundsException e) {
            LOGGER.log(Level.SEVERE, "Buffer Operation Error", e);
        }
    }
}
