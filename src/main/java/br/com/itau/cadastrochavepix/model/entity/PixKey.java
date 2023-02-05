package br.com.itau.cadastrochavepix.model.entity;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.enums.PixKeyType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "pix_key")
public class PixKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    PixKeyType pixKeyType;

    @Column
    String pixKey;

    @Column
    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @Column
    Integer agencyNumber;

    @Column
    Integer accountNumber;

    @Column
    String accountHolderName;

    @Column
    String accountHolderLastName;

    @Column
    LocalDateTime createdAt = LocalDateTime.now();

    @Column
    LocalDateTime modifiedAt;

}
