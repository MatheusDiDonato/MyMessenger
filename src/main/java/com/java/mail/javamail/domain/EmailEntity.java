package com.java.mail.javamail.domain;

import com.java.mail.javamail.enums.StatusEmail;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_EMAIL")
public class EmailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerReference;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column (columnDefinition = "TEXT")
    private String text;
    @Column (columnDefinition = "TEXT")
    private String bodyHtml;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
