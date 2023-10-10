package controller.DateTimeHandlers;

import model.DateTimeManagers.DateTimeBase;
import model.DateTimeMode;

import java.time.LocalDateTime;

public class DateHandler extends DateTimeHandler {

    final private DateTimeBase myTime;
    final private DateTimeBase myDate;

    public DateHandler(DateTimeBase myTime, DateTimeBase myDate) {
        super(myTime, myDate);
        this.myTime = super.myTime;
        this.myDate = super.myDate;
    }

    @Override
    public String giveInfo() {
        if (myTime.getState() == DateTimeMode.CHANGE_MODE) {
            myDate.setState(DateTimeMode.DISPLAY_DATE);
            return myDate.display();
        } else {
            return "Please change mode";
        }
    }

    @Override
    public boolean canChange() {
        return myTime.getState() == DateTimeMode.CHANGE_MODE && myDate.getState() != DateTimeMode.CHANGE_MODE;
    }

    @Override
    public void resetState() {
        myDate.setState(DateTimeMode.CHANGE_MODE);
    }

    public void changeDate(String newDate) {
        if (newDate != null) {
            myDate.setState(DateTimeMode.CHANGE_DATE);

            String[] parts = newDate.split("-");
            int newYear = Integer.parseInt(parts[0]);
            int newMonth = Integer.parseInt(parts[1]);
            int newDay = Integer.parseInt(parts[2]);

            LocalDateTime modifiedDateTime = LocalDateTime.now().withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay);

            myDate.change(modifiedDateTime);
        }
    }
}