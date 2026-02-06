public class GradeService {
    public double califinal;
    private String name="";
    private double a, b,  c;
    private double promedioParciales;
    private int asistencia;
    private boolean entregoProyecto;
    public String estado;
    public double calcularPromedio(double a, double b, double c){
        promedioParciales=(a+b+c)/3;
        return promedioParciales;


    }
    public  double calcularFinal(double promedioParciales, int asistencia){
        double promedio100 = promedioParciales * 10;   // ← AQUÍ va esta línea
        califinal = (promedio100 * 0.7) + (asistencia * 0.3); // ← y aquí esta
        return califinal;

    }
    public  String determinarEstado(double califinal, int asistencia, boolean entregoProyecto){
        if (asistencia < 80) {
            return "REPROBADO por inasistencias";
        }

        if (!entregoProyecto) {
            return "REPROBADO por no entregar proyecto";
        }

        if (califinal >= 70) {
            return "APROBADO";
        }

        return "REPROBADO por calificación";
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getPromedioParciales() {
        return promedioParciales;
    }

    public void setPromedioParciales(double promedio) {
        this.promedioParciales = promedio;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public boolean isEntregoProyecto() {
        return entregoProyecto;
    }

    public void setEntregoProyecto(boolean entregoProyecto) {
        this.entregoProyecto = entregoProyecto;
    }
}
