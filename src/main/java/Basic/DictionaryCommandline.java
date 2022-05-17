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
            System.out.println("1. Look up ");
            System.out.println("2. Insert word ");
            System.out.println("3. Delete word ");
            System.out.println("4. Show all word ");
            System.out.println("5. End program");
            System.out.println("--------------------------------------------------------------");

            while(!scan.hasNextInt()) {
                System.out.println("Enter option (1 - 6): ");
                scan.next();
            }

            op = scan.nextInt();

            if(op ==1) {
                DicManagement.dictionaryLookup();
            }else if(op ==2) {
                DicManagement.insertFromCommandline();
            }else if(op ==3) {
                DicManagement.deleteWordInDictionary();
            }else if(op ==4) {
                DicManagement.showAllWords();
            }else if(op ==5) {
                System.out.println("The program has ended");
                break;
            }


        } while (op >=1 && op <= 5);

        DicManagement.dictionaryExportToFile();

        ui.setVisible(false);
        ui.dispose();

    }
}
