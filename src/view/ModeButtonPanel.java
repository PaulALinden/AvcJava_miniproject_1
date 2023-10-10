package view;

import controller.MainController;
import model.DateTimeMode;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModeButtonPanel extends JPanel {

    private final MainController mainController;
    private final JTextField textField;

    public ModeButtonPanel(MainController timeController, JTextField textField) {
        this.mainController = timeController;
        this.textField = textField;

        for (DateTimeMode action : DateTimeMode.values()) {
            JButton button = new JButton(action.name());
            button.addActionListener(e -> handleButtonClick(action));
            add(button);
        }
    }

    private void handleButtonClick(DateTimeMode mode) {
        String result = mainController.handelUserAction(String.valueOf(mode));
        if (mode == DateTimeMode.CHANGE_TIME && result.equals("true")) {
            String newTime = getUserTime();
            mainController.getTimeController().changeTime(newTime);
        } else if (mode == DateTimeMode.CHANGE_DATE && result.equals("true")) {
            String newDate = getUserDate();
            mainController.getDateController().changeDate(newDate);
        }
        textField.setText(result);
    }

    private String getUserTime() {

        return (String) JOptionPane.showInputDialog(null, "Enter new time (HH:mm:ss):", "Change Time", JOptionPane.QUESTION_MESSAGE, null, null, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    private String getUserDate() {
        return (String) JOptionPane.showInputDialog(null, "Enter new date (yyyy-MM-dd):", // Prompt for a new date
                "Change Date", JOptionPane.QUESTION_MESSAGE, null, null, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}

