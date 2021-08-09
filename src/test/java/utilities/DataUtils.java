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
    //This method will remove dollar $ sign from String and will convert it to double-->remove$AndConvert($16.51)->16.51
    public  static  double remove$AndConvert(String amount){
        amount=amount.substring(1);
        return Double.parseDouble(amount);
    }
}
