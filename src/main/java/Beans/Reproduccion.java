package Beans;

public class Reproduccion {
    private int idreproduccion;
    private String cancion;
    private String banda;

    private int like;

    public Reproduccion(int idreproduccion, String cancion, String banda, int like) {
        this.idreproduccion = idreproduccion;
        this.cancion = cancion;
        this.banda = banda;
        this.like = like;
    }

    public Reproduccion() {
    }

    public int getIdreproduccion() {
        return idreproduccion;
    }

    public void setIdreproduccion(int idreproduccion) {
        this.idreproduccion = idreproduccion;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
