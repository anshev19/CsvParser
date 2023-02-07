public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "id = " + id + ", " +
                "firstName = " + "'" + firstName + "'" + ", " +
                "lastName = " + "'" + lastName + "'" + ", " +
                "country = " + "'" + country + "'" + ", " +
                "age = " + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Employee) {
            Employee objEmployee = (Employee) obj;
            return this.id == objEmployee.id &&
                    this.firstName.equals(objEmployee.firstName) &&
                    this.lastName.equals(objEmployee.lastName) &&
                    this.country.equals(objEmployee.country) &&
                    this.age == objEmployee.age;
        }
        return false;
    }
}
