package br.com.itau.cadastrochavepix.infra.entity;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.app.model.enums.PixKeyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "pix_key")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
