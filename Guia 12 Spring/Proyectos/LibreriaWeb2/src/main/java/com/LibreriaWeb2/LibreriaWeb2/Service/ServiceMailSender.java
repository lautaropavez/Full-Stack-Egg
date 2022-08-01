package com.LibreriaWeb2.LibreriaWeb2.Service;


import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class ServiceMailSender {
    @Autowired//(required=true)
    private JavaMailSender mailSender;
    
    
    
    // En inglés establecemos los atributos como:
    // cuerpo = body, mail = toEmail, titulo = subject
    @Async
    public void enviarEmail(String cuerpo, String titulo, String mail){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(mail);
        mensaje.setFrom("lautapavez@gmail.com"); //Quien lo manda
        mensaje.setSubject(titulo); //Asunto
        mensaje.setText(cuerpo); //Cuerpo del mensaje
        
        mailSender.send(mensaje); //Enviamos el mensaje
        System.out.println("Holaaa, Mail enviado...");
    }
    
    //Para enviar mail con imagen
    public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("lautapavez@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        
        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
        
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
        mailSender.send(mimeMessage);
        System.out.println("Mail Enviado");
    }
}
