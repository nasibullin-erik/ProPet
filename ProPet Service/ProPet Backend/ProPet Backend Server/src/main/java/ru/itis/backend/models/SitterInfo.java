package ru.itis.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sitter_info")
public class SitterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    protected Account account;

    @Column(name = "account_id")
    protected Long accountId;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String surname;

    @Column(nullable = false)
    protected String city;

    @Column(nullable = false)
    protected Integer age;

    @Column(name = "info_about", nullable = false)
    protected String infoAbout;

    @Column(name = "rate_1", nullable = false)
    protected Integer rateOne = 0;

    @Column(name = "rate_2", nullable = false)
    protected Integer rateTwo = 0;

    @Column(name = "rate_3", nullable = false)
    protected Integer rateThree = 0;

    @Column(name = "rate_4", nullable = false)
    protected Integer rateFour = 0;

    @Column(name = "rate_5", nullable = false)
    protected Integer rateFive = 0;

    @Column(name = "is_deleted", nullable = false)
    protected Boolean isDeleted;

}
