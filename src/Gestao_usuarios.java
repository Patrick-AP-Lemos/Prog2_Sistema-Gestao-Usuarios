/*
 * 					Trabalho 1
 * 			Sistema de Gestão de Usuários
 * 
 * Autor: Patrick Andrei PInheiro de Lemos
 * Disciplina: Programação 2
 * 
 */

import java.util.Scanner;

public class Gestao_usuarios{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		final int MAXIMO_USUARIOS = 1000;//1000
        
		//Definição dos vetores e variáveis auxiliáres
		String[] nomes = new String[MAXIMO_USUARIOS];
		int[] idades = new int[MAXIMO_USUARIOS];
		int totalUsuarios = 0;

		//Leitura dos dados de entrada
		while(totalUsuarios < MAXIMO_USUARIOS){
			String linha = entrada.nextLine();
			int separador = linha.lastIndexOf('#');
			nomes[totalUsuarios] = linha.substring(0, separador);
			idades[totalUsuarios] = Integer.parseInt(linha.substring(separador + 1));
			totalUsuarios++;
		}
   
		//Índices para ordenações
		int[] indicePorNome = new int[totalUsuarios];
		int[] indicePorIdade = new int[totalUsuarios];
		for(int i = 0; i < totalUsuarios; i++){
			indicePorNome[i] = i;
			indicePorIdade[i] = i;
		}
   
		//Ordenação por nome (crescente) - Selection Sort
		for(int i = 0; i < totalUsuarios - 1; i++){
			int menor = i;
			for(int j = i + 1; j < totalUsuarios; j++){
				if(nomes[indicePorNome[j]].compareTo(nomes[indicePorNome[menor]]) < 0){
					menor = j;
				}
			}
			int temp = indicePorNome[i];
			indicePorNome[i] = indicePorNome[menor];
			indicePorNome[menor] = temp;
		}
   
		//Ordenação por idade (crescente) - Selection Sort
		for(int i = 0; i < totalUsuarios - 1; i++){
			int menor = i;
			for(int j = i + 1; j < totalUsuarios; j++){
				if(idades[indicePorIdade[j]] < idades[indicePorIdade[menor]]){
					menor = j;
				}
			}
			int temp = indicePorIdade[i];
			indicePorIdade[i] = indicePorIdade[menor];
			indicePorIdade[menor] = temp;
		}

		int opcao = 0;
		do{
			opcao = entrada.nextInt();
			
//			System.out.println("\n");//Comentário
			System.out.println("1 - Listar ordenado por nome crescente");
			System.out.println("2 - Listar ordenado por nome decrescente");
			System.out.println("3 - Listar ordenado por idade crescente");
			System.out.println("4 - Listar ordenado por idade decrescente");
			System.out.println("5 - Localizar um nome");
			System.out.println("6 - Contar ocorrências de um primeiro nome");
			System.out.println("7 - Sair");
			
			switch(opcao){
				case 1:
//					System.out.print("\n____________________ \n1 - Listar ordenado por nome crescente\n");//Comentário
					for(int i = 0; i < totalUsuarios; i++){
						System.out.println(nomes[indicePorNome[i]]);
					}
					break;
				case 2:
//					System.out.print("\n____________________ \n2 - Listar ordenado por nome decrescente\n");//Comentário
					for(int i = totalUsuarios - 1; i >= 0; i--){
						System.out.println(nomes[indicePorNome[i]]);
					}
					break;
				case 3:
//					System.out.print("\n____________________ \n3 - Listar ordenado por idade crescente\n");//Comentário
					for(int i = 0; i < totalUsuarios; i++){
						System.out.println(nomes[indicePorIdade[i]]);
					}
					break;
				case 4:
//					System.out.print("\n____________________ \n4 - Listar ordenado por idade decrescente\n");//Comentário
					for(int i = totalUsuarios - 1; i >= 0; i--){
						System.out.println(nomes[indicePorIdade[i]]);
					}
					break;
				case 5:
					entrada.nextLine(); // Limpa buffer
					String nomeProcurado = entrada.nextLine();
					int baixo = 0, alto = totalUsuarios - 1, iteracoes = 0;
					boolean encontrado = false;
//					System.out.print("\n____________________ \n5 - Localizar um nome " + nomeProcurado + "\n");//Comentário
					while(baixo <= alto){
						iteracoes++;
						int meio = (baixo + alto) / 2;
						String nomeMeio = nomes[indicePorNome[meio]];
					    int comparacao = nomeMeio.compareTo(nomeProcurado);
					    if(comparacao == 0){
					    	encontrado = true;
					    	break;
					    }else if(comparacao < 0){
					    	baixo = meio + 1;
					    }else{
					    	alto = meio - 1;
					    }
					}
					if(encontrado){
						System.out.println("EXISTENTE " + iteracoes);
					}else{
						System.out.println("INEXISTENTE " + iteracoes);
					}
					break;
				case 6:
					entrada.nextLine();
					String primeiroNome = entrada.nextLine();
					int ocorrencias = 0;
//					System.out.print("\n____________________ \n6 - Contar ocorrências de um primeiro nome " + primeiroNome +  "\n");//Comentário
					for(int i = 0; i < totalUsuarios; i++){
						String[] partes = nomes[i].split(" ");
						if(partes.length > 0 && partes[0].equals(primeiroNome)){
							ocorrencias++;
						}
					}
					System.out.println(ocorrencias + " OCORRENCIAS");
					break;
				case 7:
					break;
			}
		}while(opcao != 7);
        
		entrada.close();
	}
}