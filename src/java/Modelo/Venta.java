
package Modelo;

public class Venta {
    private int idVent;
    private int idPed;
    private String fechaReal;
    private String fechaEntreg;
    private int idmed;    
    private int idmet;
    private String dirEnvio;

    public Venta() {
    }

    public Venta(int idPed, String fechaReal, String fechaEntreg, int idmed, int idmet, String dirEnvio) {
        this.idPed = idPed;
        this.fechaReal = fechaReal;
        this.fechaEntreg = fechaEntreg;
        this.idmed = idmed;
        this.idmet = idmet;
        this.dirEnvio = dirEnvio;
    }

    public int getIdVent() {
        return idVent;
    }

    public void setIdVent(int idVent) {
        this.idVent = idVent;
    }

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public String getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(String fechaReal) {
        this.fechaReal = fechaReal;
    }

    public String getFechaEntreg() {
        return fechaEntreg;
    }

    public void setFechaEntreg(String fechaEntreg) {
        this.fechaEntreg = fechaEntreg;
    }

    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public int getIdmet() {
        return idmet;
    }

    public void setIdmet(int idmet) {
        this.idmet = idmet;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public void setDirEnvio(String dirEnvio) {
        this.dirEnvio = dirEnvio;
    }

  
    
}
