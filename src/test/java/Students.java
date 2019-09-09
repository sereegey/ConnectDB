public class Students {
    String firstName;
    String lastName;
    int age;
    long phone;
    public Students (String firstName, String lastName, int age, long phone){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    @Override
    public String toString(){
        return "Students: " + "Имя " + firstName + "\t" + "Фамилия " + lastName + "\t" + "Возраст " + age + "\t" + "Телефон " + phone;
    }
}
