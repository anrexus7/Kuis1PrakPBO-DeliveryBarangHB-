package Model.Class;

import Model.Interface.countVolume;

public class TransporLaut extends Transportasi implements countVolume {
    private float[] dimensiBarang; //0 -> p, 1 -> l, 2 -> t
    private boolean asuransi;

    public TransporLaut(float beratPaket, boolean barangBerharga, boolean asuransi, float[] dimensiBarang) {
        super(beratPaket, barangBerharga);
        this.asuransi = asuransi;
        this.dimensiBarang = dimensiBarang;
    }

    @Override
    public float hitungVolume() {
        float temp=1;
        for(float tempDimensi : dimensiBarang){
            temp *= tempDimensi;
        }
        return temp;
    }

    @Override
    public double hitungBiaya() {
        float volume = hitungVolume();
        double harga;

        if(volume <= 2500){
            harga = 100 * volume;
        }else{
            harga = 75 * volume;
        }

        if(super.getBarangBerharga()){
            harga *= 105/100;
        }

        if(this.asuransi){
            harga *= 101.5/100;
        }

        return harga;
    }

    public float[] getDimensiBarang() {
        return dimensiBarang;
    }

    public void setDimensiBarang(float[] dimensiBarang) {
        this.dimensiBarang = dimensiBarang;
    }

    public boolean getAsuransi() {
        return asuransi;
    }

    public void setAsuransi(boolean asuransi) {
        this.asuransi = asuransi;
    }
}
