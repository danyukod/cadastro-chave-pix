package br.com.itau.cadastrochavepix.infra.config;

import br.com.itau.cadastrochavepix.app.model.mapper.DatabasePixKeyMapper;
import br.com.itau.cadastrochavepix.app.service.PixKeyService;
import br.com.itau.cadastrochavepix.app.service.impl.DomainPixKeyService;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.inclusion.impl.DataBaseRegistrationInclusion;
import br.com.itau.cadastrochavepix.infra.repository.PixKeyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PixKeyService pixKeyService(PixKeyRepository pixKeyRepository) {
        return new DomainPixKeyService(registrationInclusion(pixKeyRepository));
    }

    private RegistrationInclusion registrationInclusion(PixKeyRepository pixKeyRepository) {
        return new DataBaseRegistrationInclusion(pixKeyRepository, pixKeyMapper());
    }

    private DatabasePixKeyMapper pixKeyMapper() {
        return new DatabasePixKeyMapper();
    }

}
