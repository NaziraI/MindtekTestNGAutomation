package utilities;

import java.util.Random;

public class DataUtils {
    /*
    This method will generate random email.
    Ex:
    .generateEmail();-->return "abc123@gmail.com
     */
    public static String generateEmail() {
        Random random = new Random();
        int emailId = random.nextInt(100000);
        String email = "nzr" + emailId + "@gmail.com";
        return email;
    }

    public static int generateNumber(int range) {
        Random random = new Random();
        int randomNum = random.nextInt(range);
        return randomNum;

    }
}
