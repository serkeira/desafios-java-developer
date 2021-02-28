/*
Desafio
Encontre a maior substring comum entre as duas strings informadas. A substring pode ser qualquer parte da string, inclusive ela toda. 
Se não houver subseqüência comum, a saída deve ser “0”. A comparação é case sensitive ('x' != 'X').

Entrada
A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas, cada uma contendo uma string. Ambas strings de 
entrada contém entre 1 e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma letra ('A'-'Z','a'-'z').

Saída
O tamanho da maior subsequência comum entre as duas Strings.

+------------------------+----------------------+
|   Exemplo de Entrada   |     Exemplo de Saída |
+------------------------+----------------------+
| abcdef                 |                    2 |
| cdofhij                |                    1 |
| TWO                    |                    0 |
| FOUR                   |                    7 |
| abracadabra            |                      |
| open                   |                      |
| Hey This java is hot   |                      |
| Java is a new paradigm |                      |
+------------------------+----------------------+

*/

package testes;

import java.util.Scanner;

public class MaiorSubstring {

	/**
	 *
	 * Solução por: Lucas Cerqueira Linkedin:
	 * https://www.linkedin.com/in/cerqueiralucas/
	 * 
	 * Qualquer dúvida sobre o raciocínio, me adicione!
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			String input1 = scanner.nextLine();
			String input2 = scanner.nextLine();

			int longest = findLongestSusbstring(input1, input2);
			System.out.println(longest);
		}
		scanner.close();

	}

	private static int findLongestSusbstring(String input1, String input2) {
		char[] cols = input1.toCharArray();
		char[] rows = input2.toCharArray();
		int row = rows.length;
		int col = cols.length;
		int max = 0;
		if (row == 0 || col == 0)
			return 0;
		int[][] temp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (cols[j] == rows[i]) {
					if (i > 0 && j > 0) {
						temp[i][j] = temp[i - 1][j - 1] + 1;
					} else {
						temp[i][j] = 1;

					}
					if (temp[i][j] > max)
						max = temp[i][j];
				}
			}
		}
		return max;

	}

}
