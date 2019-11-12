package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Candidate  {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name="user", column = @Column(name = "user_id")),
            @AttributeOverride(name="acceleration", column = @Column(name = "acceleration_id")),
            @AttributeOverride(name="company", column = @Column(name = "company_id"))
    })
    private CandidateId candidateId;

    @NotNull
    private int status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime createAt;
}
