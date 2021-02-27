/*Desafio
Neste desafio sua tarefa será ler vários números e em seguida dizer quantas vezes cada número aparece, ou seja, 
deve-se escrever cada um dos valores distintos que aparecem na entrada por ordem crescente de valor.

Entrada
A primeira linha de entrada contem um único inteiro N, que indica a quantidade de valores que serão lidos para X (1 ≤ N ≤ 2000) logo em seguida. 
Com certeza cada número não aparecerá mais do que 20 vezes na entrada de dados.

Saída
Imprima a saída de acordo com o exemplo fornecido abaixo, indicando quantas vezes cada um deles aparece na entrada por ordem crescente de valor.
 
+--------------------+-------------------------+
| Exemplo de Entrada |      Exemplo de Saída   |
+--------------------+-------------------------+
|                  7 |    4 aparece 1 vez(es)  |
|                  8 |    8 aparece 2 vez(es)  |
|                 10 |    10 aparece 3 vez(es) |
|                  8 |   260 aparece 1 vez(es) |
|                260 |                         |
|                  4 |                         |
|                 10 |                         |
|                 10 |                         |
+--------------------+-------------------------+

*/

package testes;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContagemRepetida {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		ArrayList<Integer> listVariables = new ArrayList<Integer>();

		int n = sc.nextInt();
		while (n-- > 0)
			listVariables.add(sc.nextInt());

		SortedMap<Integer, Integer> mapOfValues = new TreeMap<>();
		listVariables.forEach(id -> mapOfValues.compute(id, (k, v) -> (v == null ? 1 : v + 1)));

		mapOfValues.entrySet().forEach(entry -> {
			System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
		});

		sc.close();
	}
}