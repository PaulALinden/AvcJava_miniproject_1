package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

public class DateTimeDisplay extends JTextField {

    protected DateTimeDisplay(MainController controller) {
        super(0);
        setPreferredSize(new Dimension(400, 200));
        setFont(new Font("Arial", Font.PLAIN, 30));
        setHorizontalAlignment(JTextField.CENTER);
        setText(controller.initClock());
        setEditable(false);
    }
}
