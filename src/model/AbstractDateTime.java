package model;

import java.time.LocalDateTime;

public abstract class AbstractDateTime implements DateTimeInterface {

    static LocalDateTime value;
    protected DateTimeState state;
    public AbstractDateTime(LocalDateTime value, DateTimeState state) {
        this.state = state;
        AbstractDateTime.value = value;
    }

    public DateTimeState getState() {
        return state;
    }
    public void setState(DateTimeState state) {
        this.state = state;
    }
}
