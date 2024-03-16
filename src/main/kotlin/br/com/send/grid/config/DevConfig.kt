package br.com.send.grid.config

import br.com.send.grid.service.EmailService
import br.com.send.grid.service.MockEmailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("test")
class DevConfig {

    @Bean
    fun emailService(): EmailService {
        return MockEmailService()
    }
}