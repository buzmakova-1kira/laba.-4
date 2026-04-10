package model;

/** Человек с родителем */
public class Person {
    private Name name;
    private int height;
    private Person father;

    /** Конструктор: имя + рост (без отца) */
    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
        this.father = null;
    }

    /** Конструктор: имя + рост + отец */
    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
        inheritFromFather();
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

    /** Возвращает отца */
    public Person getFather() {
        return father;
    }

    /** Устанавливает отца и наследует фамилию/отчество */
    public void setFather(Person father) {
        this.father = father;
        inheritFromFather();
    }

    // FIX_ME: был прямой доступ к полю name другого объекта
    // FIX_ME: не было пробелов после if
    // старый код:
    // private void inheritFromFather() {
    //     if(father != null) {
    //         if((name.getLastName() == null || name.getLastName().isEmpty())
    //                 && father.name.getLastName() != null) {
    //             name.setLastName(father.name.getLastName());
    //         }
    //         if((name.getMiddleName() == null || name.getMiddleName().isEmpty())
    //                 && father.name.getFirstName() != null) {
    //             name.setMiddleName(father.name.getFirstName() + "ович");
    //         }
    //     }
    // }

    /** Наследует фамилию и отчество от отца */
    private void inheritFromFather() {
        if (father == null) {
            return;
        }

        // Наследование фамилии
        if ((name.getLastName() == null || name.getLastName().isEmpty())
                && father.getName().getLastName() != null) {
            name.setLastName(father.getName().getLastName());
        }

        // Наследование отчества (имя отца + "ович")
        if ((name.getMiddleName() == null || name.getMiddleName().isEmpty())
                && father.getName().getFirstName() != null) {
            name.setMiddleName(father.getName().getFirstName() + "ович");
        }
    }

    /** Возвращает строку: "Имя, рост: N" */
    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}