package Model.Class;

public class TransporDarat extends Transportasi {

    public TransporDarat(float beratPaket, boolean barangBerharga) {
        super(beratPaket, barangBerharga);
    }

    @Override
    public double hitungBiaya() {
        double harga = 15000 * super.getBeratPaket();

        if(super.getBarangBerharga()){
            harga *= 105/100;
        }

        return harga;
    }
}
