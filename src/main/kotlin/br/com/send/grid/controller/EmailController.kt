package br.com.send.grid.controller

import br.com.send.grid.dto.EmailDTO
import br.com.send.grid.service.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/emails"])
class EmailController {

    @Autowired
    private lateinit var emailService: EmailService

    @PostMapping
    fun sendEmail(@RequestBody emailDTO: EmailDTO): ResponseEntity<EmailDTO> {
        emailService.sendEmail(emailDTO)
        return ResponseEntity.noContent().build()
    }
}