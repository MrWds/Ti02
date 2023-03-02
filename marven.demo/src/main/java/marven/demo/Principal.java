package marven.demo;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
        int opcao;
        Scanner entrada = new Scanner(System.in);		
		dao.conectar();
        do{
            System.out.println("\tCadastro de clientes");
            System.out.println("0. Sair");
            System.out.println("1. Inserir um carro na tabela");
            System.out.println("2. Atualizar carros");
            System.out.println("3. Excluir carros");
            System.out.println("4. Mostrar carros");
            System.out.println("Opcao:");
            opcao = entrada.nextInt();
            Carro carro = new Carro(4, "bugatti", "def321",'N');
            switch(opcao){
            case 1:
        		//Inserir um elemento na tabela
        		carro = new Carro(4, "bugatti", "def321",'N');
        		if(dao.inserirCarro(carro) == true) {
        			System.out.println("Inserção com sucesso -> " + carro.toString());
        		}
                break;
                
            case 2:
        		//Atualizar usuário
        		carro.setPlaca("nova placa");
        		dao.atualizarCarro(carro);
        		break;
                
            case 3:
        		//Excluir usuário
        		dao.excluirCarro(carro.getCodigo());
        		break;
            case 4:
        		//Mostrar usuários
            	Carro[] carros = dao.getCarros();
        		System.out.println("==== Mostrar usuários === ");		
        		for(int i = 0; i < carros.length; i++) {
        			System.out.println(carros[i].toString());
        		}
        		break;
        		
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
		dao.close();
	}
}