package main.java.viniprogram.cam;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.viniprogram.cam.controllers.AtividadeEstudantil;
import main.java.viniprogram.cam.controllers.Estudante;

public class Application {
    public static void main(String[] args) {

        ArrayList<Estudante> estudantes = new ArrayList<>();
        ArrayList<AtividadeEstudantil> atividades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("_________________________________________________________________________");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Atividade");
            System.out.println("3. Visualizar atividades a partir da matrícula");
            System.out.println("4. Alterar status de aproveitamento da atividade");
            System.out.println("5. Mostrar carga horária total das atividades complementares dos alunos");
            System.out.println("6. Mostrar carga horária total das atividades complementares de um aluno");
            System.out.println("7. Sair");
            System.out.println("_________________________________________________________________________");

            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        Estudante estudante = Estudante.cadastrarEstudante(estudantes);
                        break;
                    case 2:
                        AtividadeEstudantil atividade = AtividadeEstudantil.cadastrarAtividade(estudantes, atividades);
                        break;
                    case 3:
                        AtividadeEstudantil.exibirAtividadesPorMatricula(atividades);
                        break;
                    case 4:
                        AtividadeEstudantil.alterarStatusAproveitamento(atividades, estudantes);
                        break;
                    case 5:
                        Estudante.mostrarCargaHorariaTotal(estudantes);
                        break;
                    case 6:
                        Estudante.mostrarCargaHorariaEstudantePorMatricula(estudantes);
                        break;
                    case 7:
                        System.out.println(
                                "Obrigado por usar o sistema de gestão das atividades complementares. Tchau tchau!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            } else {
                System.out.println("Opção inválida. Por favor, escolha novamente.");
                scanner.nextLine();
            }
        }
    }
}
