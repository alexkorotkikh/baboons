package ua.com.sourceit.secretsanta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: alexkorotkikh
 * Date: 1/17/14
 * Time: 6:46 PM
 */
public class App {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        SecretSanta secretSanta = new SecretSanta();
        while (true) {
            try {
                System.out.println(secretSanta.getMenu());
                SecretSantaCommand command = secretSanta.createCommand(input.readLine());
                if (command.isExit()) {
                    break;
                }
                collectInput(input, command);
                command.executeCommand();
                System.out.println(command.getSuccessDescription());
            } catch (Exception e) {
                System.out.println("Problem occurred: " + e.getMessage());
            }
        }
    }

    private static void collectInput(BufferedReader input, SecretSantaCommand command) throws IOException {
        for (String desc : command.getInputDescriptions()) {
            System.out.println(desc);
            command.addInput(input.readLine());
        }
    }
}
