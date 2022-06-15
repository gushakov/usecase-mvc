package com.github.usecasemvc.core.port;

import java.util.Map;

public interface SomeOutputPort {
    void presentHomeView(Map<String, Object> responseModel, String viewName);

    void presentAnotherView(Map<String, Object> responseModel, String viewName);

    void presentError(Exception e);
}
