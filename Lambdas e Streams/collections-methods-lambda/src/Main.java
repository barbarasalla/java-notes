import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //List
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        list.forEach(n -> System.out.println(n));

        list.removeIf(n -> n % 2 == 0);
        list.forEach(n -> System.out.println(n));

        list.replaceAll(n -> n * 2);
        list.forEach(n -> System.out.println(n));

        //Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "list");
        map.put(1, "string");
        map.forEach((k, v) -> System.out.println(k + v));

        map.compute(1, (k, v) -> v + " agora");
        map.forEach((k, v) -> System.out.println(k + v));

        map.merge(2, "!", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + v));

        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));

    }
}