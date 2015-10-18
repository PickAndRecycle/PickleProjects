
import java.io.File;
import java.util.*;

public class Account {
    int account_id;
    String username, password, phone_number;
    Double latitude, longitude;
    File profile_picture;

    public Account(int account_id, String username, String password, String phone_number, File profile_picture){
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.profile_picture = profile_picture;
    }
    
    public int getAccount_id(){
        return account_id;
    }

    public void test(){
        System.out.print("tests");
    }
}
