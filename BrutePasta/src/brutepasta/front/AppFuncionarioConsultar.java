package brutepasta.front;

import brutepasta.entidades.Caninos;
import brutepasta.persistencia.CaninoPersistencia;

public class AppFuncionarioConsultar {
    public AppFuncionarioConsultar() {
        int opc;
        do {
            System.out.println("\n\n");
            System.out.println("====== O QUE VOCÊ DESEJA CONSULTAR ======");
            System.out.println("1 - Pesquisar Doguinhos");
            System.out.println("2 - Dogs em lar temporário");
            System.out.println("3 - Dogs sem lar");
            System.out.println("4 - Voltar");
            opc = Console.readInt("Opção: ");
            switch (opc) {
                case 1:
                    consultarCanino();
                    break;
                case 2:
                    consultarCaninoEmLT();
                    break;
                case 3:
                    ;
                    break;
            }
        } while (opc != 4);
    }

    private static void consultarCanino() {
        System.out.println("\n\n====== CONSULTA DE CÃES======");
        Caninos objCanino = new Caninos();
        objCanino.setNome(Console.readString("Informe o Nome do cãozinho que desja pesquisar: "));
        objCanino = CaninoPersistencia.procurarPorNome(objCanino);
        if (objCanino != null) {
            System.out.println("============================");
            System.out.println("Nome: " + objCanino.getNome());
            System.out.println("Idade: " + objCanino.getIdade());
            System.out.println("Peso: " + objCanino.getPeso());
            System.out.println("Situação: " + objCanino.getSituacao());
            System.out.println("============================");
        }
    }
    private static void consultarCaninoEmLT() {
        System.out.println("\n\n====== CONSULTA DE CÃES EM LAR TEMPORÁRIO======");
        Caninos objCanino = new Caninos();
        objCanino.setSituacao(Console.readString("Digite 'LT': "));
        objCanino = CaninoPersistencia.procurarCaninoPorLT(objCanino);
        if (objCanino != null) {
            System.out.println("============================");
            System.out.println("Nome: " + objCanino.getNome());
            System.out.println("Idade: " + objCanino.getIdade());
            System.out.println("Peso: " + objCanino.getPeso());
            System.out.println("Situação: " + objCanino.getSituacao());
            System.out.println("============================");
        }else {
            System.out.println("\n\n== Não há Lar temporário disponível. ==");
        }
    }
}
