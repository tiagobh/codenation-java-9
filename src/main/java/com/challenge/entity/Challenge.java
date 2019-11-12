package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "challenge")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100)
    @NotNull
    private String name;

    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50)
    @NotNull
    private String slug;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private Set<Acceleration> accelerations;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Submission> submissions;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime createAt;
}
