package com.github.usecasemvc.core.port;

import com.github.usecasemvc.core.dto.HomeForm;

public interface SomeInputPort {

    void doSomething(HomeForm homeForm);

    void doSomethingOther(HomeForm form);

}
