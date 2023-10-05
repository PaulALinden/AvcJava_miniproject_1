package view;

import controller.UserInputController;
import model.DateTimeState;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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

        //Bryt av till egen
        textField = new JTextField(0);
        textField.setPreferredSize(new Dimension(400, 200));
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setText("CHOOSE MODE");
        textField.setEditable(false);

        //Bryt av till egen
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

        //Bryt av och lägg til vid förändra datum!!!!
        JDatePickerImpl datePicker = getDatePicker();
        frame.add(datePicker);

        constraints.gridy = 2;

        frame.add(buttonPanel, constraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @NotNull
    private JDatePickerImpl getDatePicker() {
        Properties prop = new Properties();
        prop.put("text.today", "Today");
        prop.put("text.month", "Month");
        prop.put("text.year", "Year");

        JFormattedTextField dateTextField = new JFormattedTextField("yyyy-MM-dd");

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
        return getPicker(datePanel, dateTextField, model);
    }

    @NotNull
    private JDatePickerImpl getPicker(JDatePanelImpl datePanel, JFormattedTextField dateTextField, UtilDateModel model) {
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateTextField.getFormatter());

        datePicker.addActionListener(e -> {
            Date selectedDate = model.getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            model.setValue(selectedDate);
            datePicker.getJFormattedTextField().setText(formattedDate);
            calendarListner(formattedDate);
        });
        return datePicker;
    }

    private void handleButtonClick(DateTimeState action) {
        String result = user.handelUserInput(String.valueOf(action));
        textField.setText(result);
    }

    private void calendarListner(String value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}

