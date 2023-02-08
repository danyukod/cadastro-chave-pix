package br.com.itau.cadastrochavepix.infra.config;

import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.inclusion.impl.DataBaseRegistrationInclusion;
import br.com.itau.cadastrochavepix.domain.service.PixKeyService;
import br.com.itau.cadastrochavepix.domain.service.impl.DomainPixKeyService;
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
        return new DataBaseRegistrationInclusion(pixKeyRepository);
    }

}
