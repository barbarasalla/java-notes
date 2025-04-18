import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4);

        /** parallel vs parallelStream
            list.parallelStream()
            IntStream.range(0, 5).parallel()
         */

        // forEach x forEachOrdered
        list.parallelStream()
                .forEach(System.out::println);
        list.parallelStream()
                .forEachOrdered(System.out::println);

        // findAny (Encontrar o primeiro elemento e imprimir, no paralelo ele pode encontrar primeiro qualquer elemento, não necessariamente o primeiro.
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        // unordered (Garante mais segurança entre as threads para que consigam processar os comandos (skip, limit e distinct) e respeitar as regras sem confundir as threads ou gerar qualquer problema)
        list.parallelStream()
                .unordered()
                .skip(1)
                .limit(2)
                .distinct()
                .forEach(System.out::println);

        // Reduce ( Só utilizar se for associativa com parallelStream
        list.parallelStream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);


        // Collect
            // toMap (Para utilizar o toMap com paralelismo deve usar o toConcurrentMap no lugar do toMap, pois com ele as diversas threads podem acessar o mesmo map sem necessidade de criar um para cada uma delas e depois somar
            Map<Integer, Boolean> collect = list.parallelStream()
                    .collect(
                            Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0)
                    );
            System.out.println(collect);

            // groupingBy
            Map<Boolean, List<Integer>> collect2 =
                    list.parallelStream().collect(
                            Collectors.groupingByConcurrent( n -> n % 2 == 0)
                    );
            System.out.println(collect2);

    }
}