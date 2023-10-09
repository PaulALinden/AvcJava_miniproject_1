package model.DateTimeManagers;

import model.DateTimeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateManager extends DateTimeBase {
    public DateManager(LocalDateTime value, DateTimeMode state) {
        super(value, state);
    }

    @Override
    public String display() {
        return value.format(DateTimeFormatter.ofPattern("yyyy MMMd"));
    }

    @Override
    public void change(LocalDateTime newValue) {

        LocalTime timeComponent = value.toLocalTime();
        LocalDate newDateComponent = newValue.toLocalDate();

        value = newDateComponent.atTime(timeComponent);
    }
}
