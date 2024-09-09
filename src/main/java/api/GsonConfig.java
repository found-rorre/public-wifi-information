package api;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GsonConfig {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Gson createGson() {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                @Override
                public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    String dateTimeString = json.getAsString();
                    // ".0"을 제거한 후 파싱
                    dateTimeString = dateTimeString.replace(".0", "");
                    return LocalDateTime.parse(dateTimeString, formatter);
                }
            })
            .create();
    }

}