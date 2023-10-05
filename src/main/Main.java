package main;

import controller.UserInputController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserInputController userInputController = new UserInputController();

        while (true) {
            System.out.println("Write:");
            String a = scanner.nextLine();
            if (a.equals("q")){return;}

            userInputController.handelUserInput(a);
        }
    }
}
