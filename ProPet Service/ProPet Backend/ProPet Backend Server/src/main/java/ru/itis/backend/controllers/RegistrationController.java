package ru.itis.backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.backend.dto.RegistrationForm;
import ru.itis.backend.dto.AccountDto;
import ru.itis.backend.services.RegistrationService;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@CrossOrigin
public class RegistrationController {

    @NonNull
    protected RegistrationService service;

    @Operation(summary = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success registration", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(
                            schema = @Schema(implementation = AccountDto.class)
                    ))
            })
    })
    @PostMapping()
    public ResponseEntity<AccountDto> registerNewUser(@RequestBody RegistrationForm registrationForm){
        return ResponseEntity.ok(service.registerNewAccount(registrationForm));
    }

}
