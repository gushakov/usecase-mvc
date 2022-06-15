package com.github.usecasemvc.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class HomeForm {

    private String name;
    private String text;

}
