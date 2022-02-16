package app.naturalis.backend.service;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class ApplicationService {

    public String getHostName(){
        String hostName = null;
        try {
            hostName = "in " + InetAddress.getLocalHost().getCanonicalHostName() + " (" + InetAddress.getLocalHost().getHostAddress() + ")";
        } catch (UnknownHostException ex){
            ex.printStackTrace();
        }

        return hostName;
    }

}
