package controller.DateTimeHandlers;

import model.DateTimeManagers.DateTimeBase;
import model.DateTimeMode;

import java.time.LocalDateTime;

public class TimeHandler extends DateTimeHandler {

    DateTimeBase myTime;
    DateTimeBase myDate;

    public TimeHandler(DateTimeBase myTime, DateTimeBase myDate) {
        super(myTime, myDate);
        this.myTime = super.myTime;
        this.myDate = super.myDate;
    }

    @Override
    public String giveInfo() {
        if (myDate.getState() == DateTimeMode.CHANGE_MODE) {
            myTime.setState(DateTimeMode.DISPLAY_TIME);
            return myTime.display();
        } else {
            return "Error in state";
        }
    }

    @Override
    public boolean canChange() {
        return myDate.getState() == DateTimeMode.CHANGE_MODE && myTime.getState() != DateTimeMode.CHANGE_MODE;
    }

    @Override
    public void resetState() {
        myTime.setState(DateTimeMode.CHANGE_MODE);
    }

    public void changeTime(String newTime) {
        String[] parts = newTime.split(":");
        int newHour = Integer.parseInt(parts[0]);
        int newMinute = Integer.parseInt(parts[1]);

        LocalDateTime modifiedDateTime = LocalDateTime.now().withHour(newHour).withMinute(newMinute);

        myTime.change(modifiedDateTime);
    }
}