package br.com.itau.cadastrochavepix.adapters.output.database.repository;

import br.com.itau.cadastrochavepix.adapters.output.database.entity.PixKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKeyEntity, UUID> {

    Boolean existsByPixKey(String pixKey);

    Long countByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);
}
