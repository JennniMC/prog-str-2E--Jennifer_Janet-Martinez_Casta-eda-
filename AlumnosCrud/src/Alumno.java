public class Alumno {
    private int id;
    private String nombre;
    public double promedio;
    private boolean activo;


    public Alumno(){

        }
     public Alumno(int id, String nombre, double promedio, boolean activo){
            this.id=id;
            this.nombre=nombre;
            this.promedio=promedio;
            this.activo=true;


     }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }



}
