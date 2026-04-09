package model;

/** Сущность Имя: фамилия, личное имя, отчество */
public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    /** Конструктор: фамилия + имя + отчество */
    // FIX_ME: не было пробелов после запятых
    // старый код: public Name(String lastName,String firstName,String middleName)
    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    /** Конструктор: фамилия + имя (без отчества) */
    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    /** Конструктор: только имя (без фамилии и отчества) */
    public Name(String firstName) {
        this(null, firstName, null);
    }

    /** Возвращает фамилию */
    public String getLastName() {
        return lastName;
    }

    /** Устанавливает фамилию */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Возвращает личное имя */
    public String getFirstName() {
        return firstName;
    }

    /** Устанавливает личное имя */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Возвращает отчество */
    public String getMiddleName() {
        return middleName;
    }

    /** Устанавливает отчество */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // FIX_ME: была конкатенация строк через +=
    // старый код:
    // @Override
    // public String toString() {
    //     String result = "";
    //     if (lastName != null && !lastName.isEmpty()) {
    //         result += lastName;
    //     }
    //     if (firstName != null && !firstName.isEmpty()) {
    //         if (!result.isEmpty()) {
    //             result += " ";
    //         }
    //         result += firstName;
    //     }
    //     if (middleName != null && !middleName.isEmpty()) {
    //         if (!result.isEmpty()) {
    //             result += " ";
    //         }
    //         result += middleName;
    //     }
    //     return result;
    // }

    /** Возвращает строковое представление имени */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(middleName);
        }

        return sb.toString();
    }
}