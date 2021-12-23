
package Modelo;


public class Pedido {
    private int idPed;    
    private float subtotal;
    private float descuento;
    private float total;

    public Pedido() {
    }

    public Pedido(float subtotal, float descuento, float total) {
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   

    
}
