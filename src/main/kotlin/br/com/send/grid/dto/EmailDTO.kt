package br.com.send.grid.dto

data class EmailDTO(
    var body: String = "",
    var contentType: String = "",
    var fromEmail: String = "",
    var fromName: String = "",
    var replyTo: String = "",
    var subject: String = "",
    var to: String = ""
)