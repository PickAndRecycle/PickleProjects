/**
 * Created by Yanuar Wicaksana on 10/15/15.
 */
import java.io.File;
import java.sql.Time;
import java.util.*;


public class UnusedGoods extends Trash {
    String title, condition;

    public UnusedGoods(int id, String description, int status, File photo, Double latitude, Double longitude, Time timestamp,
                       boolean report, String title, String condition) {
        super(id, description, status, photo, latitude, longitude, timestamp, report);
        this.title = title;
        this.condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
