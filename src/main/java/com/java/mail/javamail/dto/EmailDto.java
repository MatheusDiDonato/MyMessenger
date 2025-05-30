package com.java.mail.javamail.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class EmailDto {

    @NotBlank
    @Email
    private List<String> emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
    private String bodyHtml;
}

