package scmmicroservices.common.http.impl;

import scmmicroservices.common.http.Http;

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
