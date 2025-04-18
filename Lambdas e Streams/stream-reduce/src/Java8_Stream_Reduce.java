import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8_Stream_Reduce {
    public static void main(String[] args) {

        /** REDUCE: Aplicar uma função acumuladora a uma sequência de valores, combinando-os em um único resultado final. (TRABALHA COM VALORES IMUTAVEIS) */

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        String s = "Java 8 Streams Reduce";
        String[] split = s.split(" ");
        List<String> listString = Arrays.asList(split);

        /**
         * Função Associativa: Uma operação é associativa se a ordem de agrupamento dos operandos não altera o resultado.
         * Função Acumuladora: É a função que recebe dois argumentos e devolve um novo acumulado.
         */

        // SOMAR
        // Pega dois valores da lista (n1, n2), soma, e o resultado volta como o novo n1 no próximo ciclo. Isso vai acontecendo até sobrar um único valor.
        Optional<Integer> soma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        // MULTIPLICAR
        Optional<Integer> multiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplicacao.get());

        // CONCATENAÇÃO
        Optional<String> concatena = listString.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatena.get());

        /** VALOR DE IDENTIDADE: É o valor neutro da operação, aquele que não altera o resultado quando usado com o acumulador. */

        // SOMA
        Integer soma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);

        // MULTIPLICAR
        Integer multiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2);

        // CONCATENAÇÃO
        String concatena2 = listString.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concatena2);

        /**
         * Função Combinadora: Usada na versão de reduce com parallelStream() ou no metodo de collect(), serve para combinar parciais.
         * O Reduce utiliza a combinação quando precisa quebrar o stream em vários grupos. Ele aplica a função de acumulação no primeiro argumento e depois realiza a combinação.
         */

        // SOMAR
        Integer soma3 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma3);

        // reduce - combinação
        String reduce = list.stream()
                .reduce("",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(reduce);

    }
}