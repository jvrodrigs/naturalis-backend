package app.naturalis.backend.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private int id;

    public RecursoEvent(Object source, HttpServletResponse response, int id) {
        super(source);
        this.response = response;
        this.id = id;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public int getId() {
        return id;
    }
}
