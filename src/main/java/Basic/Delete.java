package Basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Delete extends JFrame {
    private JTextField word_target_field;
    private JButton deleteButton;
    private JPanel mainPanel;
    private JFrame parent;

    public Delete(JFrame parent) {
        super("Delete");
        this.parent = parent;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!word_target_field.getText().isEmpty()){
                    String target = word_target_field.getText();
                    for (int i = 0; i < Dictionary.listWord.size(); i++) {
                        if (Dictionary.listWord.get(i).getWord_target().equals(target)) {
                            Dictionary.listWord.remove(i);
                            break;
                        }
                    }
                }
                setVisible(false);
                dispose();
            }
        });
    }
}
