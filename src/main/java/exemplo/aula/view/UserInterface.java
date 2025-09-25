package exemplo.aula.view;

import exemplo.aula.model.User;

import java.util.Scanner;

public class UserInterface {

    static Scanner input = new Scanner(System.in);

    public static User registerUser(){
        System.out.print("Insira o nome do usuário: ");
        String nome = input.nextLine();
        System.out.print("Insira o email do usuário: ");
        String email = input.nextLine();
        return (new User(nome, email));
    }

    public static String updateUser(){
        System.out.print("Insira o novo email do usuário: ");
        return input.nextLine();
    }
}
