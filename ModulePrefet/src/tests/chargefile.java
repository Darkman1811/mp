/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author super
 */
public class chargefile {
    public static void main (String [] args) throws IOException{
       // System.out.println("tests");
        File dir = new File("./src/tests");
        File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
        FileInputStream fis = new FileInputStream(fin);
        
       
	//Construct BufferedReader from InputStreamReader
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
        
        Map listRegion=new HashMap<String, Integer>();
        Map listDepartement=new HashMap<String, Integer>();
        //SortedSet <String>listCommune=new TreeSet();
        Map listCommune=new HashMap<String,Integer>();
        //SortedSet <String>listCV=new TreeSet();
        Map listCV=new HashMap<String,Integer>();
        Map listBV=new HashMap<List<String>,Integer>();
       
	while ((line = br.readLine()) != null) {
                String[] lines=line.split(";");
                
                //listRegion.add(lines[1]);   
                listRegion.put(lines[1],0);
                //listDepartement.add(lines[1]+";"+lines[2]);  
                listDepartement.put(lines[2], lines[1]);
                listCommune.put(lines[3], lines[2]);
                //listCommune.add(lines[2]+";"+lines[3]); 
               
               // for(int i=4;i<lines.length;i++){
                int i=4;
                while(i<lines.length){  
                    
                    if(lines[i].contains("/")){i+=1;continue;}
               // listCV.add(lines[2]+";"+lines[3]+";"+lines[i]); 
                    
                    listCV.put(lines[i], lines[3]);
                    List<String> bv = new ArrayList<>();
                    if (lines.length > i+3) {
                        bv.add(lines[i + 1]);
                        bv.add(lines[i + 2]);
                        bv.add(lines[i + 3]);
                        listBV.put(bv, lines[i]);
                    }
                  
                i+=4;
                }
	}
        
        //ecriture des regions
        Iterator itRegion=listRegion.keySet().iterator();   
        
        File fout = new File("./src/tests/regions.csv");
	FileOutputStream fos = new FileOutputStream(fout); 
	OutputStreamWriter osw = new OutputStreamWriter(fos);
        Integer ir=0;
        while(itRegion.hasNext()){
            ir++;
            String reg=(String) itRegion.next();
            listRegion.put(reg,ir);
            osw.write(ir.toString()+";"+reg+"\n");
            osw.flush();
        }
        osw.close();
       
         //ecriture des departements       
        File foutDep = new File("./src/tests/departements.csv");
	FileOutputStream fosDep = new FileOutputStream(foutDep); 
	OutputStreamWriter oswDep = new OutputStreamWriter(fosDep);
        Iterator itDepartement=listDepartement.keySet().iterator();
        Integer id=0;
        while(itDepartement.hasNext()){
            id++;
            String dep=(String) itDepartement.next();
            String region=(String)listDepartement.get(dep);                     //Pour l'instant la valeur stocké est le nom du département auquel il appartient
            Integer idREgion=(Integer)listRegion.get(region);
            listDepartement.put(dep, id);
            oswDep.write(id.toString()+";"+dep+";"+idREgion+"\n");
            oswDep.flush();
        }
        oswDep.close();
         
        //ecriture des communes       
        File foutCom = new File("./src/tests/communes.csv");
	FileOutputStream fosCom = new FileOutputStream(foutCom); 
	OutputStreamWriter oswCom = new OutputStreamWriter(fosCom);
        Iterator itCommune=listCommune.keySet().iterator();
        Integer ic=0;
        while(itCommune.hasNext()){
           ic++;
            String com=(String) itCommune.next();
            String dep=(String)listCommune.get(com);                            //Pour l'instant la valeur stocké est le nom du département auquel il appartient
            Integer idDepartement=(Integer)listDepartement.get(dep);            //Recuperer l'id du department à partir de son nom sur le map des departements
            listCommune.put(com, ic);
            oswCom.write(ic.toString()+";"+com+";"+idDepartement+"\n");
            oswCom.flush();
        }
        oswCom.close();
        
        //ecriture des centres de vote       
        File foutCV = new File("./src/tests/centresdevote.csv");
	FileOutputStream fosCV = new FileOutputStream(foutCV); 
	OutputStreamWriter oswCV = new OutputStreamWriter(fosCV);
        Iterator itcentre=listCV.keySet().iterator();
        Integer icv=0;
        while(itcentre.hasNext()){
           icv++;
            String cv=(String) itcentre.next();
            String com=(String)listCV.get(cv);                            
            Integer idCommune=(Integer)listCommune.get(com);          
            listCV.put(cv, icv);
            oswCV.write(icv.toString()+";"+cv+";"+idCommune+"\n");
            oswCV.flush();
        }
        oswCV.close();
        
        //ecriture des bureaux de vote       
        File foutBV = new File("./src/tests/bureauxdevote.csv");
	FileOutputStream fosBV = new FileOutputStream(foutBV); 
	OutputStreamWriter oswBV = new OutputStreamWriter(fosBV);
        Iterator itbureau=listBV.keySet().iterator();
        Integer ibv=0;
        while(itbureau.hasNext()){
           ibv++;
            List<String> bv=(List<String>) itbureau.next();
            String cv=(String)listBV.get(bv);                            
            Integer idCV=(Integer)listCV.get(cv);          
            //listCV.put(cv, icv);
            StringBuffer sb=new StringBuffer();
            sb.append(ibv.toString());
            sb.append(";");
            sb.append(bv.get(0));
            sb.append(";");
            sb.append(bv.get(1));
            sb.append(";");
            sb.append(bv.get(2));
            sb.append(";");
            sb.append(idCV);
            sb.append("\n");
            oswBV.write(sb.toString());
            oswBV.flush();
        }
        oswBV.close();
        /*
        int i=0;
        Iterator itCV=listCV.iterator();
        while(itCV.hasNext()){ 
            System.out.println(i++);          
            String cv=(String) itCV.next();
            System.out.println(cv);
        }
 */
	br.close();
    }
    
    public static void ecrire(String ficher,String value) throws FileNotFoundException, IOException{       
        File fout = new File(ficher);
	FileOutputStream fos = new FileOutputStream(fout); 
	OutputStreamWriter osw = new OutputStreamWriter(fos);
         osw.write(value);
            osw.flush();
    }
    
}
