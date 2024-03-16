package br.com.send.grid.service

import br.com.send.grid.dto.EmailDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MockEmailService : EmailService {

    private val logger: Logger = LoggerFactory.getLogger(SendGridEmailService::class.java)

    override fun sendEmail(emailDTO: EmailDTO) {
        logger.info("Sending email to: ${emailDTO.to}")
        logger.info("Email sent!")
    }
}