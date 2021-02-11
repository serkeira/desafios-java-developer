/*
//### Desafio - Ordenando Números Pares e Ímpares
Crie um programa onde você receberá valores inteiros não negativos como entrada.
Ordene estes valores de acordo com o seguinte critério:
•	Primeiro os Pares
•	Depois os Ímpares
Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.

//### Entrada
A primeira linha de entrada contém um único inteiro positivo N (1 < N < 105) Este é o número de linhas de entrada que vem logo a seguir.
As próximas N linhas terão, cada uma delas, um valor inteiro não negativo.

//### Saída
Exiba todos os valores lidos na entrada segundo a ordem apresentada acima. Cada número deve ser impresso em uma linha, conforme exemplo de saída abaixo.
|---------------------------------------|
| Exemplo de Entrada | Exemplo de Saída |
|--------------------|------------------|
| 10                 |                  |
| 4                  | 4                |
| 32                 | 32               |
| 34                 | 34               |
| 543                | 98               |
| 3456               | 654              |
| 654                | 3456             |
| 567                | 6789             |
| 87                 | 567              |
| 6789               | 543              |
| 98                 | 87               |
|---------------------------------------|
*/

package com.lucascerqueira;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class StreamsImparesPares {

    // Solução Por: Lucas Cerqueira
    // Linkedin: https://www.linkedin.com/in/cerqueiralucas/
  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> listaPares = new ArrayList<>();
        List<Integer> listaImpares = new ArrayList<>();
        Integer numero = 0;

        Integer contagemDeNumeros = sc.nextInt();
        Integer count = 0;

        while (count < contagemDeNumeros) {
            numero = sc.nextInt();

            if (numero % 2 == 0) {
                listaPares.add(numero);
            } else {
                listaImpares.add(numero);
            }

            count++;
        }
        
        sc.close();

        listaPares.stream().sorted().forEach(elemento -> {
            System.out.println(elemento);
        });
        
        listaImpares.stream().sorted(Comparator.reverseOrder()).forEach(elemento -> {
            System.out.println(elemento);
        });

    }

}
