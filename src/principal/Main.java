package principal;

import java.util.Scanner;

import controller.FuncionarioController;

public class Main {

	public static void main(String[] args) {

		System.out.println("SISTEMA DE CADASTRO DE FUNCIONÁRIOS");
		Scanner scanner = new Scanner(System.in);
		try {
			Integer opcao;
			System.out.println("(1) Para cadastrar funcionário");
			System.out.println("(2) Para atualizar funcionário");
			System.out.println("(3) Para deletar funcionário");
			System.out.println("(4) Para listar funcionário");
			
			opcao = Integer.parseInt(scanner.nextLine());
			
			FuncionarioController funcionarioController = new FuncionarioController();
			
			switch (opcao) {
			case 1: 
				funcionarioController.cadastraFuncionario();
				
				break;
			case 2:
				funcionarioController.atualizaFuncionario();
				break;
			case 3:
				funcionarioController.deleta();
				break;
			case 4:
				funcionarioController.listaFuncionarios();
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!!!!");
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("ERRO NO SISTEMA: " + e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
