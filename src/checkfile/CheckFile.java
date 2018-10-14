/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class CheckFile {

    /**
     * @param args the command line arguments
     */
    static String rs = "";
//    read file with BufferedReader
    public static void readFile(File patha, ArrayList a) throws FileNotFoundException, IOException{
        FileReader repath = new FileReader(patha);
        BufferedReader br = new BufferedReader(repath);
        String line;
        while ((line = br.readLine()) != null){
            a.add(line);
     }   
     repath.close();
     br.close();   
    }
   
    //    check type .txt
    public boolean accept(File pathname) {
 
        if (!pathname.isFile()) {
            return false;
        }
 
        if (pathname.getAbsolutePath().endsWith(".txt") ) {
            return true;
        }
 
        return false;
    }
    public void fetchChild(File file,String a) throws IOException {
          
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
 
            File[] children = file.listFiles();
 
            for (File child : children) {
                // Đệ quy (Recursive)
                this.fetchChild(child, a);
            }
        }
        else{
            if(accept(file)==true){
                ArrayList<String> arrayList =  new ArrayList<>();
                readFile(file,arrayList);
                
                String content  = "";
                
                for(int i =0 ; i< arrayList.size();i++)
                {
                    content = content.concat(arrayList.get(i));
                }
                
                if(content.contains(a)){
            
                rs += file.getAbsolutePath() + "\n";
                }
                arrayList.clear();
                
            }
            
        
            
    }}
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhap thu muc"
                + " (ex: D:/): ");
        String dir= ip.nextLine();
        
        File apath = new File(dir);
        System.out.println("Chuoi can tim: ");
        String cantim = ip.nextLine();
        System.out.println("///////////////////////////////////////");
        CheckFile a = new CheckFile();
        a.fetchChild(apath,cantim);
        System.out.println("///////////////////////////////////////");
        System.out.println("Chuoi duoc tim thay tai: ");
        if(rs==""){
            System.out.println("Chuoi khong duoc tim thay!!!!");
        }
        else System.out.println(rs);
    }
    
}
