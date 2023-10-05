package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date extends AbstractDateTime {
    public Date(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        return "Date: " + value.format(timeFormatter);
    }

    @Override
    public void change(LocalDateTime newValue) {

        LocalTime timeComponent = value.toLocalTime();
        LocalDate newDateComponent = newValue.toLocalDate();

        value = newDateComponent.atTime(timeComponent);
    }
}
