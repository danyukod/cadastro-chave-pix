package br.com.itau.cadastrochavepix.infra.config;

import br.com.itau.cadastrochavepix.adapters.input.web.model.mapper.DatabasePixKeyMapper;
import br.com.itau.cadastrochavepix.domain.ports.input.RegisterPixKeyUsecase;
import br.com.itau.cadastrochavepix.application.RegisterPixKeyService;
import br.com.itau.cadastrochavepix.domain.ports.output.PixKeyPort;
import br.com.itau.cadastrochavepix.adapters.output.database.PixKeyDatabase;
import br.com.itau.cadastrochavepix.adapters.output.database.repository.PixKeyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    RegisterPixKeyUsecase pixKeyService(PixKeyRepository pixKeyRepository) {
        return new RegisterPixKeyService(registrationInclusion(pixKeyRepository));
    }

    private PixKeyPort registrationInclusion(PixKeyRepository pixKeyRepository) {
        return new PixKeyDatabase(pixKeyRepository, pixKeyMapper());
    }

    private DatabasePixKeyMapper pixKeyMapper() {
        return new DatabasePixKeyMapper();
    }

}
