package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname", nullable = false, length = 100)
    @Size(min = 3,  max = 100)
    @NotNull
    private String fullName;

    @NotNull
    @Column(name="email", nullable = false, length = 100, unique = true)
    @Size(min = 3, max = 100)
    @Email()
    private String email;

    @NotNull
    @Column(name = "nickname", nullable = false, length = 50, unique = true)
    @Size(min = 3, max = 50)
    private String nickName;

    @Size(min = 6, max = 255)
    @Column(name="password", nullable = false, length = 255)
    @NotNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Candidate> candidate;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Submission> submission;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime createAt;
}
