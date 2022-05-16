package Basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Insert extends JFrame {
    private JTextField word_target_field;
    private JTextField word_meaning_field;
    private JPanel mainPanel;
    private JButton insertButton;
    private JFrame parent;

    public Insert(JFrame parent){
        super("Insert");
        this.parent = parent;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target = word_target_field.getText();
                boolean check = false;
                if(!(word_meaning_field.getText().isEmpty() || word_target_field.getText().isEmpty())){
                    if(!Dictionary.listWord.stream().anyMatch(new Predicate<Word>() {
                        @Override
                        public boolean test(Word word) {
                            return word.getWord_target() == target;
                        }
                    })){
                        String explain = word_meaning_field.getText();
                        Dictionary.listWord.add(new Word(target, explain));
                        Dictionary.listWord = Dictionary.listWord.stream().sorted().collect(Collectors.toList());
                    }
                }
                setVisible(false);
                dispose();
            }
        });
    }
}
