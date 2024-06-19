package Model.Class;

import Model.Enum.JenisPengiriman;
import Model.Interface.countVolume;

public class TransporUdara extends Transportasi implements countVolume {
    private float[] dimensiBarang; //0 -> p, 1 -> l, 2 -> t
    private JenisPengiriman jenisKirim;

    public TransporUdara(float beratPaket, boolean barangBerharga, float[] dimensiBarang, JenisPengiriman jenisKirim) {
        super(beratPaket, barangBerharga);
        this.dimensiBarang = dimensiBarang;
        this.jenisKirim = jenisKirim;
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

        if(jenisKirim.equals(JenisPengiriman.EKSPRESS)){
            harga = 45 * volume;
        }else{
            harga = 60 * volume;
        }

        if(super.getBarangBerharga()){
            harga *= 105/100;
        }

        return (harga * 102/100);
    }

    public JenisPengiriman getJenisKirim() {
        return jenisKirim;
    }

    public void setJenisKirim(JenisPengiriman jenisKirim) {
        this.jenisKirim = jenisKirim;
    }

    public float[] getDimensiBarang() {
        return dimensiBarang;
    }

    public void setDimensiBarang(float[] dimensiBarang) {
        this.dimensiBarang = dimensiBarang;
    }
}
