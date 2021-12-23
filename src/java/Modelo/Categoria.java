package Modelo;


public class Categoria {
   int idCat;
   String nombreCat;
   String descripcion;

    public Categoria() {
    }

    public Categoria(String nombreCat, String descripcion) {
        this.nombreCat = nombreCat;
        this.descripcion = descripcion;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
