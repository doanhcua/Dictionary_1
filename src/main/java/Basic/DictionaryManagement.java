package Basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryManagement {
    private final Scanner scan = new Scanner(System.in);
    private static final String fileName = "dictionaries.txt";

    //FUNCTION showAllWords
    public void showAllWords() {
        if (!Dictionary.listWord.isEmpty()) {
            System.out.printf("No", '|', "English", '|', "Vietnamese");
            for(int i = 0; i < Dictionary.listWord.size(); i++){
                System.out.printf("%-5d", i + 1);
                Dictionary.listWord.get(i).printWord();
            }
        } else {
            System.out.println("Dictionary is empty !");
        }
    }
    // FUNCTION insertFromCommandline
    public void insertFromCommandline() {
        System.out.println("------------------ Add word to dictionary --------------------");
        System.out.println("Word target");
        String target = scan.nextLine();
        boolean check = false;
        for (Word elemt : Dictionary.listWord) {
            if (elemt.getWord_target().equals(target.trim())) {
                System.out.println( target + "  has already been in the dictionary ");
                check = true;
                break;
            }
        }
        if(check == false) {
            System.out.print("Word explain: ");
            String explain = scan.nextLine();
            Dictionary.listWord.add(new Word(target, explain));
        }
    }
    //FUNCTION dictionaryLookup
    public void dictionaryLookup() {
        System.out.println("-------------------------- LOOK UP ---------------------------");
        System.out.print("Word: ");
        String wordLookup = scan.nextLine();
        for (Word elemt : Dictionary.listWord) {
            if (elemt.getWord_target().equals(wordLookup)) {
//                System.out.println("Lookup Success !");
                elemt.printWord();
                return;
            }
        }
        System.out.println("Word Not Found ! ");
    }
    // FUNCTION dictionarySearcher
    public void dictionarySearcher() {
        System.out.println("------------------------ SEARCHER ----------------------------");
        System.out.print("Enter word: ");
        String key = scan.nextLine();
        ArrayList<Word> listWordSearcher = new ArrayList<>();
        for (Word elemt : Dictionary.listWord) {
            if (elemt.getWord_target().startsWith(key)) {
                listWordSearcher.add(elemt);
            }
        }
        if (listWordSearcher.isEmpty()) {
            System.out.println("Word Not Found !");
        } else {
            System.out.println("Words start with: " + key );
            int i = 1;
            for (Word elemt: listWordSearcher) {
                System.out.printf("%-4d", i);
                elemt.printWord();
                i++;
            }
        }
    }

    // FUNCTION deleteWordInDictionary
    public void deleteWordInDictionary() {
        System.out.println("-----------------------DELETE WORD----------------------------");
        System.out.println("Enter word want delete: ");
        String del = scan.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_target().equals(del)) {
                System.out.println(del + ":word found in dictionary !");

                Dictionary.listWord.remove(i);
                System.out.println("Delete success !!!");
                return;
            }
        }
        System.out.println("Word Not Found !");
    }
    //FUNCTION insertFromFile
    public void insertFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();;
            while (line != null) {
                if (!line.contains("\t")) {
                    line = br.readLine();
                    continue;
                }
                String tag = line.substring(0, line.indexOf("\t"));
                String exp= line.substring(line.indexOf("\t") + 1);
                Word w = new Word(tag, exp);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
    // FUNCTION dictionaryExportToFile
    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_target() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
}
