package web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Size(min = 2, max = 30, message = "between 2 and 30 characters")
    @Column(name = "name")
    private String name;


    @Size(min = 2, max = 30, message = "between 2 and 30 characters")
    @Column(name = "lastname")
    private String lastname;


    @Size(min = 4, max = 6, message = "between 4 and 6 characters")
    @Column(name = "sex")
    private String sex;

    @PositiveOrZero(message = "should no be less then 0")
    @NotNull(message = "should not be empty")
    @Digits(integer = 3, fraction = 0, message = "between 1 and 3 characters")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(long id, String name, String lastname, String sex, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }

    public User(String name, String lastname, String sex, int age) {
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
