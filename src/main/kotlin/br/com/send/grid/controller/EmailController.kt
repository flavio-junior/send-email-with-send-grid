package br.com.send.grid.controller

import br.com.send.grid.service.EmailService
import br.com.send.grid.vo.EmailVO
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
    fun sendEmail(@RequestBody emailVO: EmailVO): ResponseEntity<EmailVO> {
        emailService.sendEmail(emailVO)
        return ResponseEntity.noContent().build()
    }
}