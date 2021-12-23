
package Modelo;


public class Producto {
    private int idPro;    
    private String nombrePro;
    private String descripcion;
    private String medidas;
    private int unidades;
    private float precioCosto;
    private float precioVenta;
    private String imagenProd;
    private int idCat;

    public Producto() {
    }

    public Producto(String nombrePro, String descripcion, String medidas, int unidades, float precioCosto, float precioVenta, String imagenProd, int idCat) {
        this.nombrePro = nombrePro;
        this.descripcion = descripcion;
        this.medidas = medidas;
        this.unidades = unidades;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.imagenProd = imagenProd;
        this.idCat = idCat;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getImagenProd() {
        return imagenProd;
    }

    public void setImagenProd(String imagenPro) {
        this.imagenProd = imagenPro;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

   
    
}
