import java.util.ArrayList;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        List<String> libraries = new ArrayList<>();
        libraries.add("java.lang");
        libraries.add("java.util");
        libraries.add("java.io");

        for (String library : libraries) {
            System.out.println(library);
        }
    }
}
