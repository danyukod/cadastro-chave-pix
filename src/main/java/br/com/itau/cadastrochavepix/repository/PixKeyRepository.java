package br.com.itau.cadastrochavepix.repository;

import br.com.itau.cadastrochavepix.model.entity.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKey, Long> {
}
