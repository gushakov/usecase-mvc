package com.github.usecasemvc.core.usecase;

import com.github.usecasemvc.core.dto.HomeForm;
import com.github.usecasemvc.core.port.SomeInputPort;
import com.github.usecasemvc.core.port.SomeOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class SomeUseCase implements SomeInputPort {

    private final SomeOutputPort presenter;

    @Override
    public void doSomething(HomeForm homeForm) {
        // do something useful

        // present results on the homepage
        presenter.presentHomeView(Map.of("homeForm", homeForm), "home");

    }

    @Override
    public void doSomethingOther(HomeForm homeForm) {

        if (homeForm.getText().isEmpty()) {
            presenter.presentError(new Exception("Text cannot be empty"));
        } else {
            presenter.presentAnotherView(Map.of(), "another");
        }

    }
}
