package View;

import Controlller.Controller;
import Model.Enum.JenisPengiriman;

import java.util.Scanner;

public class Menu {
    private static float berat=0;
    private static  float[] dimensi = new float[3];
    private static boolean berharga;
    private static Controller Controller;
    private static Scanner scan = new Scanner(System.in);

    public Menu() {
        showMenu();
    }

    private static void showMenu() {
        int n = 0, m=0;
        double harga = 0, total = 0;

        System.out.print("Masukkan banyak paket yang ingin dikirim : ");
        m = scan.nextInt();

        for (int i = 0; i < m; i++) {
            harga = 0;
            System.out.println("Pilih transportasi : \n" +
                    "1. Transportasi Darat \n" +
                    "2. Transportasi Laut \n" +
                    "3. Transportasi Udara");
            n = scan.nextInt();

            System.out.print("Masukkan Berat Berang : ");
            berat = scan.nextFloat();
            System.out.println("Apakah Barang Berharga ?");
            berharga = scan.nextBoolean();

            switch (n) {
                case 1:
                    harga = InputDarat();
                    System.out.println("Biaya transportasi darat : "+harga);
                    break;
                case 2:
                    harga = InputLaut();
                    System.out.println("Biaya transportasi laut : "+harga);
                    break;
                case 3:
                    harga = InputUdara();
                    System.out.println("Biaya transportasi udara : "+harga);
                    break;
            }

            total += harga;
        }
        System.out.println("Biaya Total : "+total);
    }

    private static double InputDarat(){
        return Controller.countBiayaDarat(berat,berharga);
    }

    private static double InputLaut(){
        boolean asuransi;
        String namaDimensi = "";

        System.out.println("Apakah ingin pakai asuransi ? ");
        asuransi = scan.nextBoolean();

        for(int i=0; i<3; i++){
            switch (i) {
                case 0:
                    namaDimensi = "Panjang";
                    break;
                case 1:
                    namaDimensi = "Lebar";
                    break;
                case 2:
                    namaDimensi = "Tinggi";
                    break;
            }
            System.out.println("Masukkan dimensi"+ namaDimensi +" barang : ");
            dimensi[i] = scan.nextFloat();
        }

        return Controller.countBiayaLaut(berat,berharga,asuransi,dimensi);
    }

    private static double InputUdara(){
        JenisPengiriman jenis;
        String namaDimensi = "";

        System.out.println("Jenis Pengiriman (ekspress / reguler)");
        String tempJenis = scan.nextLine();

        if(tempJenis.equalsIgnoreCase("ekspress")){
            jenis = JenisPengiriman.EKSPRESS;
        }else{
            jenis = JenisPengiriman.REGULER;
        }

        for(int i=0; i<3; i++){
            switch (i) {
                case 0:
                    namaDimensi = "Panjang";
                    break;
                case 1:
                    namaDimensi = "Lebar";
                    break;
                case 2:
                    namaDimensi = "Tinggi";
                    break;
            }
            System.out.println("Masukkan dimensi"+ namaDimensi +" barang : ");
            dimensi[i] = scan.nextFloat();
        }

        return Controller.countBiayaUdara(berat,berharga,dimensi,jenis);
    }
}
