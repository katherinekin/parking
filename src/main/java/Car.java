import java.time.LocalDateTime;

public class Car {
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private String license;
    public void setEnterTime(LocalDateTime time) {
        this.enterTime = time;
    }
    public void setExitTime(LocalDateTime time) {
        this.exitTime = time;
    }
    public LocalDateTime getEnterTime() {
        return enterTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
