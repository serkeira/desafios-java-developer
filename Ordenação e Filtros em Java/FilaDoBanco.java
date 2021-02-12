/*
//### Desafio - Fila do Banco
O banco que você trabalha sempre tem problemas para organizar as filas de atendimento dos clientes.
Após uma reunião com a gerência ficou decidido que os clientes ao chegar na agência receberão uma senha numérica em seu aparelho de celular via sms e que a ordem da fila será dada não pela ordem de chegada, mas sim pelo número recebido via sms.
Sendo, aqueles com número maior deverão ser atendidos primeiro.
Então, dada a ordem de chegada dos clientes reordene a fila de acordo com o número recebido via sms, e diga quantos clientes não precisaram trocar de lugar nessa reordenação.

//### Entrada
A primeira linha contém um inteiro N, indicando o número de casos de teste a seguir.
Cada caso de teste inicia com um inteiro M (1 ≤ M ≤ 1000), indicando o número de clientes.
Em seguida haverá M inteiros distintos Pi (1 ≤ Pi ≤ 1000), onde o i-ésimo inteiro indica o número recebido via sms do i-ésimo cliente.
Os inteiros acima são dados em ordem de chegada, ou seja, o primeiro inteiro diz respeito ao primeiro cliente a chegar na fila, o segundo inteiro diz respeito ao segundo cliente, e assim sucessivamente.

//### Saída
Para cada caso de teste imprima uma linha, contendo um inteiro, indicando o número de clientes que não precisaram trocar de lugar mesmo após a fila ser reordenada.
|---------------------------------------|
| Exemplo de Entrada | Exemplo de Saída |
|--------------------|------------------|
| 3                  | 1                |
| 3                  | 0                |
| 100 80 90          | 4                |
| 4                  |                  |
| 100 120 30 50      |                  |
| 4                  |                  |
| 100 90 30 25       |                  |
|---------------------------------------|
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FilaDoBanco {

    /**
     *
     * Solução por: Lucas Cerqueira - Linkedin:
     * https://www.linkedin.com/in/cerqueiralucas/
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer howManyTests = sc.nextInt();
        sc.nextLine();

        Integer customersAmount;
        String sms;
        String[] splitSms;

        List<String> customersList = new ArrayList<>();
        List<Integer> reorderedList = new ArrayList<>();

        List<Integer> finalListOfChanges = new ArrayList<>();

        Integer maintainedPositions;

        for (int i = 0; i < howManyTests; i++) {

            customersAmount = sc.nextInt();
            sc.nextLine();

            sms = sc.nextLine();
            splitSms = sms.split(" ");

            for (int j = 0; j < splitSms.length; j++) {
                customersList.add(splitSms[j]);
            }

            for (String customer : customersList) {
                reorderedList.add(Integer.parseInt(customer));
            }

            Collections.sort(reorderedList, Collections.reverseOrder());

        
            maintainedPositions = 0;

            for (int count = 0; count < reorderedList.size(); count++) {
                if (reorderedList.get(count) == Integer.parseInt(customersList.get(count))) {
                    maintainedPositions++;
                }

            }

            finalListOfChanges.add(maintainedPositions);

            customersList.clear();
            reorderedList.clear();

        }

        sc.close();

        for (Integer changes : finalListOfChanges) {
            System.out.println(changes);
        }

    }
}
