package model;

/** Человек с именем */
public class PersonSimple {
    // FIX_ME: имя должно быть Name, а не String
    // старый код: private String name;
    private Name name;
    private int height;

    /** Конструктор: имя (Name) + рост */
    // FIX_ME: не было пробелов после запятых
    // старый код: public PersonSimple(Name name,int height)
    public PersonSimple(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    /** Возвращает имя */
    public Name getName() {
        return name;
    }

    /** Устанавливает имя */
    public void setName(Name name) {
        this.name = name;
    }

    /** Возвращает рост */
    public int getHeight() {
        return height;
    }

    /** Устанавливает рост */
    public void setHeight(int height) {
        this.height = height;
    }

    // FIX_ME: не было пробелов вокруг оператора +
    // старый код: return name+", рост: "+height;
    /** Возвращает строку: "Имя, рост: N" */
    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}