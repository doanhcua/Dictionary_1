package Basic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomPanel extends JPanel {

    final Image backgroundImage;

    public CustomPanel(String path) throws IOException {

        this.backgroundImage = javax.imageio.ImageIO.read(new File(path));

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(backgroundImage,0,0,this.getWidth(),this.getHeight(),null);
    }

}
