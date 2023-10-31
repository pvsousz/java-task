package main.java.viniprogram.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class AtividadeEstudantil {
    private String nomeEstudante;
    private int matriculaEstudante;
    private static int contadorNumeroRegistro = 1;
    private int numeroRegistro;
    private int grupoAtividade;
    private String descricaoAtividade;
    private boolean statusAproveitamento;
    private int cargaHorariaConsiderada;

    public AtividadeEstudantil(String nomeEstudante, int matriculaEstudante, int grupoAtividade, String descricaoAtividade) {
        this.nomeEstudante = nomeEstudante;
        this.matriculaEstudante = matriculaEstudante;
        this.grupoAtividade = grupoAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.statusAproveitamento = false;
        this.cargaHorariaConsiderada = 0;
        this.numeroRegistro = contadorNumeroRegistro;
        contadorNumeroRegistro++;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public int getGrupoAtividade() {
        return grupoAtividade;
    }

    public void setGrupoAtividade(int grupoAtividade) {
        this.grupoAtividade = grupoAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public boolean isStatusAproveitamento() {
        return statusAproveitamento;
    }

    public void setStatusAproveitamento(boolean statusAproveitamento) {
        this.statusAproveitamento = statusAproveitamento;
    }

    public int getCargaHorariaConsiderada() {
        return cargaHorariaConsiderada;
    }

    public void setCargaHorariaConsiderada(int cargaHorariaConsiderada) {
        this.cargaHorariaConsiderada = cargaHorariaConsiderada;
    }

    public String getNomeEstudante() {
        return nomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }

    public int getMatriculaEstudante() {
        return matriculaEstudante;
    }

    public void setMatriculaEstudante(int matriculaEstudante) {
        this.matriculaEstudante = matriculaEstudante;
    }

    public static boolean salvarAtividade(ArrayList<AtividadeEstudantil> atividades, AtividadeEstudantil atividade) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar as informações da atividade? (s/n): ");
        String respostaSalvar = scanner.nextLine().trim().toLowerCase();

        if (respostaSalvar.equalsIgnoreCase("s") || respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Informações salvas!");
            atividades.add(atividade);
            return true;
        } else {
            System.out.println("Informações não salvas.");
            return false;
        }
    }

    public static AtividadeEstudantil cadastrarAtividade(ArrayList<Estudante> estudantes, ArrayList<AtividadeEstudantil> atividades) {
        Scanner scanner = new Scanner(System.in);
        int matricula = 0;
        while (true) {
            System.out.println("Digite a matrícula do estudante: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                break;
            } else {
                System.out.println("Erro: A matrícula deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }
        Estudante estudanteEncontrado = encontrarEstudantePorMatricula(matricula, estudantes);
        if (estudanteEncontrado != null) {

            String nomeEstudante = estudanteEncontrado.getNomeCompleto();
            scanner.nextLine();
            int grupoAtividade = 0;
            while (true) {
                System.out.print("Digite o grupo da atividade: ");
                if (scanner.hasNextInt()) {
                    grupoAtividade = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println(
                            "Erro: O grupo de atividade deve conter apenas números. Por favor, tente novamente.");
                    scanner.nextLine();
                }
            }
            System.out.print("Digite a descrição da atividade: ");
            String descricaoAtividade = scanner.nextLine();
            AtividadeEstudantil atividade = new AtividadeEstudantil(nomeEstudante, matricula, grupoAtividade, descricaoAtividade);
            boolean dadosSalvos = salvarAtividade(atividades, atividade);
            if (dadosSalvos) {
                System.out.println("Atividade cadastrada com sucesso! Número de registro da atividade é "
                        + atividade.getNumeroRegistro());
            } else {
                System.out.println("Cadastro da atividade cancelado.");
            }

            return atividade;
        } else {

            System.out.println("Matrícula não encontrada. Não é possível cadastrar a atividade.");
            return null;
        }
    }

    public void exibirAtividadeEstudantil() {
        System.out.println("Número de Registro: " + numeroRegistro);
        System.out.println("Nome do Estudante: " + nomeEstudante);
        System.out.println("Matrícula: " + matriculaEstudante);
        System.out.println("Grupo da Atividade: " + grupoAtividade);
        System.out.println("Descrição da Atividade: " + descricaoAtividade);
        System.out.println("Status de Aproveitamento: " + statusAproveitamento);
        System.out.println("Carga Horária Considerada: " + cargaHorariaConsiderada + " horas\n");
    }

    public static void exibirAtividadesPorMatricula(ArrayList<AtividadeEstudantil> atividades) {
        Scanner scanner = new Scanner(System.in);
        int matricula = 0;
        while (true) {
            System.out.print("Digite a matrícula do estudante para pesquisar atividades: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println(
                        "Erro: A matrícula deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }
        boolean encontrou = false;
        for (AtividadeEstudantil atividade : atividades) {
            if (atividade.getMatriculaEstudante() == matricula) {
                atividade.exibirAtividadeEstudantil();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma atividade encontrada para a matrícula " + matricula + ".");
        }
    }

    public static void alterarStatusAproveitamento(ArrayList<AtividadeEstudantil> atividades, ArrayList<Estudante> estudantes) {
        Scanner scanner = new Scanner(System.in);
        int matricula = 0;
        while (true) {
            System.out.println("Digite a Matrícula do Estudante: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Erro: A matrícula deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }
        int numeroRegistro = 0;
        while (true) {
            System.out.print("Digite o número de registro da atividade: ");
            if (scanner.hasNextInt()) {
                numeroRegistro = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out
                        .println("Erro: O número de registro deve conter apenas números. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }

        AtividadeEstudantil atividadeEncontrada = encontrarAtividadePorMatriculaENumeroRegistro(matricula, numeroRegistro,
                atividades);
        if (atividadeEncontrada != null) {
            System.out.print("Digite o novo status de aproveitamento (true ou false): ");
            String novoStatusAproveitamentoStr = scanner.nextLine();
            boolean novoStatusAproveitamento;
            if (novoStatusAproveitamentoStr.equalsIgnoreCase("true")) {
                novoStatusAproveitamento = true;
            } else if (novoStatusAproveitamentoStr.equalsIgnoreCase("false")) {
                novoStatusAproveitamento = false;
            } else {
                System.out.println("Erro: Digite apenas 'true' ou 'false' para o status de aproveitamento.");
                return;
            }
            
            int cargaHorariaConsiderada = 0;
            while (true) {
                System.out.print("Digite a carga horária considerada: ");
                if (scanner.hasNextInt()) {
                    cargaHorariaConsiderada = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Erro: A carga horária deve conter apenas números. Por favor, tente novamente.");
                    scanner.nextLine();
                }
            }

            atividadeEncontrada.setStatusAproveitamento(novoStatusAproveitamento);
            atividadeEncontrada.setCargaHorariaConsiderada(cargaHorariaConsiderada);

            if (novoStatusAproveitamento) {
                Estudante estudante = encontrarEstudantePorMatricula(matricula, estudantes);
                if (estudante != null) {
                    // Atualizar carga horária total e quantidade de atividades do estudante
                    estudante.setCargaHorariaTotal(estudante.getCargaHorariaTotal() + cargaHorariaConsiderada);
                    estudante.setQuantidadeAtividades(estudante.getQuantidadeAtividades() + 1);
                    System.out.println(
                            "Atividade aprovada. Carga horária total atualizada para: " + estudante.getCargaHorariaTotal());
                }
            } else {
                System.out.println("Atividade reprovada.");
            }
        } else {
            System.out.println("Atividade não encontrada para a matrícula e número de registro fornecidos.");
        }
    }

    private static Estudante encontrarEstudantePorMatricula(int matricula, ArrayList<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (estudante.getNumeroMatricula() == matricula) {
                return estudante;
            }
        }
        return null;
    }

    private static AtividadeEstudantil encontrarAtividadePorMatriculaENumeroRegistro(int matricula, int numeroRegistro,
            ArrayList<AtividadeEstudantil> atividades) {
        for (AtividadeEstudantil atividade : atividades) {
            if (atividade.getMatriculaEstudante() == matricula && atividade.getNumeroRegistro() == numeroRegistro) {
                return atividade;
            }
        }
        return null;
    }
}
