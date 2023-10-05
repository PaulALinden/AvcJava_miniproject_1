package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time extends AbstractDateTime {

    public Time(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {

        if (state == DateTimeState.DISPLAY_TIME) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            return "Time: " + value.format(timeFormatter);
        } else {
            return "Invalid state for Time";
        }
    }

    @Override
    public void change(LocalDateTime newValue) {
        if (state == DateTimeState.CHANGE_TIME) {
            this.value = newValue;
            System.out.println(value);
        } else {
            System.out.println("Error when setting time");
        }
    }
}
