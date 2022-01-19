package com.example.squadio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "refresh_token_generator", sequenceName = "refresh_token_generator")
    @Column(name = "ID")
    private Long id;
    @Column(name = "TOKEN_ID")
    private String token_id;
    @Lob
    @Column(name = "TOKEN")
    private Blob token;
    @Lob
    @Column(name = "AUTHENTICATION")
    private Blob authentication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public Blob getToken() {
        return token;
    }

    public void setToken(Blob token) {
        this.token = token;
    }

    public Blob getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Blob authentication) {
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        return "OauthRefreshToken{" +
                "id=" + id +
                ", token_id='" + token_id + '\'' +
                ", token='" + token + '\'' +
                ", authentication='" + authentication + '\'' +
                '}';
    }
}
