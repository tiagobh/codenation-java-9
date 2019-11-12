package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "submission")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Submission {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "user", column = @Column(name = "user_id")),
            @AttributeOverride(name = "challenge", column = @Column(name = "challenge_id"))
    })
    private SubmissionId submissionId;

    @Column(name = "score", nullable = false)
    @NotNull
    private float score;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime createAt;

}
