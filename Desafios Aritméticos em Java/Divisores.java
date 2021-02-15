/*
Pense um número positivo n. Agora me diga um divisor A de n. 
Agora me dê um outro número B que não seja divisor de n. 
Agora um múltiplo C. E um não múltiplo D. O número que você pensou é...

Parece um truque de mágica, mas é matemática! 
Será que, conhecendo os números A, B, C e D, você consegue descobrir qual era o número original n? 
Note que pode existir mais de uma solução!

Neste problema, dados os valores de A, B, C e D, você deve escrever um programa que determine qual o 
menor número n que pode ter sido pensado ou concluir que não existe um valor possível.

## Entrada ##
A entrada consiste de uma única linha que contém quatro números inteiros A, B, C, e D, como descrito acima 
(1 ≤ A, B, C, D ≤ 10^9).

## Saída ##
Seu programa deve produzir uma única linha. Caso exista pelo menos um número n para os quais A, B, C e D 
façam sentido, a linha deve conter o menor n possível. Caso contrário, a linha deve conter -1.

|---------------------------------------|
| Exemplo de Entrada | Exemplo de Saída |
|--------------------|------------------|
| 2 12 8 2           | 4                |
| 3 4 60 105         | 6                |
|                    |                  |
|---------------------------------------|

 */
package testes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Divisores {

	/**
	 *
	 * Solução por: Lucas Cerqueira - Linkedin:
	 * https://www.linkedin.com/in/cerqueiralucas/
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Integer finalNumber = -1;

		String input = scanner.nextLine();

		scanner.close();

		String[] splitIntoFourNumbers = input.split(" ");
		Integer valueA = Integer.parseInt(splitIntoFourNumbers[0]);
		Integer valueB = Integer.parseInt(splitIntoFourNumbers[1]);
		Integer valueC = Integer.parseInt(splitIntoFourNumbers[2]);
		Integer valueD = Integer.parseInt(splitIntoFourNumbers[3]);

		Integer end = valueC;

		Set<Integer> finalSet = new HashSet<>();

		// para evitar timeout com números muito grandes
		IntStream stream = IntStream.range(valueA, end + 1);
		stream = stream.filter(element -> valueC % element == 0);
		IntStream filteredStream = stream.filter(element -> element % valueA == 0);

		filteredStream.parallel().forEach(element -> {
			if (checkIfAllConditionsMatch(element, valueA, valueB, valueC, valueD) != -1) {
				finalSet.add(element);
			}

		});

		if (finalSet.isEmpty()) {
			finalNumber = -1;
		} else {
			finalNumber = Collections.min(finalSet);
		}

		System.out.println(finalNumber);

	}

	public static Integer checkIfAllConditionsMatch(Integer start, Integer valueA, Integer valueB, Integer valueC,
			Integer valueD) {

		if ((start % valueA == 0) && (start % valueB != 0) && (valueC % start == 0) && (valueD % start != 0)) {

			return start;

		} else {

			return -1;
		}

	}

}
