package controller.DateTimeHandlers;

import model.DateTimeManagers.DateTimeBase;

public abstract class DateTimeHandler {
    protected DateTimeBase myTime;
    protected DateTimeBase myDate ;

    public DateTimeHandler(DateTimeBase myTime, DateTimeBase myDate) {
        this.myTime = myTime;
        this.myDate = myDate;
    }

    public abstract String giveInfo();

    public abstract boolean canChange();

    public abstract void resetState();
}

