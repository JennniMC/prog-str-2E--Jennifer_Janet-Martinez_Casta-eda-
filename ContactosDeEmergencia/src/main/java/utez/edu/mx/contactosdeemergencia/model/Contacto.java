package utez.edu.mx.contactosdeemergencia.model;

public class Contacto {
    private String name;
    private String tel;
    private String parent;


    public Contacto() {}


    public Contacto(String name, String tel, String parent) {
        this.name = name;
        this.tel = tel;
        this.parent = parent;
    }


    public String getName() { return name; }
    public String getTel() { return tel; }
    public String getParent() { return parent; }

    @Override
    public String toString() {
        return name + "-" + parent + " - " + tel;
    }
}