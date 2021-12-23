
package Modelo;


public class Factura {
    private int idfac;    
    private String Emision;
    private String Vencimiento;    
    private int idCli;
    private int idVen;
    private int idPed;
    private double impuestos;

    public Factura() {
    }

    public Factura(String Emision, String Vencimiento, int idCli, int idVen, int idPed, double impuestos) {
        this.Emision = Emision;
        this.Vencimiento = Vencimiento;
        this.idCli = idCli;
        this.idVen = idVen;
        this.idPed = idPed;
        this.impuestos = impuestos;
    }

    public int getIdfac() {
        return idfac;
    }

    public void setIdfac(int idfac) {
        this.idfac = idfac;
    }

    public String getEmision() {
        return Emision;
    }

    public void setEmision(String Emision) {
        this.Emision = Emision;
    }

    public String getVencimiento() {
        return Vencimiento;
    }

    public void setVencimiento(String Vencimiento) {
        this.Vencimiento = Vencimiento;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

   
    
}
