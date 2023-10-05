package model;

import java.time.LocalDateTime;

public abstract class AbstractDateTime implements DateTimeInterface {

    protected LocalDateTime value;
    protected DateTimeState state;
    public AbstractDateTime(LocalDateTime value, DateTimeState state) {
        this.state = state;
        this.value = value;
    }

    public DateTimeState getState() {
        return state;
    }

    public void setState(DateTimeState state) {
        this.state = state;
    }

    @Override
    public abstract String display();
    @Override
    public abstract void change(LocalDateTime newValue);
}
