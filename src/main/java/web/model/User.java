package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users_for_task_2.2.3.1")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    String lastName;

    @Column
    String number;

    public User() {}

    public User(int id, String name, String lastName, String number) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
