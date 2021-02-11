/*
//### Desafio - Uniformes de final de ano
O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano.
Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou vermelho.
Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.

//### Entrada
Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que indica a quantidade de uniformes a serem feitas para aquela turma.
As próximas N*2 linhas contém informações de cada um dos uniformes (serão duas linhas de informação para cada uniforme).
A primeira linha irá conter o nome do estudante e a segunda linha irá conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do uniforme "P" "M" ou "G".
A entrada termina quando o valor de N for igual a zero (0) e esta valor não deverá ser processado.

//### Saída
Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente, seguido pelos tamanhos em ordem descendente e por último por ordem ascendente de nome, conforme o exemplo abaixo.
|----------------------------------------------------|
| Exemplo de Entrada |       Exemplo de Saída        |
|--------------------|-------------------------------|
| 9                  | branco P Cezar Torres Mo      |
| Maria Jose         | branco P Maria Jose           |
| branco P           | branco M JuJu Mentina         |
| Mangojata Mancuda  | branco G Adabi Finho          |
| vermelho P         | branco G Severina Rigudinha   |
| Cezar Torres Mo    | vermelho P Amaro Dinha        |
| branco P           | vermelho P Baka Lhau          |
| Baka Lhau          | vermelho P Carlos Chade Losna |
| vermelho P         | vermelho P Mangojata Mancuda  |
| JuJu Mentina       |                               |
| branco M           |                               |
| Amaro Dinha        |                               |
| vermelho P         |                               |
| Adabi Finho        |                               |
| branco G           |                               |
| Severina Rigudinha |                               |
| branco G           |                               |
| Carlos Chade Losna |                               |
| vermelho P         |                               |
| 0                  |                               |
|----------------------------------------------------|
 */
package com.lucascerqueira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Solução por: Lucas Cerqueira 
 * - Linkedin: https://www.linkedin.com/in/cerqueiralucas/
 */
public class ListaDeUniformes {

    public static class Aluno {

        private String nome;
        private String tamanho;
        private String cor;

        public Aluno(String nome, String tamanho, String cor) {
            this.nome = nome;
            this.tamanho = tamanho;
            this.cor = cor;
        }

        public Aluno() {

        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTamanho() {
            return tamanho;
        }

        public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        @Override
        public String toString() {
            return "Aluno{" + "nome=" + nome + ", tamanho=" + tamanho + ", cor=" + cor + '}';
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer quantidadeUniformes = scanner.nextInt();
        scanner.nextLine();
        String nome, uniforme, cor, tamanho;

        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        for (int i = 0; i < quantidadeUniformes; i++) {

            nome = scanner.nextLine();

            uniforme = scanner.nextLine();
            cor = uniforme.split(" ")[0];
            tamanho = uniforme.split(" ")[1];

            listaAlunos.add(new Aluno(nome, tamanho, cor));

        }
        scanner.close();

        try {
            Collections.sort(listaAlunos, Comparator.comparing((Aluno a) -> a.getCor())
                    .thenComparing(Comparator.comparing((Aluno a) -> a.getTamanho()).reversed())
                    .thenComparing(a -> a.getNome())
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno.getCor()
                    + " " + aluno.getTamanho()
                    + " " + aluno.getNome()
            );
        }

    }

}
