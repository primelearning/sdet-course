package apiutils;

import org.apache.commons.io.output.WriterOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Objects;

public class ApiLogger {
    private ApiLogger(){}


    private static Logger log = LogManager.getLogger(ApiLogger.class);
    public static StringWriter writer;
    public static PrintStream getPrintStream(){
        if(Objects.isNull(writer)){
            writer = new StringWriter();
            log.info("Printstream is created.");
        }
        return  new PrintStream(new PrintStream(new WriterOutputStream(writer, Charset.defaultCharset()),true));
    }

}
