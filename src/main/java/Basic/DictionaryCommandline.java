package Basic;

import javax.swing.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DictionaryCommandline {
    public static DictionaryManagement DicManagement;

    public static void main(String[] args) {
        DicManagement = new DictionaryManagement();
        Scanner scan = new Scanner(System.in);
        DicManagement.insertFromFile();

        Dictionary.listWord =  Dictionary.listWord.stream().sorted().collect(Collectors.toList());

        JScrollPane scrollpane = null;
        JFrame ui = new UI(scrollpane);

        ui.setVisible(true);

        int op ;

        do {
            System.out.println();
            System.out.println("--------- Welcome to English - Vietnamese dictionary ----------");
            System.out.println("1. Show all word ");
            System.out.println("2. End program");
            System.out.println("--------------------------------------------------------------");

            while(!scan.hasNextInt()) {
                System.out.println("Enter option (1 - 2): ");
                scan.next();
            }

            op = scan.nextInt();

            if(op ==1) {
                DicManagement.showAllWords();
            }else if(op ==2) {
                System.out.println("The program has ended");
                break;
            }


        } while (op >=1 && op <= 2);

        DicManagement.dictionaryExportToFile();

        ui.setVisible(false);
        ui.dispose();

    }
}
