package br.com.itau.cadastrochavepix.infra.repository;

import br.com.itau.cadastrochavepix.infra.entity.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    Boolean existsByPixKey(String pixKey);

    Boolean countByPixKey(String pixKey);

    Long countByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);
}
