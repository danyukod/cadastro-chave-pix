package br.com.itau.cadastrochavepix.infra.config;

import br.com.itau.cadastrochavepix.adapters.output.database.model.mapper.DatabasePixKeyMapper;
import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.output.database.PixKeyDatabase;
import br.com.itau.cadastrochavepix.adapters.output.database.repository.PixKeyRepository;
import br.com.itau.cadastrochavepix.application.RegisterPixKeyService;
import br.com.itau.cadastrochavepix.application.ports.input.RegisterPixKeyUsecase;
import br.com.itau.cadastrochavepix.application.ports.output.PixKeyPort;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import br.com.itau.cadastrochavepix.domain.entity.Holder;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.services.DomainService;
import br.com.itau.cadastrochavepix.domain.services.impl.AccountService;
import br.com.itau.cadastrochavepix.domain.services.impl.HolderService;
import br.com.itau.cadastrochavepix.domain.services.impl.PixKeyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    RegisterPixKeyUsecase registerPixKeyService(PixKeyRepository pixKeyRepository) {
        return new RegisterPixKeyService(pixKeyPort(pixKeyRepository), pixKeyService());
    }

    private PixKeyPort pixKeyPort(PixKeyRepository pixKeyRepository) {
        return new PixKeyDatabase(pixKeyRepository, pixKeyMapper());
    }

    private DatabasePixKeyMapper pixKeyMapper() {
        return new DatabasePixKeyMapper();
    }

    private DomainService<PixKey, PixKeyRegisterRequest> pixKeyService() {
        return new PixKeyService(accountService());
    }

    private DomainService<Account, PixKeyRegisterRequest> accountService() {
        return new AccountService(holderService());
    }

    private DomainService<Holder, PixKeyRegisterRequest> holderService() {
        return new HolderService();
    }

}
