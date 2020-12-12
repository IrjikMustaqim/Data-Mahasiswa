/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author user
 */
public class BackEnd {
    FrontEnd tampilan = new FrontEnd();
    ArrayList<HashMap> db = new ArrayList<>();
    
    void olahtambahData(){
        HashMap dataBaru = tampilan.dataTambah();
        db.add(dataBaru);
    }
    
    void olahHapusData(){
        String dataHapus = tampilan.hapusData();
        Boolean ada = false;
        for (HashMap i : db){
            String pencarian = (String) i.get("nim");
            if(pencarian == null ? dataHapus == null : pencarian.equals(dataHapus)){
                db.remove(i);
                ada = true;
                System.out.println("Data berhasil dihapus");
                break;
            }else{
                ada = false;           
            }
        }
        if (ada == false){
            System.out.println("Data tidak ada");
        }
        
    }
    
    void olahCariData(){
        Boolean ada = false;
        OUTER:
        while (true) {
            String metodPencari = tampilan.cariData();
            if (null == metodPencari) {
                System.out.println("Pilihan tidak ada");
            } else {
                switch (metodPencari) {
                    case "1":
                        {
                            String dataCari = tampilan.cariNIM();
                            for (HashMap i : db){
                                String pencarian = (String) i.get("nim");
                                if(dataCari == null ? pencarian == null : dataCari.equals(pencarian)){
                                    System.out.println(i);
                                    ada = true;              
                                   
                                }
                            }           break OUTER;
                        }
                    case "2":
                        {
                            String dataCari = tampilan.cariGender();
                            Integer h = Integer.parseInt(dataCari);
                            for (HashMap i : db){
                                if(i.get("gender") == h){
                                    System.out.println(i);
                                    ada = true;
                                    
                                }
                            }           break OUTER;
                        }
                    default:
                        System.out.println("Pilihan tidak ada");
                        break;
                }
            }
        }
        
        
    }
    
    void olahTampilData(){
        tampilan.tampilData(db);
    }
    
    void olahMenu(){
        String pilihMenu = tampilan.menuUtama();
        
        if (null == pilihMenu){
            System.out.println("Pilihan tidak ada`");
        }else switch (pilihMenu) {
            case "1":
                olahtambahData();
                break;
            case "2":
                olahHapusData();
                break;
            case "3":
                olahCariData();
                break;
            case "4":
                olahTampilData();
                break;
            default:
                System.out.println("Pilihan tidak ada`");
                break;
        }
    }
    
    
    
    
}
