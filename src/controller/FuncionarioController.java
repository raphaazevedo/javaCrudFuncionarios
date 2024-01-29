package controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	public void cadastraFuncionario() {

		Scanner scanner = new Scanner(System.in);

		Funcionario funcionario = new Funcionario();

		funcionario.setId(UUID.randomUUID());

		System.out.println("Insira o nome do funcionário:");
		funcionario.setNome(scanner.nextLine());

		System.out.println("Insira o cpf:");
		funcionario.setCpf(scanner.nextLine());

		System.out.println("Insira a matricula:");
		funcionario.setMatricula(scanner.nextLine());

		System.out.println("Insira o salário:");
		funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		try {
			funcionarioRepository.cadastra(funcionario);

			System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO!!!!");
		} catch (Exception e) {
			System.out.println("ERRO AO CADASTRAR FUNCIONARIO: " + e.getMessage());
		}

		scanner.close();
	}

	public void atualizaFuncionario() throws Exception {

		System.out.println("EDIÇÃO DE FUNCIONARIO:");
		Scanner scanner = new Scanner(System.in);

		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

		Funcionario funcionario = funcionarioRepository.findById(id);

		if (funcionario != null) {

			System.out.print("INFORME O NOME......: ");
			funcionario.setNome(scanner.nextLine());

			System.out.print("INFORME O cpf.......: ");
			funcionario.setCpf(scanner.nextLine());

			System.out.print("INFORME O MATRICULA.: ");
			funcionario.setMatricula(scanner.nextLine());

			System.out.print("INFORME O SALÁRIO.: ");
			funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

			// atualizando o registro de pessoa no banco de dados
			funcionarioRepository.atualiza(funcionario);

			System.out.println("\nPESSOA ATUALIZADA COM SUCESSO!");

		} else {

			System.out.println("FUNCIONARIO NÃO ENCONTRADO!!!");

		}

		scanner.close();
	}

	public void deleta() throws Exception {

		System.out.println("\nEXCLUSÃO DE FUNCIONARIO:\n");
		Scanner scanner = new Scanner(System.in);

		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		Funcionario funcionario = funcionarioRepository.findById(id);

		
		if (funcionario != null) {

			
			funcionarioRepository.deleta(funcionario);

			System.out.println("\nPESSOA EXCLUÍDA COM SUCESSO!");
		} else {
			System.out.println("\nPESSOA NÃO ENCONTRADA. VERIFIQUE O ID.");
		}

		scanner.close();

	}
	public void listaFuncionarios()throws Exception{
		
			System.out.println("\nCONSULTA DE Funcionario:\n");
			
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			List<Funcionario> lista = funcionarioRepository.findAll();
			
			for(Funcionario funcionario : lista) {
				
				System.out.println("ID DA PESSOA...: " + funcionario.getId());
				System.out.println("NOME...........: " + funcionario.getNome());
				System.out.println("CPF............: " + funcionario.getCpf());
				System.out.println("Matricula......: " + funcionario.getMatricula());
				System.out.println("Salario........: " + funcionario.getSalario());
				System.out.println("...");
			}		
		
	}
}
