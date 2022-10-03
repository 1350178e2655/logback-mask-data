package me.chrisanabo.logback;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaskingPatternLayoutExample {

    private static final Logger logger = LoggerFactory.getLogger(MaskingPatternLayoutExample.class);

    public static void main(String[] args) {

        logger.error("email:{}|password:{}|account:{}", "email@email.com", "password",
                "account_number", new Exception("something went wrong password:p123,email:" + "email@mailcom" + "|password:\"password123,userId:A34444"));


        Map<String, String> user = new HashMap<String, String>();
                            user.put("user_id", "87656");
                            user.put("SSN", "786445563");
                            user.put("address", "22 Street");
                            user.put("city", "Chicago");
                            user.put("Country", "U.S.");
                            user.put("ip_address", "192.168.1.1");
                            user.put("email_id", "spring@baeldung.com");
                            JSONObject userDetails = new JSONObject(user);
                            logger.info("userDetails:{}", userDetails);


        Map<String,Map<String,String>> level2 = new HashMap<>();
                                        level2.put("level2", user);
                                        level2.put("level3", user);

        JSONObject level2Details = new JSONObject(level2);

        logger.info("level2 userDetails:{}",  level2Details);
        //logger.info("\"email\":{},\"password\":{},\"account\":{}", "\"robbins@email.com\"","\"password\"","\"X1234567\"");

        logger.info("email:{}|password:{}|account:{}","a.emailcom", "pas,s123", "Acc123");

        String npe =  null;
        logger.info("npe:{}", npe.substring(1, 100));



    }
}
