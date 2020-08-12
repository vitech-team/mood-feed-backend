package com.vitech.moodfeed.domain;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
@Builder
public class User {

    @Id Long id;
    String firstName;
    String lastName;
    String logoColor;

}
