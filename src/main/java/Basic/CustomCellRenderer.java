package Basic;

import javax.swing.*;
import java.awt.*;

public class CustomCellRenderer extends JPanel implements ListCellRenderer<Word> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Word> list, Word value, int index, boolean isSelected, boolean cellHasFocus) {
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        if(value == null){
            return null;
        }

        JLabel name = new JLabel();

        name.setText(value.getWord_target());

        if(isSelected){
            this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
            name.setForeground(Color.RED);
        }

        this.setBackground(new Color(100,100,100,123));

        return name;
    }
}
