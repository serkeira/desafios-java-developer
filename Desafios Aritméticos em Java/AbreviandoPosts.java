/*Desafio
Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das cidades por onde passa. 
Recentemente, resolveu criar um blog, para compartilhar suas experiências e aprendizados com seus amigos.

Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite de caracteres que se pode escrever por dia, 
e Leonardo está preocupado que essa limitação, afinal, irá impedir de contar suas melhores experiências. Para contornar esse problema, 
decidiu usar um sistema de abreviação de palavras em seus posts.

O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível escolher uma palavra que inicia com tal 
letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua letra inicial 
e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei” para representar a letra ‘p', e a frase 
ficará assim: “hoje eu p. em Python”, economizando assim sete caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto, e 
será abreviada todas as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como 
no caso da palavra “eu” acima.

Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda. Para cada letra, escolha uma 
palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

Entrada
Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴ caracteres. A frase é 
composta de palavras e espaços em branco, e cada palavra é composta de letras minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.

O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.

Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação no texto. 
Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra escolhida para tal letra. 
As linhas devem ser impressas em ordem crescente da letra inicial.

Deve ser feito para CADA LETRA DO ALFABETO. 
Deve-se considerar a maior economia de caracteres possível, ou seja, não basta escolher a maior palavra da frase que comece com
cada letra do alfabeto, mas sim aquela que irá trazer a maior economia de caracteres ao ser abreviada (palavras repetidas por exemplo)
 
|---------------------------------------|
| Exemplo de Entrada | Exemplo de Saída |
|--------------------|------------------|
| abcdef abc abc     | a. abc abc ab    |
| abc         		 | 1                |
| .                  | a. = abcdef      |
|---------------------------------------|


*/


package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AbreviandoPosts {

	/**
	 *
	 * Solução por: Lucas Cerqueira Linkedin:
	 * https://www.linkedin.com/in/cerqueiralucas/
	 * 
	 * Qualquer dúvida sobre o raciocínio, me adicione!
	 */

	static Map<String, Integer> mapAmountOfChanges = new HashMap<>();
	static Map<String, String> dictionary = new HashMap<>();
	static Map<String, Integer> eachLetterCount = new TreeMap<>();
	static Integer howManyReplacements = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> alphabet = new ArrayList<>();

		for (char i = 'a'; i <= 'z'; i++) {
			alphabet.add(Character.toString(i));
		}

		while (true) {

			// necessario inicializar o map Letra / Contador no loop pois ao final do while
			// ele foi clear
			for (char i = 'a'; i <= 'z'; i++) {
				eachLetterCount.put(Character.toString(i), 0);
			}

			String input = scanner.nextLine().toLowerCase().trim();

			if (input.equals(".")) {
				break;
			}

			for (String letter : alphabet) {
				generateDictionary(input, letter);
			}

			System.out.println(replaceAll(input));

			// para calcular a quantidade de substituições realizadas
			for (String letter : eachLetterCount.keySet()) {
				if (eachLetterCount.get(letter) > 0) {
					howManyReplacements += 1;
				}
			}

			System.out.println(howManyReplacements);

			// para printar cada palavra substituida para cada letra
			for (String letter : eachLetterCount.keySet()) {
				if (eachLetterCount.get(letter) > 0) {

					System.out.println(letter + ". = " + dictionary.get(letter));
				}
			}

			mapAmountOfChanges.clear();
			eachLetterCount.clear();
			dictionary.clear();
			howManyReplacements = 0;

		}

	}

	public static String getMostViableWordToReplace(String phrase, String character) {

		String[] array = phrase.split(" ");
		Map<String, Integer> mostViableWord = new HashMap<>();
		Integer count = 0;

		// itera sobre cada palavra na frase
		for (String word : array) {

			// se a palavra começa com a letra passada como parâmetro
			// adiciona no mapa a palavra e a quantidade de vezes que ela aparece
			if (Character.toString(word.charAt(0)).equals(character)) {

				if (mostViableWord.containsKey(word)) {
					count = mostViableWord.get(word) + 1;
					mostViableWord.put(word, count);
				} else {
					mostViableWord.put(word, 1);
				}
			}

		}

		Integer letterSum = 0;
		Integer tempSum = 0;

		// itera no mapa das palavras que começam com a letra passada,
		// conferindo a economia possível se ela for a abreviada da frase
		for (String word : mostViableWord.keySet()) {
			tempSum = 0;
			letterSum = (word.length()) * mostViableWord.get(word) - (mostViableWord.get(word) * 2);
			if (letterSum > tempSum) {
				tempSum = letterSum;
			}
			mostViableWord.put(word, tempSum);
		}

		String finalAndMostViableWord = "";
		Integer highestCountOfCharacters = 0;

		// retorna a quantidade maxima de economia de letras
		if (!mostViableWord.isEmpty()) {
			highestCountOfCharacters = Collections.max(mostViableWord.values());

		}

		// itera sobre cada palavra do mapa, e compara se aquela palavra é a que mais
		// trará economia
		for (String word : mostViableWord.keySet()) {

			if (mostViableWord.get(word).equals(highestCountOfCharacters)) {
				finalAndMostViableWord = word;

			}
		}

		mostViableWord.clear();

		// retorna a melhor palavra para aquela letra
		return finalAndMostViableWord;

	}

	public static void generateDictionary(String phrase, String character) {

		String[] array = phrase.split(" ");
		String wordToReplace = "";

		wordToReplace = getMostViableWordToReplace(phrase, character);

		// coloca no dicionario final cada letra, e a melhor palavra
		dictionary.put(character, wordToReplace);

	}

	public static String replaceAll(String phrase) {

		String[] array = phrase.split(" ");
		StringBuilder stringBuilder = new StringBuilder();

		for (String word : array) {
			String key = Character.toString(word.charAt(0));
			String newWord = word;
			Integer countEach = 0;

			if (word.length() > 2) {

				// compara o dicionario com cada palavra da frase inicial e gera as
				// substituicoes
				// tambem acrescenta ao contador cada palavra substituida
				if (dictionary.containsKey(key)) {
					if (word.equals(dictionary.get(key))) {
						newWord = key + ".";

						countEach = eachLetterCount.get(key) + 1;
						eachLetterCount.put(key, countEach);

					} else {
						newWord = word;
					}
				}

			}

			// monta a frase final, com as palavras abreviadas
			stringBuilder.append(newWord).append(" ");

		}
		String finalPhrase = stringBuilder.toString();

		return finalPhrase;
	}
}
