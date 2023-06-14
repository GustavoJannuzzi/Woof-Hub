package brutepasta.front;

public class Principal {
	public static void main(String[] args) {
		int opc;
		do {
			System.out.println("\n\n");
			System.out.println("====== WOOF HUB ====== ");
			System.out.println("1 - Pais adotivos");
			System.out.println("2 - Pets caninos");
			System.out.println("3 - Pets felinos");
			System.out.println("4 - Registrar adoção");
			System.out.println("5 - Sair");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					new AppClientes();
					break;
				case 2:
					new AppFuncionario();
					break;
				case 3:
					new AppEntregador();
					break;
				case 4:
					new AppPedido();
					break;
			}
		} while (opc != 5);
	}
}
