package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time extends AbstractDateTime {

    public Time(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            return "Time: " + value.format(timeFormatter);
    }

    @Override
    public void change(LocalDateTime newValue) {
            this.value = newValue;
    }
}
