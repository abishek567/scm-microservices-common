package scmmicroservices.common.properties;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import scmmicroservices.common.properties.constants.RequestConstants;

public class UserDetails {

    public static String getUserName() {
        return String.valueOf(RequestContextHolder
                .currentRequestAttributes()
                .getAttribute(RequestConstants.reqHeaderUserName, RequestAttributes.SCOPE_REQUEST));
    }

    public static String getUserId() {
        return String.valueOf(RequestContextHolder
                .currentRequestAttributes()
                .getAttribute(RequestConstants.reqHeaderUserId, RequestAttributes.SCOPE_REQUEST));
    }

    public static String getUserRoles() {
        return String.valueOf(RequestContextHolder
                .currentRequestAttributes()
                .getAttribute(RequestConstants.reqHeaderRoles, RequestAttributes.SCOPE_REQUEST));
    }
}
