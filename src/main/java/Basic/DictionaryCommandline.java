package Basic;

import java.util.Scanner;

public class DictionaryCommandline {
    public static void main(String[] args) {
        DictionaryManagement DicManagement = new DictionaryManagement();
        Scanner scan = new Scanner(System.in);
        DicManagement.insertFromFile();

        int op ;

        do {
            System.out.println("");
            System.out.println("--------- Welcome to English - Vietnamese dictionary ----------");
            System.out.println("1. Searcher ");
            System.out.println("2. Look up ");
            System.out.println("3. Insert word ");
            System.out.println("4. Delete word ");
            System.out.println("5. Show all word ");
            System.out.println("6. End program");
            System.out.println("--------------------------------------------------------------");

            while(!scan.hasNextInt()) {
                System.out.println("Enter option (1 - 6): ");
                scan.next();
            }

            op = scan.nextInt();

            if(op ==1) {
                DicManagement.dictionarySearcher();
            }else if(op ==2) {
                DicManagement.dictionaryLookup();
            }else if(op ==3) {
                DicManagement.insertFromCommandline();
            }else if(op ==4) {
                DicManagement.deleteWordInDictionary();
            }else if(op ==5) {
                DicManagement.showAllWords();
            }else if(op ==6) {
                System.out.println("The program has ended");
                break;
            }

            DicManagement.dictionaryExportToFile();
        } while (op >=1 && op <= 6);
    }
}
