package model.DateTimeManagers;

import model.DateTimeInterface;
import model.DateTimeMode;

import java.time.LocalDateTime;

public abstract class DateTimeBase implements DateTimeInterface {

    static LocalDateTime value;
    protected DateTimeMode state;
    public DateTimeBase(LocalDateTime value, DateTimeMode state) {
        this.state = state;
        DateTimeBase.value = value;
    }

    public static LocalDateTime getValue() {
        return value;
    }
    public static void setValue(LocalDateTime value) {
        DateTimeBase.value = value;
    }

    public DateTimeMode getState() {
        return state;
    }
    public void setState(DateTimeMode state) {
        this.state = state;
    }

}
