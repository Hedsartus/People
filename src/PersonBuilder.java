public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalStateException("Age can only be a positive number!");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Name and surname are required fields!");
        }

        if (this.age > 0 && this.address != null) {
            return new Person(this.name, this.surname, this.age, this.address);
        } else if (this.age > 0) {
            return new Person(this.name, this.surname, this.age);
        } else if (this.address != null) {
            return new Person(this.name, this.surname, 0, this.address);
        }

        return new Person(this.name, this.surname);
    }
}