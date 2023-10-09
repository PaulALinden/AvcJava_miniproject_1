package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI(MainController controller) {
        JFrame frame = new JFrame("User Input GUI");
        Dimension dimension = new Dimension(1200, 600);
        frame.setPreferredSize(dimension);

        JTextField dateTimeDisplayField = new DateTimeDisplay(controller);
        JPanel buttonPanel = new ModeButtonPanel(controller, dateTimeDisplayField);

        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        constraints.gridy = 1;
        frame.add(dateTimeDisplayField, constraints);

        constraints.gridy = 2;
        frame.add(buttonPanel, constraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

