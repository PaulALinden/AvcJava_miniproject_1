package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date extends AbstractDateTime {
    public Date(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return "Date: " + value.format(dateFormatter);
    }

    @Override
    public void change(LocalDateTime newValue) {
            this.value = newValue;
    }
}
