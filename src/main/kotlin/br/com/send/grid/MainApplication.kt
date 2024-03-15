package br.com.send.grid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SendEmailWithSendGridApplication

fun main(args: Array<String>) {
	runApplication<SendEmailWithSendGridApplication>(*args)
}
