package utils;

import org.apache.commons.collections4.MapUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Configuration
{
    public final static String MOCK_HOST = "localhost";
    public final static int MOCK_HOST_PORT = 1234;
    public static final String SERVICE_URL = "http://" + MOCK_HOST + ":" + MOCK_HOST_PORT;

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final String DUMMY_PROVIDER = "dummy-provider";
    public static final String DUMMY_CONSUMER = "dummy-consumer";

    public static String getDateToday()
    {
        return dateFormat.format(new Date());
    }

    public static Map<String, String> getHeaders()
    {
        Map<String, String> headers = MapUtils.putAll(new HashMap<String, String>(),
                new String[]{"Content-Type", "application/json;charset=UTF-8"});
        return headers;
    }


}
