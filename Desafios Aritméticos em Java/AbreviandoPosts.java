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
