package com.vehiculerental.backapp.boReservation;

public class Reservations {

    private int id;
    private int idClient;
    private String immat;
    private int dateDebut;
    private int dateFin;
    private int kmEstimes;
    private int kmReels;
    private boolean billed = false;

    public Reservations() {}

    public Reservations(int id, int idClient, String immat, int dateDebut, int dateFin, int kmEstimes, int kmReels, boolean billed) {
        this.id = id;
        this.idClient = idClient;
        this.immat = immat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmEstimes = kmEstimes;
        this.kmReels = kmReels;
        this.billed = billed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public int getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(int dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDateFin() {
        return dateFin;
    }

    public void setDateFin(int dateFin) {
        this.dateFin = dateFin;
    }

    public int getKmEstimes() {
        return kmEstimes;
    }

    public void setKmEstimes(int kmEstimes) {
        this.kmEstimes = kmEstimes;
    }

    public int getKmReels() {
        return kmReels;
    }

    public void setKmReels(int kmReels) {
        this.kmReels = kmReels;
    }

    public boolean isBilled() {
        return billed;
    }

    public void setBilled(boolean billed) {
        this.billed = billed;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", immat='" + immat + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", kmEstimes=" + kmEstimes +
                ", kmReels=" + kmReels +
                ", billed=" + billed +
                '}';
    }
}
