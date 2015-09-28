package uk.laxd.deepweb.model;

/**
 * Created by Lenny on 20/09/2015.
 */
public class Server extends DatabaseObject {
    private String name;
    private String host;
    private Credentials credentials;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
