package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.entidades.Contato;
import com.github.mayconmoraesdm.entidades.Entidade;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        menu();

    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcao, continua;

        System.out.println("Digite: \n1: Inserir \n2: Alterar \n3: Excluir \n4: Listar todos \n5:Listar por id\n6:Listar por nome\n7: Fechar aplicação");
        opcao = scanner.nextInt();
        try {
            switch (opcao) {
                case 1:
                    insere();
                    break;
                case 2:
                    altera();
                    break;
                case 3:
                    exclui();
                    break;
                case 4:
                    listaTodos();
                    break;
                case 5:
                    listaId();
                    break;
                case 6:
                    listaNome();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção invalida");
                    menu();
            }
        }catch (SQLException e){
                e.printStackTrace();
        }
        System.out.println("Digite 1 para executar novamente:");
        continua = scanner.nextInt();
        if (continua== 1){
            menu();
        }
    }

    public static void listaTodos() throws SQLException {
        System.out.println("Lista Todos");
        Contato contato = new Contato();
        List<Contato> contatos = contato.busca();
        if (contatos.size() == 0) {
            System.out.printf("Nenhum contato na agenda!");
        } else {
            contatos.forEach(c -> System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\nTelefone2: %s\nCelular2: %s" ,
                    c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getTelefone2(), c.getCelular2())));
        }
    }


    public static void listaId() {
        Scanner scanner = new Scanner(System.in);
        int idBusca;

        System.out.println("Digite o id do registro desejado:");
        idBusca = scanner.nextInt();

        Contato c = new Contato(idBusca);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\nTelefone2: %s\nCelular2: %s",
                c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getTelefone2(), c.getCelular2()));
    }

    public static void listaNome() {
        Scanner scanner = new Scanner(System.in);
        String nomeBusca;

        System.out.println("Digite o nome desejado:");
        nomeBusca = scanner.nextLine();

        Contato c = new Contato(nomeBusca);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\nTelefone2: %s\nCelular2: %s",
                c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getTelefone2(), c.getCelular2()));
    }

    public static void insere() {
        Scanner scanner = new Scanner(System.in);
        String nome, telefone, celular, email, telefone2, celular2;
        System.out.println("Inserindo contato");
        try {
            System.out.println("Nome:");
            nome = scanner.nextLine();
            System.out.println("Telefone:");
            telefone = scanner.nextLine();
            System.out.println("Celular:");
            celular = scanner.nextLine();
            System.out.println("Email:");
            email = scanner.nextLine();
            System.out.println("Telefone2:");
            telefone2 = scanner.nextLine();
            System.out.println("Celular2:");
            celular2 = scanner.nextLine();

            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setCelular(celular);
            contato.setEmail(email);
            contato.setTelefone2(telefone2);
            contato.setCelular2(celular2);
            contato.insere();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void altera() {
        Scanner scanner = new Scanner(System.in);
        int id, opcao = 0;
        String dado;
        //int opcaoAnterior[];


        try {
            listaTodos();
            System.out.println("Digite o id do que deseja alterar:");
            id = scanner.nextInt();
            Contato contato = new Contato(id);
            while (opcao != 7){
                System.out.println("Qual campo deseja alterar?");
                System.out.println("1: Nome\n2: Telefone\n3: Celular\n4: Email\n5: Telefone2\n6: Celular2:\n7: Sair");
                opcao = scanner.nextInt();
                //opcaoAnterior= opcao;
                switch (opcao){
                    case 1:
                        System.out.println("Novo nome:");
                        dado = scanner.nextLine();
                        contato.setNome(dado);
                        break;
                    case 2:
                        System.out.println("Novo telefone:");
                        dado = scanner.nextLine();
                        contato.setTelefone(dado);
                        break;
                    case 3:
                        System.out.println("Novo celular:");
                        dado = scanner.nextLine();
                        contato.setCelular(dado);
                        break;
                    case 4:
                        System.out.println("Novo Email:");
                        dado = scanner.nextLine();
                        contato.setEmail(dado);
                        break;
                    case 5:
                        System.out.println("Novo telefone2:");
                        dado = scanner.nextLine();
                        contato.setTelefone2(dado);
                        break;
                    case 6:
                        System.out.println("Novo celular2:");
                        dado = scanner.nextLine();
                        contato.setCelular2(dado);
                        break;
                    default:
                        System.out.println("Opcão inválida");
                }
            }
            //contato.setEmail("maycon@emailteste.com");
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exclui() {
        try {
            System.out.println("Excluindo contato");
            Contato contato = new Contato(5);
            contato.exclui();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
