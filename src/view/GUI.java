package view;

import controller.UserInputController;
import model.DateTimeState;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public JTextField textField;
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
        textField.setEditable(false);

        for (DateTimeState action : DateTimeState.values()) {
            JButton button = new JButton(action.name());
            button.addActionListener(e -> handleButtonClick(action));
            buttonPanel.add(button);
        }
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        frame.add(textField, constraints);
        constraints.gridy = 0;
        frame.add(buttonPanel, constraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void handleButtonClick(DateTimeState action) {
        String result = user.handelUserInput(String.valueOf(action));
        textField.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}

