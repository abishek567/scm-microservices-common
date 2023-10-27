package scmmicroservices.common.http;


public interface Http {

    <T> T get(String path, Class<T> type);

    <T> T post(String url, String path, Object requestEntity, Class<T> type);

}
