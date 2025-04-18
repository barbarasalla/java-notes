import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        //Collection
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().forEach(System.out::println);

        // Arrays
        Integer[] intArray = new Integer[]{1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::println);

        //Stream.of
        Stream.of("criando", "um", "Stream", "de", "Strings");
        Stream.of("criando", "um", "Stream", "de", "Strings").forEach(System.out::println);
        Stream<String> stringStream = Stream.of("criando", "um", "Stream", "de", "Strings");

        //Stram.range
        IntStream.range(0, 5).forEach(System.out::println);

        //Stream.iterate
        Stream.iterate(5, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);

        // BufferedReader
        File file = new File("stream-util/resources/streams.txt");
        FileReader in = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(in);
        bufferedReader.lines().forEach(System.out::println);

        // Files
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        //Random
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);

        //Pattern
        String s = "Stream no pattern";
        Pattern pa = Pattern.compile(" ");
        pa.splitAsStream(s).forEach(System.out::println);

    }
}