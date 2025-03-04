package enums;

public enum ContactsEnum {
    NUMBER("número"),
    WHATSAPP("whatsapp"),
    EMAIL("email");

    private String name;

    private ContactsEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
