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
