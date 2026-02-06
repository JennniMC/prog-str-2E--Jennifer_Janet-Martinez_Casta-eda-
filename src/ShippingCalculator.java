public class ShippingCalculator {
    public double subtotal;

   public  double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
       double subtotal = 0;
       if (tipoServicio == 1) {
           subtotal += 50;
       } else if (tipoServicio == 2) {
           subtotal += 90;
       }


       subtotal += pesoKg * 12;


       if (distanciaKm <= 50) {
           subtotal += 20;
       } else if (distanciaKm <= 200) {
           subtotal += 60;
       } else {
           subtotal += 120;
       }


       if (zonaRemota) {
           subtotal=  subtotal + (subtotal * 0.10);
       }

       return subtotal;
   }
    double calcularIVA(double subtotal){
        return subtotal * 0.16;
    }//calculamos el iva
    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }//calculamos el total con iva
}
