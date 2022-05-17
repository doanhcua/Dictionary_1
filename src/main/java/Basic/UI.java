package Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class UI extends JFrame {

    private JPanel mainPanel;
    // TODO: place custom component creation code here
    private JList list1;
    private JTextField word_target_field;
    private JLabel word;
    private JLabel meaning;
    private JPanel text;
    private JScrollPane scrollpane;
    private JButton insertWordButton;
    private JButton deleteWordButton;

    public UI(JScrollPane scrollpane){
        super("English - Vietnamese dictionary");
        this.scrollpane = scrollpane;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        //this.setResizable(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DictionaryCommandline.DicManagement.dictionaryExportToFile();
                super.windowClosing(e);
            }
        });

        text.setBackground(new Color(0,0,0,0));

        meaning.setBackground(Color.GRAY);
        word.setBackground(Color.GRAY);

        list1.setListData(Dictionary.listWord.toArray());
        word_target_field.addActionListener(e -> {
            if(word_target_field.getText().isEmpty()){
                list1.setListData(Dictionary.listWord.toArray());
            }else {
                List<Word> temp =  Dictionary.listWord;
                list1.setListData( temp.stream().filter(word -> {
                    if (word.getWord_target().length() < word_target_field.getText().length()) return false;
                    return word.getWord_target().contains(word_target_field.getText());
                }).toList().toArray());
            }
        });
        list1.setCellRenderer(new CustomCellRenderer());
        list1.addListSelectionListener(e -> {
            Word w = (Word) list1.getSelectedValue();
            if(w == null) return;
            word.setText(w.getWord_target());
            meaning.setText(w.getWord_explain());
        });
        insertWordButton.addActionListener(e -> {
            JFrame insert = new Insert();
            insert.setVisible(true);
        });
        deleteWordButton.addActionListener(e -> {
            JFrame insert = new Delete();
            insert.setVisible(true);
        });
    }

    private void createUIComponents()  {
        try {
            mainPanel = new CustomPanel("background.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
