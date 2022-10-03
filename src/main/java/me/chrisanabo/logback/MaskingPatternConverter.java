package me.chrisanabo.logback;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaskingPatternConverter extends MessageConverter {

    public String convert(ILoggingEvent event) {
        return enhance(super.convert(event));
    }


    private String enhance(String incoming) {
//  "\\s*,\\s*"
        Stream<String> stream = Arrays.stream(incoming.split( "\\|"  ));

        String enhanceMessage =  stream.map(value ->{
                    if(value.startsWith("{") || value.startsWith("\"") || value.indexOf("{") !=-1 ){
                        return value;
                    } else {
                      //  return "\"" + value.split(":")[0] + "\":\"" + value.split(":")[1] + "\"";
                       return  value.split(":")[0] + ":\"" + value.split(":")[1] + "\"";
                     //   return  value.split(":")[0] + ":\"" + value.split(":")[1] + "";
                    }
                }

        ).collect(Collectors.joining(
                ","));

        return  enhanceMessage;
    }

}
