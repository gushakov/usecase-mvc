package com.github.usecasemvc.infrastructure.adapter.web;

import com.github.usecasemvc.core.dto.HomeForm;
import com.github.usecasemvc.core.port.SomeInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ApplicationContext appContext;

    @GetMapping("/")
    @ResponseBody
    public void home() {

        // Create a Request Model
        final HomeForm requestModel = HomeForm.builder()
                .name("George")
                .build();

        // Maybe do some validation here...

        // Get the use case bean (prototype) from the application context
        // and execute the use case.
        getSomeUseCase().doSomething(requestModel);

        // Do not return anything, the rest will be handled by the Presenter
    }

    @PostMapping("/doSomethingOther")
    @ResponseBody
    public void doSomethingOther(@ModelAttribute HomeForm homeForm) {

        getSomeUseCase().doSomethingOther(homeForm);
    }

    private SomeInputPort getSomeUseCase() {
        return appContext.getBean(SomeInputPort.class);
    }

}
