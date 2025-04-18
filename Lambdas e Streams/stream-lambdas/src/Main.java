import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        IntStream.generate(() -> new Random().nextInt()) // Supplier: Não recebe nenhum argumento por parametro, apenas retorna um valor.
                .limit(5)
                .forEach((e) -> System.out.println(e)); // Consumer: Recebe valor por parametro, mas não retorna nada.

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .filter(e -> e % 2 == 0) // Predicate ou BiPredicate: Recebe um valor e retorna um booleano.
                .map(e -> e.doubleValue()) // Function ou BiFunction: Recebe um valor e retorna novo valor que pode ser de OUTRO tipo.
                .reduce((e1, e2) -> e1 + e2) // UnaryOperator ou BinaryOperator: Recebe um valor e retorna novo valor do MESMO tipo.
                .ifPresent(System.out::println);

    }
}