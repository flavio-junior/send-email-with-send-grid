package br.com.send.grid.service

import br.com.send.grid.vo.EmailVO
import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.Response
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import jdk.incubator.vector.VectorOperators.LOG
import org.apache.juli.logging.Log
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.IOException


@Service
class EmailService {

    @Autowired
    private var sendGrid: SendGrid = SendGrid(System.getenv("KEY-SEND-GRID"))
    private val logger: Logger = LoggerFactory.getLogger(EmailService::class.java)

    fun sendEmail(emailVO: EmailVO) {
        val from = Email(emailVO.fromEmail, emailVO.fromName)
        val subject = emailVO.subject
        val to = Email(emailVO.to)
        val content = Content(emailVO.contentType, emailVO.body)
        val mail = Mail(from, emailVO.subject, to, content)
        val request = Request()
        try {
            request.method = Method.POST
            request.endpoint = "mail/send"
            request.body = mail.build()
            logger.info("Sending email to: ${emailVO.to}")
            val response: Response = sendGrid.api(request)
            if(response.statusCode in 400..500) {
                logger.error("Error sending email: ${emailVO.body}")
            } else {
                logger.info("Email sent! Status = : ${response.statusCode}")
            }
        } catch (ex: IOException) {
            throw ex
        }
    }

}