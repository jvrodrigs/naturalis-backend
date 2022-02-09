package app.naturalis.backend.event.listener;

import app.naturalis.backend.event.RecursoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class RecursoListener implements ApplicationListener<RecursoEvent> {

    @Override
    public void onApplicationEvent(RecursoEvent event) {
        HttpServletResponse response = event.getResponse();
        Long id = event.getId();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
