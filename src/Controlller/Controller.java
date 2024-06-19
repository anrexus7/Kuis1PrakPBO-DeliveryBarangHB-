package Controlller;

import Model.Class.TransporDarat;
import Model.Class.TransporLaut;
import Model.Class.TransporUdara;
import Model.Enum.JenisPengiriman;

public class Controller {
    public double countBiayaDarat(float berat, boolean berharga){
        TransporDarat trans = new TransporDarat(berat, berharga);
        trans.hitungBiaya();
        return trans.getHarga();
    }

    public double countBiayaLaut(float berat, boolean berharga, boolean asuransi, float[] dimensi){
        TransporLaut trans = new TransporLaut(berat, berharga, asuransi, dimensi);
        trans.hitungBiaya();
        return trans.getHarga();
    }

    public double countBiayaUdara(float berat, boolean berharga, float[] dimensi, JenisPengiriman jenisKirim){
        TransporUdara trans = new TransporUdara(berat,berharga,dimensi,jenisKirim);
        trans.hitungBiaya();
        return trans.getHarga();
    }
}
