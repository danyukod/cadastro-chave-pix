package br.com.itau.cadastrochavepix.adapters.output.database.repository;

import br.com.itau.cadastrochavepix.adapters.output.database.entity.PixKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKeyEntity, String> {

    Boolean existsByPixKey(String pixKey);

    Long countByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);
}
