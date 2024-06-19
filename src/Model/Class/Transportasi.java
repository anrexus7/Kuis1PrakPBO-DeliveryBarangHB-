package Model.Class;

import Model.Interface.countHarga;

abstract class Transportasi implements countHarga {
    private float beratPaket;
    private boolean barangBerharga;
    private double harga;

    public Transportasi() {

    }

    public Transportasi(float beratPaket, boolean barangBerharga) {
        this.beratPaket = beratPaket;
        this.barangBerharga = barangBerharga;
    }

    @Override
    public double hitungBiaya() {
        return 0;
    }

    public float getBeratPaket() {
        return beratPaket;
    }

    public void setBeratPaket(float beratPaket) {
        this.beratPaket = beratPaket;
    }

    public boolean getBarangBerharga() {
        return barangBerharga;
    }

    public void setBarangBerharga(boolean barangBerharga) {
        this.barangBerharga = barangBerharga;
    }

    public double getHarga() {
        return harga = hitungBiaya();
    }
}
