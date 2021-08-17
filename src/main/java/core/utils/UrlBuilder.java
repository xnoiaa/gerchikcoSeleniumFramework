package core.utils;

import core.fe.BaseUrl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlBuilder {

    private UrlBuilder() {
    }

    public static <T> String buildUrl(final Class<T> page, final String partialUrl) {
        final BaseUrl url = page.getAnnotation(BaseUrl.class);
        final String baseUrl = url.value();
        return String.format("%s/%s", baseUrl, partialUrl);
    }

    public static String getPropertyValue(final String key) {
        final Properties testProperties = new Properties();
        try {
            testProperties.load(new FileInputStream("src/main/resources/properties/test.properties"));
        } catch (final IOException e) {
            throw new IllegalStateException("Unable to read property file!", e);
        }
        return testProperties.getProperty(key);
    }

    public static String buildUrlUsingProperties(final String key, final String partialUrl) {
        final String propValue = getPropertyValue(key);
        return String.format("%s/%s", propValue, partialUrl);
    }
}
