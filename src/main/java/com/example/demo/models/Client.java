package com.example.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tb_client", schema = "dbo", catalog = "demodb")
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String mail;
    private String tel;
    private Collection<Command> tbCommandsById;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 255)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client tbClient = (Client) o;

        if (id != null ? !id.equals(tbClient.id) : tbClient.id != null) return false;
        if (firstName != null ? !firstName.equals(tbClient.firstName) : tbClient.firstName != null) return false;
        if (lastName != null ? !lastName.equals(tbClient.lastName) : tbClient.lastName != null) return false;
        if (mail != null ? !mail.equals(tbClient.mail) : tbClient.mail != null) return false;
        if (tel != null ? !tel.equals(tbClient.tel) : tbClient.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tbClientByClient")
    public Collection<Command> getTbCommandsById() {
        return tbCommandsById;
    }

    public void setTbCommandsById(Collection<Command> tbCommandsById) {
        this.tbCommandsById = tbCommandsById;
    }
}
