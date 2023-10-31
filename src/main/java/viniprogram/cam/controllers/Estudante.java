package main.java.viniprogram.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Estudante {
    private String nomeCompleto;
    private static int numeroMatricula;
    private String curso;
    private int cargaHorariaTotal;
    private int quantidadeAtividades;

    Scanner inputScanner = new Scanner(System.in);

    public Estudante(String nomeCompleto, int numeroMatricula, String curso) {
        this.nomeCompleto = nomeCompleto;
        this.numeroMatricula = numeroMatricula;
        this.curso = curso;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public int getQuantidadeAtividades() {
        return quantidadeAtividades;
    }

    public void setQuantidadeAtividades(int quantidadeAtividades) {
        this.quantidadeAtividades = quantidadeAtividades;
    }

    public static boolean salvarEstudante(ArrayList<Estudante> estudantes, Estudante estudante) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar os dados do estudante? (s/n): ");
        String respostaSalvar = scanner.nextLine().trim().toLowerCase();

        if (respostaSalvar.equalsIgnoreCase("s") || respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Dados salvos!");
            estudantes.add(estudante);
            return true;
        } else {
            System.out.println("Dados nao salvos.");
            return false;
        }
    }

    public static Estudante cadastrarEstudante(ArrayList<Estudante> estudantes) {
        Scanner scanner = new Scanner(System.in);
        String nomeCompleto = "";
        while (true) {
            System.out.println("Informe o Nome Completo do estudante: ");
            nomeCompleto = scanner.nextLine();
            if (Pattern.matches("^[a-zA-Z ]+$", nomeCompleto)) {
                break;
            } else {
                System.out.println("Erro: O nome deve conter apenas letras. Por favor, tente novamente.");
            }
        }

        int numeroMatricula = 0;
        while (true) {
            System.out.println("Informe o Número de Matrícula do Estudante: ");
            if (scanner.hasNextInt()) {
                numeroMatricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Erro: A matrícula deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }

        String curso = "";
        while (true) {
            System.out.println("Informe o Curso do Estudante: ");
            curso = scanner.nextLine();
            if (Pattern.matches("^[a-zA-Z ]+$", curso)) {
                break;
            } else {
                System.out.println("Erro: O curso deve conter apenas letras. Por favor, tente novamente.");
            }
        }
        Estudante estudante = new Estudante(nomeCompleto, numeroMatricula, curso);
        boolean dadosSalvos = salvarEstudante(estudantes, estudante);
        if (dadosSalvos) {
            System.out.println("Estudante cadastrado com sucesso!");
        } else {
            System.out.println("Cadastro do estudante cancelado.");
        }

        return estudante;
    }

    public static boolean verificarMatriculaExistente(int numeroMatricula, ArrayList<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (estudante.getNumeroMatricula() == numeroMatricula) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarCargaHorariaTotal(ArrayList<Estudante> estudantes) {
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante está cadastrado.");
        } else {
            System.out.println("Carga horária total das atividades complementares de todos os estudantes cadastrados:");
            for (Estudante estudante : estudantes) {
                System.out.println("Nome: " + estudante.getNomeCompleto());
                System.out.println("Número de Matrícula: " + estudante.getNumeroMatricula());
                System.out.println("Curso: " + estudante.getCurso());
                System.out.println("Carga Horária Total: " + estudante.getCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + estudante.getQuantidadeAtividades());
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarCargaHorariaEstudantePorMatricula(ArrayList<Estudante> estudantes) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o número de matrícula do estudante para mostrar as atividades complementares: ");
            if (scanner.hasNextInt()) {
                numeroMatricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println(
                        "Erro: A matrícula deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }

        boolean encontrado = false;
        for (Estudante estudante : estudantes) {
            if (estudante.getNumeroMatricula() == numeroMatricula) {
                System.out.println("Nome: " + estudante.getNomeCompleto());
                System.out.println("Número de Matrícula: " + estudante.getNumeroMatricula());
                System.out.println("Curso: " + estudante.getCurso());
                System.out.println("Carga Horária Total: " + estudante.getCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + estudante.getQuantidadeAtividades());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println(
                    "Estudante com a matrícula " + numeroMatricula + " não encontrado, ou não foi cadastrado no sistema");
        }
    }
}
