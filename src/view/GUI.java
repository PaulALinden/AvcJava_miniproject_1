package view;

import controller.UserInputController;
import model.DateTimeState;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public JTextField textField;
    public JTextField dateTimeField;
    public UserInputController user;

    public GUI() {
        JFrame frame;
        JPanel buttonPanel;

        frame = new JFrame("User Input GUI");
        Dimension Dimension = new Dimension(1200, 600);

        frame.setPreferredSize(Dimension);
        buttonPanel = new JPanel();
        user = new UserInputController();

        textField = new JTextField(0);
        textField.setPreferredSize(new Dimension(400, 200));
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setText("CHOOSE MODE");
        textField.setEditable(false);

        dateTimeField = new JTextField(0);
        dateTimeField.setPreferredSize(new Dimension(500, 200));
        dateTimeField.setFont(new Font("Arial", Font.PLAIN, 30));
        dateTimeField.setHorizontalAlignment(JTextField.CENTER);
        dateTimeField.setText(user.showFullTime());
        dateTimeField.setEditable(false);

        for (DateTimeState action : DateTimeState.values()) {
            JButton button = new JButton(action.name());
            button.addActionListener(e -> handleButtonClick(action));
            buttonPanel.add(button);
        }
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        frame.add(buttonPanel, constraints);

        constraints.gridy = 1;
        frame.add(textField, constraints);

        constraints.gridy = 2;
        frame.add(dateTimeField);

        frame.add(buttonPanel, constraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void handleButtonClick(DateTimeState action) {
        String result = user.handelUserInput(String.valueOf(action));
        textField.setText(result);
        dateTimeField.setText(user.showFullTime());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}

