package com.github.usecasemvc.infrastructure.config;

import com.github.usecasemvc.core.port.SomeInputPort;
import com.github.usecasemvc.core.usecase.SomeUseCase;
import com.github.usecasemvc.infrastructure.adapter.web.WebPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UseCasesConfig {

    /*
        If there are any other output ports (for operations with gateway, for example),
        they can be autowired into this method as parameters and used to initialize
        the use case instance.
     */

    @Bean
    @Scope("prototype")
    public SomeInputPort someUseCase(WebPresenter webPresenter) {
        return new SomeUseCase(webPresenter);
    }

}
