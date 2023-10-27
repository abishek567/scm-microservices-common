package scmmicroservices.common.http.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import scmmicroservices.common.http.Http;

@Component
public class HttpImpl implements Http {

    @Override
    public <T> T get(String path, Class<T> type) {
        return null;
    }

    @Override
    public <T> T post(String url, String path, Object requestEntity, Class<T> type) {
        return null;
    }
}
