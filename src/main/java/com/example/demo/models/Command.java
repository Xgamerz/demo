package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_command", schema = "dbo", catalog = "demodb")
public class Command {
    private String id;
    private String number;
    private String description;
    private String type;
    private Client tbClientByClient;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 255)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Command tbCommand = (Command) o;

        if (id != null ? !id.equals(tbCommand.id) : tbCommand.id != null) return false;
        if (number != null ? !number.equals(tbCommand.number) : tbCommand.number != null) return false;
        if (description != null ? !description.equals(tbCommand.description) : tbCommand.description != null)
            return false;
        if (type != null ? !type.equals(tbCommand.type) : tbCommand.type != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    public Client getTbClientByClient() {
        return tbClientByClient;
    }

    public void setTbClientByClient(Client tbClientByClient) {
        this.tbClientByClient = tbClientByClient;
    }
}
