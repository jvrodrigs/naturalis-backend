package app.naturalis.backend.mail;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.model.Substancias;
import app.naturalis.backend.repository.SubstanciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Mailer {

    @Autowired
    private JavaMailSender mail;

    @Autowired
    private TemplateEngine thymeleaf;

    @Autowired
    private SubstanciasRepository repository;

    public void sendAlertSubstancesExpired(
            List<Substancias> expired, List<Funcionario> responsibleRecipients
    ){
        String template = "mail/mail-notification-subs-expired";
        Map<String, Object> variables = new HashMap<>();
        variables.put("substances", expired);

        List<String> emails = responsibleRecipients.stream()
                .map(Funcionario::getEmail)
                .collect(Collectors.toList());

        this.sendEmailTemplate("naturalis.empresa@gmail.com",
                emails,
                "Substâncias vencidas!",
                template,
                variables);
    }

    public void sendEmailTemplate(String sender, List<String> dest,
                                  String subject, String template,
                                  Map<String, Object> params){
        Context context = new Context(new Locale("pt", "br"));

        params.entrySet().forEach(ent -> context.setVariable(ent.getKey(), ent.getValue()));

        String message = thymeleaf.process(template, context);

        this.sendEmail(sender, dest, subject, message);
    }

    public void sendEmail(String sender, List<String> dest,
                          String subject, String message){
        try {
            MimeMessage mimeMessage = mail.createMimeMessage();

            MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            mimeHelper.setFrom(sender);
            mimeHelper.setTo(dest.toArray(new String[dest.size()]));
            mimeHelper.setSubject(subject);
            mimeHelper.setText(message, true);


            mail.send(mimeMessage);
        } catch (MessagingException e){
            throw new RuntimeException("Problemas com o envio de e-mail", e);
        }
    }
}
