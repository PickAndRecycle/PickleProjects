import java.io.File;
import java.sql.Time;

/**
 * Created by Yanuar Wicaksana on 10/15/15.
 */
public class OtherWaste extends Trash{
    int size;
    public OtherWaste(int id, String description, int status, File photo, Double latitude, Double longitude, Time timestamp,
                      boolean report, int size){
        super(id, description, status, photo, latitude, longitude, timestamp, report );
        this.size = size;

    }
}
