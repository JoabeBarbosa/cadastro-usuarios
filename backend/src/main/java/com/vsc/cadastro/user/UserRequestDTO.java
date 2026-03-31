package com.vsc.cadastro.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//---
public record UserRequestDTO(@NotBlank String userName,@NotNull Integer userAge,@NotBlank String userMail) {

}
