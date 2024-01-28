package com.scm.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scm.common.constants.RequestHeaderConstants;
import com.scm.data.dto.RoleDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
@RequiredArgsConstructor
@Slf4j
public class RequestHeaderUtils {

    private final HttpServletRequest request;

    public String getValue(String key) {
        String value = request.getHeader(key);
        log.info("{}: {}", key, value);
        return value;
    }

    public String getUserId() {
        return getValue(RequestHeaderConstants.USER_ID);
    }

    public String getUsername() {
        return getValue(RequestHeaderConstants.USER_ID);
    }

    public List<RoleDTO> getRoles() {
        String rolesJsonArray = getValue(RequestHeaderConstants.USER_ID);
        try {
            return CommonUtils.getListFromJsonArray(rolesJsonArray, RoleDTO.class);
        } catch (JsonProcessingException e) {
            log.error("Error is retrieving roles from request header: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

}
