package me.chrisanabo.logback;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        String text = "Fred Anna Alexander";
        Pattern pattern = Pattern.compile("A.+a"); // words start with A until small letter a will be captured
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }


        text = "christopher:hello";
         pattern = Pattern.compile(":.+o"); // // words start with : until small letter o will be captured
         matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }


        text = "msgT:{hello}{'chris'}}";
        pattern = Pattern.compile("\\{([^}]*.?)\\}"); // starts with { and end with }
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }

 //  \"SSN\"\s*:\s*\"(.*?)\"

        text = "msgType:camt.051";
        pattern = Pattern.compile("msgType\\s*:\\s*(.*?)"); //
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }

        // \"SSN\"\s*:\s*\"(.*?)\"

        Map<String, String> user = new HashMap<String, String>();
        user.put("user_id", "87656");
        user.put("SSN", "786445563");
        user.put("address", "22 Street");
        user.put("city", "Chicago");
        user.put("Country", "U.S.");
        user.put("ip_address", "192.168.1.1");
        user.put("email_id", "spring@baeldung.com");
        JSONObject userDetails = new JSONObject(user);


       // StringBuilder ssn = new StringBuilder("" + userDetails);

        StringBuilder ssn = new StringBuilder("\"SSN\":\"christopher\"");

        pattern = Pattern.compile("\\\"SSN\\\"\\s*:\\s*\\\"(.*?)\\\""); //

       Matcher matchers = pattern.matcher(ssn);

        System.out.println("sssss");
       while (matchers.find()) {
            IntStream.rangeClosed(1, matchers.groupCount()).forEach(group -> {
                if (matchers.group(group) != null) {
                    // replace each character with asterisk
                    IntStream.range(matchers.start(group), matchers.end(group)).forEach(i -> ssn.setCharAt(i, '*'));
                }
            });
        }

        System.out.println("ssn:" + ssn.toString());



//        StringBuilder ssnNoQuote = new StringBuilder("SSN:\"christopher\"");
  //      pattern = Pattern.compile("\\SSN\\.*\\s*:\\s*\\\"(.*?)\\\""); //


//        StringBuilder ssnNoQuote = new StringBuilder("SSN:\"christopher\",email:christopher");
//        pattern = Pattern.compile("\\SSN\\.*:\\s*\\\"(.*?)\\\""); //

//        StringBuilder ssnNoQuote = new StringBuilder("SSN:christopher,email:christopher");
//        pattern = Pattern.compile("\\SSN\\.*:\\s*(.*,)"); // SSN:************email:christopher


//        StringBuilder ssnNoQuote = new StringBuilder("SSN:christopher,email:christopher");
//        pattern = Pattern.compile("\\.*email\\.*:\\s*(.*)"); // SSN:christopher,email:***********


//        StringBuilder ssnNoQuote = new StringBuilder("SSN:christopher,email:christopher");
//        pattern = Pattern.compile("\\.*\\.*:\\s*(.*,)"); // ************email:christopher



//        StringBuilder ssnNoQuote = new StringBuilder("SSN:christopher,email:christopher,password:abcdefg");
//        pattern = Pattern.compile("\\.*email\\.*:\\s*(.*,)|\\.*password\\.*:\\s*(.*)"); // ssnNoQuote:SSN:christopher,email:************password:*******


          StringBuilder ssnNoQuote = new StringBuilder("SSN:christopher,email:christopher,password:abc");
          pattern = Pattern.compile("SSN:\\s*"); // ssnNoQuote:SSN:christopher,email:************password:*******

        Matcher matchersNoQuote = pattern.matcher(ssnNoQuote);
        while (matchersNoQuote.find()) {

            IntStream.rangeClosed(1, matchersNoQuote.groupCount()).forEach(group -> {
                if (matchersNoQuote.group(group) != null) {
                          IntStream.range(matchersNoQuote.start(group), matchersNoQuote.end(group))
                            .forEach(
                                    i -> ssnNoQuote.setCharAt(i, '*')
                            );
                }
            });
        }

        System.out.println("ssnNoQuote:" + ssnNoQuote.toString());
        pattern = Pattern.compile("email\\s*:\\s*(.*?)"); // ssnNoQuote:SSN:christopher,email:************password:*******

     //   "\"SSN\"\s*:\s*\"(.*?)\""


        Matcher matchersNoQuote2 = pattern.matcher(ssnNoQuote);
        while (matchersNoQuote2.find()) {

            IntStream.rangeClosed(1, matchersNoQuote2.groupCount()).forEach(group -> {
                if (matchersNoQuote2.group(group) != null) {
                    IntStream.range(matchersNoQuote2.start(group), matchersNoQuote2.end(group))
                            .forEach(
                                    i -> ssnNoQuote.setCharAt(i, '*')
                            );
                    ssnNoQuote.append(",");
                }
            });
        }

        System.out.println("ssnNoQuote:" + ssnNoQuote.toString());


//        String s = "string1, string2, string3";
//        System.out.println(s.replaceAll("string(?:1|2)", "blah"));


    }

}
