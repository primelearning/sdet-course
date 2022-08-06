package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JsonUtil {

    private JsonUtil(){}
    private static Logger log = LogManager.getLogger(JsonUtil.class);

    public static Document updateValue(String jsonFilePath,String key, Object value) {
        Document jsonDocument;
        try {
            jsonDocument = Document.parse(
                    Files.readString(Path.of(jsonFilePath)).replace( key, (CharSequence) value));

            log.info("Updated JSON {} with value {}",key,value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(jsonDocument);
        return jsonDocument;
    }
    public static Document updateValue(Document document,String key, Object value) {
        log.info("Updated JSON {} with value {}",key,value);
        return document;
    }


}
