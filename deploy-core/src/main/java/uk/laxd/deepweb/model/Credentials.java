package uk.laxd.deepweb.model;

/**
 * Created by Lenny on 27/09/2015.
 */
public class Credentials extends DatabaseObject {
    private String username;
    private String password;
    private String keyLocation;
    private CredentialType type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(String keyLocation) {
        this.keyLocation = keyLocation;
    }

    public CredentialType getType() {
        return type;
    }

    public void setType(CredentialType type) {
        this.type = type;
    }
}
