package com.github.usecasemvc.infrastructure.adapter.web;

import com.github.usecasemvc.core.port.SomeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Scope(scopeName = "request")
@RequiredArgsConstructor
public class WebPresenter implements SomeOutputPort {

    private final LocalDispatcherServlet dispatcher;
    private final HttpServletRequest httpRequest;
    private final HttpServletResponse httpResponse;

    @Override
    public void presentHomeView(Map<String, Object> responseModel, String viewName) {
        present(responseModel, viewName);
    }

    @Override
    public void presentAnotherView(Map<String, Object> responseModel, String viewName) {
        present(responseModel, viewName);
    }

    @Override
    public void presentError(Exception e) {
        final ModelAndView errorMav = new ModelAndView("error", Map.of("errorMessage", e.getMessage()));
        try {
            dispatcher.render(errorMav, httpRequest, httpResponse);
        } catch (Exception ex) {
            throw new RuntimeException(e);
        }
    }

    private void present(Map<String, Object> responseModel, String viewName) {
        final ModelAndView mav = new ModelAndView(viewName, responseModel);
        try {
            dispatcher.render(mav, httpRequest, httpResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
