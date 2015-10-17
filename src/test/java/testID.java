import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class testID {

	@Test
	public void test() {
		
		int id = 1306;
		int false_id = 1306;
		File profPic = new File("img01.jpg");	
		Account yanuar = new Account(1306, "yanuar", "123", "44312", 123.345, 987.654, profPic);
		
		assertEquals(yanuar.getAccount_id(), false_id);
	}

}
