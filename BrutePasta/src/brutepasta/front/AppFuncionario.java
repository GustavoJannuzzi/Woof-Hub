package brutepasta.front;

import brutepasta.entidades.*;
import brutepasta.negocio.ClienteNegocio;
import brutepasta.persistencia.CaninoPersistencia;
import brutepasta.persistencia.ClientePersistencia;
import brutepasta.persistencia.TipoProdutoPersistencia;
import org.hibernate.internal.build.AllowSysOut;

public class AppFuncionario {
	public AppFuncionario() {
		int opc;
		do {
			System.out.println("\n\n====== PETS CANINOS ======");
			System.out.println("1 - Cadastrar Doguinho");
			System.out.println("2 - Pesquisar Doguinho");
			System.out.println("3 - Alterar doguinho");
			System.out.println("4 - Excluir doguinho");
			System.out.println("5 - Voltar");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					cadastrarDoguinho();
					break;
				case 2:
					new AppFuncionarioConsultar();
					break;
				case 3:
					alterarDoguinho();
					break;
				case 4:
					excluirDoguinho();
					break;
			}
		} while (opc != 5);
	}

	public static void cadastrarDoguinho() {
		System.out.println("\n\n====== CADASTRO DE DOGUINHOS ======");
		Caninos objCanino = new Caninos();
		objCanino.setNome(Console.readString("\n\nInforme o nome do doguinho: "));
		if (CaninoPersistencia.procurarPorNome(objCanino) == null) {
			objCanino.setIdade(Console.readString("Informe a idade do doguinho: "));
			objCanino.setPeso(Console.readString("Informe o peso do doguinho: "));
			CaninoPersistencia.incluir(objCanino);
			System.out.println("\n\nCadastro realizado!!");
		} else {
			System.out.println("\n\nCliente já cadastrado.");
		}
	}


	private static void consultarCanino() {
		System.out.println("\n\n====== CONSULTA DE CÃES======");
		Caninos objCanino = new Caninos();
		objCanino.setNome(Console.readString("Informe o Nome do cãozinho que desja pesquisar: "));
		objCanino = CaninoPersistencia.procurarCaninoPorLT(objCanino);
		if (objCanino != null) {
			System.out.println("============================");
			System.out.println("Nome: " + objCanino.getNome());
			System.out.println("Idade: " + objCanino.getIdade());
			System.out.println("Peso: " + objCanino.getPeso());
			System.out.println("Situação: " + objCanino.getSituacao());
			System.out.println("============================");
		}
	}

	private static void alterarDoguinho() {
		int opc;
		Caninos objCanino = new Caninos();
		objCanino.setNome(Console.readString("\n\nInforme o Nome do doguinho: "));
		objCanino = CaninoPersistencia.procurarPorNome(objCanino);
		if (objCanino != null) {
			System.out.println("============================");
			System.out.println("Idade: " + objCanino.getIdade());
			System.out.println("Peso: " + objCanino.getPeso());
			System.out.println("============================");
			String resp = Console.readString("\n\nAlterar dados do doguinho [S]/[N]: ");
			if (resp.equals("S")) {
				do {
					System.out.println("\n\n");
					System.out.println("====== ALTERAÇÃO ======");
					System.out.println("1 - Alterar Nome");
					System.out.println("2 - Alterar Idade");
					System.out.println("3 - Alterar Peso");
					System.out.println("4 - Alterar Situação");
					System.out.println("5 - Sair");
					opc = Console.readInt("Opção: ");
					switch (opc) {
						case 1:
							objCanino.setNome(Console.readString("\n\nInforme um novo nome: "));
							if (CaninoPersistencia.alterar(objCanino)) {
								System.out.println("\n\nAlteração realizada!!");
							} else {
								System.out.println("\n\nOcorreu um erro ao alterar dados do cliente.");
							}
							break;
						case 2:
							objCanino.setIdade(Console.readString("\n\nInforme noa idade: "));
							if (CaninoPersistencia.alterar(objCanino)) {
								System.out.println("\n\nAlteração realizada!!");
							} else {
								System.out.println("\n\nOcorreu um erro ao alterar dados do cliente.");
							}
							break;
						case 3:
							objCanino.setPeso(Console.readString("\n\nInforme um novo peso: "));
							if (CaninoPersistencia.alterar(objCanino)) {
								System.out.println("\n\nAlteração realizada!!");
							} else {
								System.out.println("\n\nOcorreu um erro ao alterar dados do cliente.");
							}
							break;
						case 4:
							objCanino.setSituacao(Console.readString("\n\nInforme a atual situação de adoção: "));
							if (CaninoPersistencia.alterar(objCanino)) {
								System.out.println("\n\nAlteração realizada!!");
							} else {
								System.out.println("\n\nOcorreu um erro ao alterar dados do dog.");
							}
							break;
					}
				}while (opc != 5);
			}
		} else {
			System.out.println("\n\nCãozinho não cadastrado.");
		}
	}

	private static void excluirDoguinho() {
		Caninos objCanino = new Caninos();
		objCanino.setNome(Console.readString("\n\nInforme o Nome do cãozinho: "));
		objCanino = CaninoPersistencia.procurarPorNome(objCanino);
		if (objCanino != null) {
			System.out.println("============================");
			System.out.println("Nome: " + objCanino.getIdade());
			System.out.println("CPF: " + objCanino.getPeso());
			System.out.println("============================");
			String resp = Console.readString("\n\nExcluir cliente [S]/[N]: ");
			if (resp.equals("S")) {
				if (CaninoPersistencia.excluir(objCanino)) {
					System.out.println("\n\nCliente excluído com sucesso!");
				} else {
					System.out.println("\n\nOcorreu um erro ao excluir o cliente.");
				}
			}
		} else {
			System.out.println("\n\nCliente não cadastrado.");
		}
	}
}