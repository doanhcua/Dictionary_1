package Basic;

import javax.swing.*;
import java.util.Objects;
import java.util.stream.Collectors;

public class Insert extends JFrame {
    private JTextField word_target_field;
    private JTextField word_meaning_field;
    private JPanel mainPanel;
    private JButton insertButton;

    public Insert(){
        super("Insert");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        insertButton.addActionListener(e -> {
            String target = word_target_field.getText();
            if(!(word_meaning_field.getText().isEmpty() || word_target_field.getText().isEmpty())){
                if(Dictionary.listWord.stream().noneMatch(word -> Objects.equals(word.getWord_target(), target))){
                    String explain = word_meaning_field.getText();
                    Dictionary.listWord.add(new Word(target, explain));
                    Dictionary.listWord = Dictionary.listWord.stream().sorted().collect(Collectors.toList());
                }
            }
            setVisible(false);
            dispose();
        });
    }
}
