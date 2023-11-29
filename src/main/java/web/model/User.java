package web.model;

public class User {
    private long id;
    private String name;
    private String lastname;
    private String sex;
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
