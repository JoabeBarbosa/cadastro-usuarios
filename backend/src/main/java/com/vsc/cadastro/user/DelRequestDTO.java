package com.vsc.cadastro.user;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

//---
public record DelRequestDTO(@NotNull UUID userId) {

}
