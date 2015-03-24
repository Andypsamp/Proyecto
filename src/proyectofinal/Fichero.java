package proyectofinal;
import java.io.*;
import java.util.ArrayList;
public class Fichero {    
    public static void EcribirFicheroCD(File Ffichero, CD DatosCD) {
        try {  
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            try (
                    BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"))) {
                    Fescribe.write(DatosCD.Nro_CD + "\t" +DatosCD.Estado_CD+"\t"+ DatosCD.Contenido + "\t"+DatosCD.Titulo+"\t"+ DatosCD.Detalle+"\t"+DatosCD.Genero +"\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
      public static void EcribirFicheroDVD(File Ffichero, DVD DatosDVD) {
        try { 
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            try (
                    BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"))) {
                    Fescribe.write(DatosDVD.Nro_DVD + "\t" +DatosDVD.Estado_DVD+"\t"+ DatosDVD.Contenido + "\t"+DatosDVD.Titulo+"\t"+ DatosDVD.Detalle+"\t"+DatosDVD.Genero +"\n");
            }
        } catch (Exception ex) {  
            System.out.println(ex.getMessage());
        }
    }
    
    public static void LeerFichero(File Ffichero) {
        try {
            if (Ffichero.exists()) {
                BufferedReader Flee = new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while ((Slinea = Flee.readLine()) != null) {
                    System.out.println(Slinea);
                }
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }    
    public static int CargarFicheroCD(File Ffichero, CD [] ListaCD, CD DatosCD) {
        int pos=0;
        String [] Lista = null;
        try {
            if (Ffichero.exists()) {
                try (BufferedReader Flee = new BufferedReader(new FileReader(Ffichero))) {
                    String Slinea;
                    while ((Slinea = Flee.readLine()) != null) {
                        Lista=Slinea.split("\t");
                        DatosCD=new CD (Integer.parseInt(Lista[0]),Integer.parseInt(Lista[1]),Lista[2].toString(),Lista[3].toString(),Lista[4].toString(),Lista[5].toString());
                        ListaCD[pos]=DatosCD;                        
                        pos++;                        
                    }                    
                    return pos;
                }
            } else {
               System.out.println("Fichero No Existe");
               return pos;
            }           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pos;
    }
    public static int CargarFicheroDVD(File Ffichero, DVD [] ListaDVD, DVD DatosDVD) {
        int pos=0;
        String [] Lista = null;
        try {
            if (Ffichero.exists()) {
                try (BufferedReader Flee = new BufferedReader(new FileReader(Ffichero))) {
                    String Slinea;
                    while ((Slinea = Flee.readLine()) != null) {
                        Lista=Slinea.split("\t");
                        DatosDVD=new DVD (Integer.parseInt(Lista[0]),Integer.parseInt(Lista[1]),Lista[2].toString(),Lista[3].toString(),Lista[4].toString(),Lista[5].toString());
                        ListaDVD[pos]=DatosDVD;                        
                        pos++;                        
                    }          
                    return pos;
                }
            } else {
               System.out.println("Fichero No tiene registros");
               return pos;
            }           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pos;
    }
    public static  void BorrarFichero(File Ffichero){  
     try {    
         if(Ffichero.exists()){  
           Ffichero.delete();   
         }  
     } catch (Exception ex) {     
          System.out.println(ex.getMessage());  
     }  
} 
}
