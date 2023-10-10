package model.DateTimeManagers;

import model.DateTimeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateManager extends DateTimeBase {
    private static DateManager instance;

    private DateManager(LocalDateTime value, DateTimeMode state) {
        super(value, state);
    }

    public static DateManager getInstance() {
        if (instance == null) {
            instance = new DateManager(LocalDateTime.now(), DateTimeMode.CHANGE_MODE);
        }
        return instance;
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
