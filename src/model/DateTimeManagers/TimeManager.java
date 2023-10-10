package model.DateTimeManagers;

import model.DateTimeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeManager extends DateTimeBase {
    private static TimeManager instance;

    private TimeManager(LocalDateTime value, DateTimeMode state) {
        super(value, state);
    }

    public static TimeManager getInstance() {
        if (instance == null) {
            instance = new TimeManager(LocalDateTime.now(), DateTimeMode.DISPLAY_DATE);
        }
        return instance;
    }

    @Override
    public String display() {
        return value.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public void change(LocalDateTime newValue) {
        LocalTime timeComponent = newValue.toLocalTime();
        LocalDate newDateComponent = value.toLocalDate();

        value = newDateComponent.atTime(timeComponent);
    }
}
