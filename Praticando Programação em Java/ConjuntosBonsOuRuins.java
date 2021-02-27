/*
Desafio
Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. Por definição, um conjunto é bom quando 
nenhuma palavra desse conjunto é um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.

Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de dbcde. Quando duas palavras são idênticas, 
definimos como uma sendo prefixo da outra.

Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste terá um inteiro N (1 ≤ N ≤ 10⁵), que representa a 
quantidade de palavras no conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo 100 letras minúsculas. 
A entrada termina quando N = 0 e não deve ser processada.

Saída
Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto Ruim", conforme explicado acima.

+--------------------+----------------------+
| Exemplo de Entrada |     Exemplo de Saída |
+--------------------+----------------------+
| 3                  |     Conjunto Ruim    |
| abc                |     Conjunto Bom     |
| dae                |                      |
| abcde              |                      |
| 2                  |                      |
| abc                |                      |
| def                |                      |
| 0                  |                      |
+--------------------+----------------------+

*/

package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConjuntosBonsOuRuins {

	/**
	 *
	 * Solução por: Lucas Cerqueira Linkedin:
	 * https://www.linkedin.com/in/cerqueiralucas/
	 * 
	 * Qualquer dúvida sobre o raciocínio, me adicione!
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> listOfWords = new ArrayList<>();
		List<String> goodOrBadList = new ArrayList<String>();
		Integer howManyTests = 0;

		while (true) {

			String input = scanner.nextLine();

			if (input.equals("0")) {
				break;
			} else {
				howManyTests = Integer.valueOf(input);
			}

			for (int i = 0; i < howManyTests; i++) {
				listOfWords.add(scanner.nextLine());
			}

			outerloop: for (int i = 0; i < listOfWords.size(); i++) {
				for (int j = i + 1; j < listOfWords.size(); j++) {

					if (listOfWords.get(i).startsWith(listOfWords.get(j))
							|| listOfWords.get(i).equals(listOfWords.get(j))
							|| listOfWords.get(j).startsWith(listOfWords.get(i))) {
						goodOrBadList.add("Conjunto Ruim");
						break outerloop;
					}

				}

				if (i == listOfWords.size() - 1) {
					goodOrBadList.add("Conjunto Bom");
				}

			}

			listOfWords.clear();
		}
		
		scanner.close();

		for (String string : goodOrBadList) {
			System.out.println(string);
		}

	}

}
