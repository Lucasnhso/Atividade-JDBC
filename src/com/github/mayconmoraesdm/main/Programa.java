package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.entidades.Contato;
import com.github.mayconmoraesdm.entidades.Entidade;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu();

    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcao, idBusca, continua;
        String nomeBusca;
        System.out.println("Digite: \n1: Inserir \n2: Alterar \n3: Excluir \n4: Listar todos \n5:Listar por id\n6:Listar por nome");
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
                    System.out.println("Digite o id do registro desejado:");
                    idBusca = scanner.nextInt();
                    lista(idBusca);
                case 6:
                    System.out.println("Digite o nome desejado:");
                    nomeBusca = scanner.nextLine();
                    listaNome(nomeBusca);
                default:
                    System.out.println("Opção invalida");
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


    public static void lista(Integer id) {
        System.out.println("Lista um contato por id");
        Contato c = new Contato(id);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\nTelefone2: %s\nCelular2: %s",
                c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getTelefone2(), c.getCelular2()));
    }

    public static void listaNome(String nome) {
        System.out.println("Lista um contato por nome");
        Contato c = new Contato(nome);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\nTelefone2: %s\nCelular2: %s",
                c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getTelefone2(), c.getCelular2()));
    }

    public static void insere() {
        System.out.println("Inserindo contato");
        try {
            Contato contato = new Contato();
            contato.setNome("Maycon de Moraes");
            contato.setTelefone("32657845");
            contato.setCelular("98651278");
            contato.setTelefone2("");
            contato.setCelular2("");
            contato.insere();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void altera() {
        try {
            System.out.println("Alterando contato");
            Contato contato = new Contato(2);
            contato.setEmail("maycon@emailteste.com");
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exclui() {
        try {
            System.out.println("Excluindo contato");
            Contato contato = new Contato(2);
            contato.exclui();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
