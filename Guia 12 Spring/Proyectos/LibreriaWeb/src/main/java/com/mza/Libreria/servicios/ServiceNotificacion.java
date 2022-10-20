package com.mza.Libreria.servicios;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServiceNotificacion {
    
    @Autowired//(required=true)
    private JavaMailSender mailSender;
    
    /**
     * En inglés establecemos los atributos como: cuerpo = body, mail = toEmail, titulo = subject
     * @param cuerpo
     * @param titulo
     * @param mail
     */
    @Async
    public void enviarEmail(String cuerpo, String titulo, String mail){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(mail);
        mensaje.setFrom("elceibolibreria@gmail.com"); //Quien lo manda
        mensaje.setSubject(titulo); //Asunto
        mensaje.setText(cuerpo); //Cuerpo del mensaje
        
        mailSender.send(mensaje); //Enviamos el mensaje
        System.out.println("Mail enviado...");
    }
    
    public void enviarEmailConArchivo(String cuerpo, String titulo, String mail, String archivo) throws MessagingException{
        
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        
        MimeMessageHelper  mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("elceibolibreria@gmail.com");
        mimeMessageHelper.setTo(mail);
        mimeMessageHelper.setText(cuerpo);
        mimeMessageHelper.setSubject(titulo);
        
        FileSystemResource fileSystem = new FileSystemResource(new File(archivo));
        
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
        
        mailSender.send(mimeMessage);
        System.out.println("Mail enviado...");
    }
}
