package a1_java.lang;

import java.io.*;
import java.util.Map;

public class b11_RuntimeExample {

    @SuppressWarnings({"removal", "deprecation"})
    public static void main(String[] args) {
        // Method 1: Get Runtime Instance  
        // This method returns the current runtime object, allowing access to JVM runtime methods  
        Runtime runtime = Runtime.getRuntime();
        System.out.println("1. Runtime Instance obtained successfully.");

        // Method 2 & 3: Memory Management Methods  
        // These methods provide information about JVM memory usage  
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        System.out.println("2. Total Memory: " + totalMemory + " bytes");
        System.out.println("3. Free Memory: " + freeMemory + " bytes");

        // Method 4: Garbage Collection  
        // Suggests the JVM to run garbage collection process  
        runtime.gc();
        System.out.println("4. Garbage Collection suggested.");

        // Method 5: Run Finalization  
        // Suggests running pending finalizer methods  
        runtime.runFinalization();
        System.out.println("5. Finalization process suggested.");

        // Method 7 & 8 & 9: Execute External Processes  
        try {
            // Execute a simple command and read its output  
            Process process1 = runtime.exec("echo Hello, Runtime!");
            String output1 = readProcessOutput(process1);
            System.out.println("7. Simple command execution result: " + output1);

            // Execute a command array and read its output  
            String[] cmdArray = {"cmd", "/c", "dir"};
            Process process2 = runtime.exec(cmdArray);
            String output2 = readProcessOutput(process2);
            System.out.println("8. Command array execution result length: " + output2.length());

            // Execute command with environment variables and read its output  
            String[] envp = {"PATH=" + System.getenv("PATH")};
            Process process3 = runtime.exec("echo %PATH%", envp);
            String output3 = readProcessOutput(process3);
            System.out.println("9. Command with environment variables execution result: " + output3);
        } catch (IOException e) {
            System.err.println("Error executing processes: " + e.getMessage());
        }

        // Method 10: Add Shutdown Hook  
        // Registers a thread to be executed when JVM is shutting down  
        Thread shutdownHook = new Thread(() -> {
            System.out.println("10. Shutdown hook executed: Performing cleanup.");
        });
        runtime.addShutdownHook(shutdownHook);

        // Method 11: Remove Shutdown Hook (demonstration)  
        boolean hookRemoved = runtime.removeShutdownHook(shutdownHook);
        System.out.println("11. Shutdown hook removal status: " + hookRemoved);

        // Method 12: Get Environment Variables  
        // Retrieves all environment variables  
        Map<String, String> environmentVariables = System.getenv();
        System.out.println("12. Environment Variables:");
        environmentVariables.forEach((key, value) ->
                System.out.println(key + " = " + value));

        // Method 13: toString Representation  
        // Returns a string representation of the Runtime object  
        String runtimeString = runtime.toString();
        System.out.println("13. Runtime toString: " + runtimeString);

        // Method 14: Available Processors  
        // Returns the number of processors available to the JVM  
        int processors = runtime.availableProcessors();
        System.out.println("14. Available Processors: " + processors);
    }

    // Utility method to read output from a Process  
    private static String readProcessOutput(Process process) throws IOException {
        // Read the output of the process  
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString().trim();
        }
    }
}
