package br.com.send.grid.service

import br.com.send.grid.dto.EmailDTO

interface EmailService {
    fun sendEmail(emailDTO: EmailDTO)
}