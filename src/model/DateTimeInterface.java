package model;

import java.time.LocalDateTime;

public interface DateTimeInterface {
    String display();

    void change(LocalDateTime newValue);
}
