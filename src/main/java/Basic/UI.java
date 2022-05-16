package Basic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public UI(){
        super("English - Vietnamese dictionary");
        JFrame t = this;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

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
        word_target_field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(word_target_field.getText().isEmpty()){
                    list1.setListData(Dictionary.listWord.toArray());
                }else {
                    List<Word> temp =  Dictionary.listWord;
                    list1.setListData( temp.stream().filter(new Predicate<Word>() {
                        @Override
                        public boolean test(Word word) {
                            if(word.getWord_target().length() < word_target_field.getText().length()) return false;
                            if(word.getWord_target().contains(word_target_field.getText())) return true;
                            return false;
                        }
                    }).collect(Collectors.toList()).toArray());
                }
            }
        });
        list1.setCellRenderer(new CustomCellRenderer());
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Word w = (Word) list1.getSelectedValue();
                if(w == null) return;
                word.setText(w.getWord_target());
                meaning.setText(w.getWord_explain());
            }
        });
        insertWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = new Insert(t);
                insert.setVisible(true);
            }
        });
        deleteWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insert = new Delete(t);
                insert.setVisible(true);
            }
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
