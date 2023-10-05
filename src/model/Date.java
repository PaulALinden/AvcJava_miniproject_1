package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date extends AbstractDateTime{
    public Date(LocalDateTime value, DateTimeState state) {
        super(value, state);
    }

    @Override
    public String display() {
        if(state == DateTimeState.DISPLAY_DATE) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return "Date: " + value.format(dateFormatter);
        }
        else {
            return "Invalid state of Date";
        }
    }
    @Override
    public void change(LocalDateTime newValue) {
        if (state == DateTimeState.CHANGE_DATE) {
            this.value = newValue;
        }else {
            System.out.println("Error when setting time");
        }
    }
}
