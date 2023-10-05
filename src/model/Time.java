package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time extends AbstractDateTime {

    public Time(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
            return "Time: " + value.format(timeFormatter);
    }
    @Override
    public void change(LocalDateTime newValue) {
        LocalTime timeComponent = newValue.toLocalTime();
        LocalDate newDateComponent = value.toLocalDate();

        value = newDateComponent.atTime(timeComponent);
    }
}
