// BasicAuthenticator.java
package com.jdojo.http.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class BasicAuthenticator extends Authenticator {
    private final String userName;
    private final char[] password;

    public BasicAuthenticator(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        System.out.println(this.getRequestingURL()
                + " is asking for authentication: "
                + this.getRequestingPrompt());
        
        return new PasswordAuthentication(userName, password);        
    }
}
