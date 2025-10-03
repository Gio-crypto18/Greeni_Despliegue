package pe.edu.upc.greeni.dtos;

import java.io.Serializable;

public class JwtRequestDTO implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String email;
    private String password;
    public JwtRequestDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public JwtRequestDTO(String username, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}