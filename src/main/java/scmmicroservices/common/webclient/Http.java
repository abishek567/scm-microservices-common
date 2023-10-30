package scmmicroservices.common.webclient;

public interface Http {

    <T> T get(String url, String path, Class<T> responseType) throws Exception;

    <T, S> S post(String url, String path, T requestBody, Class<S> responseType) throws Exception;
}
