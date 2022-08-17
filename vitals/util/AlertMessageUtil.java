package vitals.util;

import vitals.language.AlertLanguage;
import vitals.language.Messages;

public class AlertMessageUtil {

    public static  void printStatusMessage(String levelText, AlertLanguage alertLanguage){
        print(Messages.getLocalization(alertLanguage).get(levelText));
    }


    public static void print(String messageText){
        System.out.println(messageText);
    }
}
