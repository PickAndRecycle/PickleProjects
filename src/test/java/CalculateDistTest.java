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
        Double currentlon = 106.78314;
        Double currentlat = -6.265633;
        File file = null;
        Time time = new Time(12313);

        Trash trash = new Trash(1,"trash",2,file,106.828679,-6.364561,time,false);
        trash.setLatitude(-6.368737);
        trash.setLongitude(106.906586);
        int result = trash.CalculateDist(currentlat,currentlon);

        //This test was based on real life location from Cibubur to Pondok Indah
        assertEquals(result,17);

    }
}