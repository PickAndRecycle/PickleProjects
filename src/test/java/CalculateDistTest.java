import org.junit.Test;

import java.sql.Time;
import java.util.*;
import java.lang.*;
import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Yanuar Wicaksana on 10/16/15.
 */
public class CalculateDistTest {

    @Test
    public void testCalculateDist() throws Exception {
        int rad = 6371;
        Double currentlon = -6.364561;
        Double currentlat = 106.828679;
        File file = null;
        Time time = new Time(12313);

        Trash trash = new Trash(1,"trash",2,file,106.828679,-6.364561,time,false);
        trash.setLatitude(106.828679);
        trash.setLongitude(-6.364561);
        int result = trash.CalculateDist(currentlon,currentlat);

        assertEquals(result,0);

    }
}