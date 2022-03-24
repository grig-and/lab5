package content;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long height; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 37, Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, long height, String passportID, Color hairColor, Country nationality) {
        this.name = name;
        this.height = height;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person:" +
                "\nname= " + name +
                "\nheight= " + height +
                "\npassportID= " + passportID +
                "\nhairColor= " + hairColor +
                "\nnationality= " + nationality;
    }
}