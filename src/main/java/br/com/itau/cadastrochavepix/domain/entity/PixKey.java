package br.com.itau.cadastrochavepix.domain.entity;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.app.model.enums.PixKeyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity(name = "pix_key")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PixKey {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
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
    LocalDateTime createdAt;

    @Column
    LocalDateTime modifiedAt;

}
