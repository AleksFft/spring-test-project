package com.example.spring_test_project.resource;

import com.example.spring_test_project.model.BcMarkupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Aleksandr_Berestov
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-25T17:00:15.380562400+04:00[Europe/Samara]")
@Validated
@Tag(name = "ImportScheduledPaymentDocuments", description = "Импорт платежного документа из файла с использованием BGO")
public interface ImportScheduledPaymentDocumentsApi {

    /**
     * POST /import/complete/{taskId} : Отправить документ на импорт в ППД
     *
     * @param taskId           BGO taskId (required)
     * @param importRequestDto (optional)
     * @return OK (status code 200)
     * or unexpected error (status code 400)
     */
    @Operation(
            operationId = "callImport",
            summary = "Отправить документ на импорт в ППД",
            tags = {"ImportScheduledPaymentDocuments"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BcMarkupDto.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/import/complete/{taskId}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<String> callImport(
            @Parameter(name = "taskId", description = "BGO taskId", required = true) @PathVariable("taskId") String taskId,
            @Parameter(name = "ImportRequestDto", description = "") @Valid @RequestBody(required = false) BcMarkupDto importRequestDto
    );

}

