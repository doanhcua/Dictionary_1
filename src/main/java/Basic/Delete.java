package Basic;

import javax.swing.*;

public class Delete extends JFrame {
    private JTextField word_target_field;
    private JButton deleteButton;
    private JPanel mainPanel;

    public Delete() {
        super("Delete");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        deleteButton.addActionListener(e -> {
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
        });
    }
}
