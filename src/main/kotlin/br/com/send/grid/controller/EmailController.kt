package br.com.send.grid.controller

import br.com.send.grid.vo.EmailVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/emails"])
class EmailController {

    @PostMapping
    fun sendEmail(@RequestBody emailVO: EmailVO): ResponseEntity<EmailVO> {
        return ResponseEntity.noContent().build()
    }
}