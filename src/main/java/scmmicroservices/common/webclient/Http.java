package scmmicroservices.common.webclient;

import java.util.List;
import java.util.Map;

public interface Http {

    <T> T get(String url, String path, Map<String, String> params, Class<T> responseType) throws Exception;

    <T> List<T> getList(String url, String path, Map<String, String> params, Class<T> responseType) throws Exception;

    <T, S> S post(String url, String path, T requestBody, Class<S> responseType) throws Exception;

    <T, S> List<S> postAndReceiveList(String url, String path, T requestBody, Class<S> responseType) throws Exception;

}
