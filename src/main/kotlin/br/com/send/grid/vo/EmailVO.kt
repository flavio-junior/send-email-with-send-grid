package br.com.send.grid.vo

data class EmailVO(
    var body: String = "",
    var contentType: String = "",
    var fromEmail: String = "",
    var fromName: String = "",
    var replyTo: String = "",
    var subject: String = "",
    var to: String = ""
)