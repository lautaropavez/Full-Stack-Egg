package com.LibreriaWeb2.LibreriaWeb2;

import com.LibreriaWeb2.LibreriaWeb2.Service.ServiceMailSender;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LibreriaWeb2Application {
    
    @Autowired
    private ServiceMailSender servNotif;
    
	public static void main(String[] args) {
		SpringApplication.run(LibreriaWeb2Application.class, args);
	}

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() throws MessagingException{
        //servNotif.enviarEmail("This is Body of Email","This is subject","lautapavez@gmail.com");  //Así mandamos mail sin arhivo
//        servNotif.sendEmailWithAttachment("lautapavez@gmail.com","This is Email Body with attachment","This Email has attachment","C:\\Users\\Toshiba\\Desktop\\images.jpg");  
//        servNotif.sendEmailWithAttachment("gasparvillalobos66@gmail.com","Te estoy vigilando...","Hola Gaspar","C:\\Users\\Toshiba\\Desktop\\images2.jpg");  
//        servNotif.sendEmailWithAttachment("moravillalobos@gmail.com","Te estoy vigilando...","Hola Mora","C:\\Users\\Toshiba\\Desktop\\fredie.png"); 
//          servNotif.sendEmailWithAttachment("telmachaca@gmail.com","","Hola Uba","C:\\Users\\Toshiba\\Desktop\\images2.jpg"); 
//          servNotif.sendEmailWithAttachment("telmachaca@gmail.com","","Hola Uba","E:\\TELMA IMG\\Fotos\\Viajes\\Europa\\nietos.jpg"); 
//          servNotif.sendEmailWithAttachment("mabyvbs@gmail.com","Este mensaje ha sido enviado por la consola","Hola mami","C:\\Users\\Toshiba\\Desktop\\images2.jpg"); 

    }
      
        
}
