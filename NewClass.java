/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ELCOT
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // Get the path of the file from the user.
        System.out.println("Enter the path of the text file:");
        String path = scanner.nextLine();

        System.out.println("Enter the word to be replaced (word1):");
        String word1 = scanner.nextLine();

        System.out.println("Enter the new word (word2):");
        String word2 = scanner.nextLine();

        StringBuilder content = new StringBuilder();

        // Read the file and replace word1 with word2.
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll(word1, word2)).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file.");
            e.printStackTrace();
        }

        // Write the updated content back to the file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Error writing to the file.");
            e.printStackTrace();
        }

        System.out.println("Replacement completed!");
    }
}
