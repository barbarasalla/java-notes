import java.util.*;
import java.util.stream.Collectors;

public class Java8_Streams_Collect {
    public static void main(String[] args) {

        /**
            * Fornecedor (Supplier): É a função que cria o objeto de resultado inicial, ou seja, o "recipiente" onde os dados serão acumulados.
            * () -> new ArrayList<>();

            * Acumulação (Accumulator): É a função que pega um elemento do stream e adiciona no recipiente criado pelo fornecedor.
            * (list, item) -> list.add(item) // Aqui o primeiro item é a lista que foi criada no fornecedor (new ArrayList<>()) e o segundo é cada elemento da lista que ta sendo pecorrida.

            * Combinação (Combiner): Serve para juntar dois recipientes parciais, especialmente quando o stream é processado em paralelo.
             * (list1, list2) -> {
             *     list1.addAll(list2);
             *     return list1;
             * }

            * list.stream().collect(supplier, accumulator, combiner);

         */

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        // list.stream().collect(supplier, accumulator, combiner);
        List<Integer> collect = list.stream()
                .collect(() -> new ArrayList<>(), (l, e) -> l.add(e),
                        (l1, l2) -> l1.addAll(l2));

        System.out.println(list);
        System.out.println(collect);

        // toList
        List<Integer> collect1 = list.stream()
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> collect2 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect2);

        // toSet
        Set<Integer> collect3 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(collect3);

        // toCollection (define a implementação da collection que deseja usar)
        Set<Integer> collect4 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));
        System.out.println(collect4);

        // joining
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());
        System.out.println(join);

        // averaging
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        // summing
        Integer summing = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(summing);

        // summarizing
        IntSummaryStatistics summarizing = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(summarizing.getAverage());
        System.out.println(summarizing.getCount());
        System.out.println(summarizing.getMax());
        System.out.println(summarizing.getMin());
        System.out.println(summarizing.getSum());

        // counting
        Long count = list.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        // max/min
        list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // groupingBy (Agrupa os elementos de acordo com a função lambda) / Ex.: Agrupar clientes por idade
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(groupingBy);

        // partitiongBy (Agrupa os elementos de acordo com a função lambda e sempre entre valores booleans) / Ex.: Separar clientes que atendam determinada condição em atende ou não atende
        Map<Boolean, List<Integer>> partitionBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 ==0));
        System.out.println(partitionBy);

        // toMap (Primeiro argumento define como vai encontrar a chave do valor e o segundo é de onde vai tirar o valor, no exemplo a chave é o próprio número e o valor é o número multiplicado por 2
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(toMap);

        Map<Integer, Double> toMap1 = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));
        System.out.println(toMap1);

    }
}