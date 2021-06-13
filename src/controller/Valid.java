package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    public  boolean validate(String regex,String propeties ){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(propeties);
        return matcher.matches();
    }
}
