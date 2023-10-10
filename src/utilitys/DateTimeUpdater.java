package utilitys;

import model.DateTimeManagers.DateTimeBase;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DateTimeUpdater {

    public static void startUpdatingValue() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            LocalDateTime newValue = DateTimeBase.getValue().plusSeconds(1);
            DateTimeBase.setValue(newValue);
            System.out.println(DateTimeBase.getValue());
        }, 0, 1, TimeUnit.SECONDS);
    }
}
