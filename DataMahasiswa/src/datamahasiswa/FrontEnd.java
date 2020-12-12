/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.text.ParseException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class FrontEnd {
    Scanner input = new Scanner(System.in);
    Date ttl = new Date();
    SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
    
    String menuUtama(){
        System.out.println("*****************************");     
        System.out.println("1. Tambah Data\n"+"2. Hapus Data\n"+"3. Cari Data\n"+"4. Tampil Data\n");
        System.out.print("Masukkan pilihan menu : ");
        String pilihMenu = input.next();
        System.out.println("*****************************");        
        return pilihMenu;
    }
    
    HashMap dataTambah(){
        HashMap data;
        data = new HashMap();
        System.out.println("*****************************");
        System.out.print("Masukkan NIM : ");
        String nim = input.next();
        data.put("nim",nim);
        System.out.print("Masukkan Nama : ");
        String nama = input.next();
        data.put("nama",nama);
        while(true){
            System.out.print("Masukkan Tanggal Lahir format (dd/mm/yyyy): ");
            String ttlInput = input.next();
            try {
                ttl = formater.parse(ttlInput);
                data.put("ttl",ttl);
                break;
            } catch (ParseException ex) {
                System.out.println("Format Tanggal Salah, Ulangi lagi !");
                continue;
            }
        }
        
        while(true){
            System.out.print("Masukkan Gender (0: pria,1: Wanita) : ");
            Integer gender = input.nextInt();
            if (gender == 0 || gender == 1){
                data.put("gender",gender);
                break;
            }else{
                System.out.println("input Salah");
                continue;
            }
        }
        System.out.println("*****************************");
        return data;
    }
    
    String hapusData(){
        System.out.println("*****************************");
        System.out.println("Masukkan NIM dari data yang ingin dihapus : ");
        String cari = input.next();
        System.out.println("*****************************");
        return cari;
    }
    
    
    String cariData(){
        System.out.println("*****************************");
        System.out.println("1. Menggunkan NIM\n"+"2. Menggunakan Gender\n");
        System.out.println("Masukkan Pilihan Metode Pencarian yang diinginkan : ");
        String metodePilihan = input.next();
        System.out.println("*****************************");
        return metodePilihan;
    }
    
    String cariNIM(){
        System.out.println("*****************************");
        System.out.print("Masukkan Nim yang akan dicari : ");
        String nim = input.next();
        System.out.println("*****************************");
        return nim;
    }
    
    String cariGender(){
        System.out.println("*****************************");
        System.out.print("Masukkan Gender yang akan dicari : ");
        String Gender = input.next();
        System.out.println("*****************************");
        return Gender;
    }
    
    void tampilData(ArrayList data){
        System.out.println("*****************************");
        System.out.println(data);
        System.out.println("*****************************");
    }
    
}
