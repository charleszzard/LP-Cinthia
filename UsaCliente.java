package TrabalhoEmGrupo;

import java.util.ArrayList;
import java.util.Scanner;

public class UsaCliente {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Gerar senha");
            System.out.println("2 - Atendimento");
            System.out.println("3 - Sair da fila");
            System.out.println("4 - Mostrar todos os clientes não atendidos");
            System.out.println("5 - Sair do programa");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    gerarSenha(clientes, entrada);
                    break;
                case 2:
                    atendimento(clientes);
                    break;
                case 3:
                    sairDaFila(clientes, entrada);
                    break;
                case 4:
                    mostrarClientes(clientes);
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        entrada.close();
    }

   
    public static void gerarSenha(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        System.out.println("Nome: " + cliente.getNome() + ", Senha: " + cliente.getSenhaDoCliente());
    }

   
    public static void atendimento(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes para atender.");
            return;
        }
        
        int proximaSenha = Cliente.proximo();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getSenhaDoCliente() == proximaSenha) {
                System.out.println("Atendendo: " + cliente.toString());
                clientes.remove(cliente);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum cliente encontrado com a senha " + proximaSenha);
        }
    }


    public static void sairDaFila(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite sua senha: ");
        int senha = scanner.nextInt();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getSenhaDoCliente() == senha) {
                clientes.remove(cliente);
                System.out.println("Cliente com a senha " + senha + " foi removido da fila.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum cliente encontrado com a senha " + senha);
        }
    }

 
    public static void mostrarClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente na fila.");
        } else {
            System.out.println("Clientes não atendidos:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
        }
    }
}
