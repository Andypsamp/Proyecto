package proyectofinal;
import java.util.ArrayList;
public class CD extends Almacen{
    int Nro_CD;
    int Estado_CD;
    public CD(){}
    public CD(int N, int E,String C, String T, String D, String G)
    {
        super(C, T, D, G);
        this.Nro_CD=N;
        this.Estado_CD=E;
    }
    
    public static int Busca_CD_Numero(int N, CD ListaCD[],int pos)
    {   int pos_aux=0,i=0,bnd=0;
        while (i<pos && bnd==0)
        {
            if(ListaCD[i].Nro_CD==N && ListaCD[i].Estado_CD==1)
            {
                pos_aux=i;
                bnd=1;
            }
            i++;
        }
        if(bnd==1)
        {
            return pos_aux;            
        }
        else
        {
            return -1;
        }
    }   
    public static int Busca_CD_Titulo(String T, CD ListaCD[],int pos)
    {   int pos_aux=0,i=0,bnd=0;
        while (i<pos && bnd==0)
        {
            if(ListaCD[i].Titulo.equals(T) && ListaCD[i].Estado_CD==1)
            {
                pos_aux=i;
                bnd=1;
            }
            i++;
        }
        if(bnd==1)
        {
            return pos_aux;            
        }
        else
        {
            return -1;
        }
    } 
    
    public static void Ordena_CD_Titulo(CD ListaCD[],int pos)
    {  
        
    } 
    public static void Muestra_CD(int pos,CD ListaCD[])
    {   int i=0,bnd=0;
        System.out.println("Nro \t CONTENIDO \t TITULO \t DETALLE \t GENERO \n");    
        for(i=0;i<pos;i++)
        {
            if(ListaCD[i].Estado_CD==1)
            {
                System.out.println(ListaCD[i].Nro_CD+"\t"+ListaCD[i].Contenido+"\t"+ListaCD[i].Titulo+"\t"+ ListaCD[i].Detalle+"\t"+ListaCD[i].Genero+"\n");
            }
        }
        
    }  
    public static void Muestra_CD_Numero(int pos_aux,CD ListaCD[])
    {   int i=0,bnd=0;
        if(pos_aux!=-1)
        {
            System.out.println("Nro \t CONTENIDO \t TITULO \t DETALLE \t GENERO \n");
            System.out.println(ListaCD[pos_aux].Nro_CD+"\t"+ListaCD[pos_aux].Contenido+"\t"+ListaCD[pos_aux].Titulo+"\t"+ ListaCD[pos_aux].Detalle+"\t"+ListaCD[pos_aux].Genero+"\n");
        }
        else
        {
            System.out.println("No existe ese Numero de CD");
        }
    }  
    public static void Eliminar_Registro(CD [] ListaCD, int num, int pos)
    {
        int pos_aux;
        pos_aux=CD.Busca_CD_Numero(num, ListaCD, pos);
        if(pos_aux!=-1)
        {
            ListaCD[pos_aux].Estado_CD=0;       
        }
        else
        {
            System.out.println("No existe ese numero");
        }
        
    }
    public static void Modifica_Registro(CD [] ListaCD, int pos, String C,String T, String D, String G)
    {
        ListaCD[pos].Contenido=C;
        ListaCD[pos].Titulo=T;
        ListaCD[pos].Detalle=D;
        ListaCD[pos].Genero=G;
    }
    public static String LeeContenido(int op)
    {
        String cont="";
        switch(op)
        {
            case 1:
                cont= "Pelicula";
                break;
            case 2:
                cont="Libro" ;
                break;
            case 3:
                cont="Cancion";
                break;
            case 4:
                cont="MP3";
                break;
        }
        return cont;
    }
    public static String LeeGenero(int op, int op1)
    {
        String cont="";
         if(op1==1 || op1== 2)
         {
            switch(op)
            {
                case 1:
                    cont= "Romantica";
                    break;
                case 2:
                    cont="Drama" ;
                    break;
                case 3:
                    cont="Suspenso";
                    break;
            }
         }
         else
         {
             switch(op)
            {
                case 1:
                    cont= "Rock";
                    break;
                case 2:
                    cont="Electronico" ;
                    break;
                case 3:
                    cont="Reggeton";
                    break;
            }
         }
        return cont;
    }
}
