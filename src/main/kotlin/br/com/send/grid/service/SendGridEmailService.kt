package br.com.send.grid.service

import br.com.send.grid.dto.EmailDTO
import br.com.send.grid.exceptions.EmailException
import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.Response
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.IOException

class SendGridEmailService : EmailService {

    @Autowired
    private var sendGrid: SendGrid = SendGrid(System.getenv("KEY-SEND-GRID"))
    private val logger: Logger = LoggerFactory.getLogger(SendGridEmailService::class.java)

    override fun sendEmail(emailDTO: EmailDTO) {
        val from = Email(emailDTO.fromEmail, emailDTO.fromName)
        val subject = emailDTO.subject
        val to = Email(emailDTO.to)
        val content = Content(emailDTO.contentType, emailDTO.body)
        val mail = Mail(from, emailDTO.subject, to, content)
        val request = Request()
        try {
            request.method = Method.POST
            request.endpoint = "mail/send"
            request.body = mail.build()
            logger.info("Sending email to: ${emailDTO.to}")
            val response: Response = sendGrid.api(request)
            if (response.statusCode in 400..500) {
                logger.error("Error sending email: ${emailDTO.body}")
                throw EmailException(response.body)
            }
            logger.info("Email sent! Status = : ${response.statusCode}")
        } catch (ioException: IOException) {
            throw EmailException(ioException.message)
        }
    }
}