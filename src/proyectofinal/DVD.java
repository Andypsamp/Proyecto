package proyectofinal;
public class DVD extends Almacen{
    int Nro_DVD;
    int Estado_DVD;
    public DVD(){}
    public DVD(int N, int E,String C, String T, String D, String G)
    {
        super(C, T, D, G);
        this.Nro_DVD=N;
        this.Estado_DVD=E;
    }
    
    public static int Busca_DVD_Numero(int N, DVD ListaDVD[],int pos)
    {   int pos_aux=0,i=0,bnd=0;
        while (i<pos && bnd==0)
        {
            if(ListaDVD[i].Nro_DVD==N && ListaDVD[i].Estado_DVD==1)
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
    public static int Busca_DVD_Titulo(String T, DVD ListaDVD[],int pos)
    {   int pos_aux=0,i=0,bnd=0;
        while (i<pos && bnd==0)
        {
            if(ListaDVD[i].Titulo.equals(T) && ListaDVD[i].Estado_DVD==1)
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
    
    public static void Ordena_DVD_Titulo(DVD ListaDVD[],int pos)
    {  
        
    } 
    public static void Muestra_DVD(int pos,DVD ListaDVD[])
    {   int i=0,bnd=0;
        System.out.println("Nro \t CONTENIDO \t TITULO \t DETALLE \t GENERO \n");    
        for(i=0;i<pos;i++)
        {
            if(ListaDVD[i].Estado_DVD==1)
            {
                System.out.println(ListaDVD[i].Nro_DVD+"\t"+ListaDVD[i].Contenido+"\t"+ListaDVD[i].Titulo+"\t"+ ListaDVD[i].Detalle+"\t"+ListaDVD[i].Genero+"\n");
            }
        }
        
    }  
    public static void Muestra_DVD_Numero(int pos_aux,DVD ListaDVD[])
    {   int i=0,bnd=0;
        if(pos_aux!=-1)
        {
            System.out.println("Nro \t CONTENIDO \t TITULO \t DETALLE \t GENERO \n");
            System.out.println(ListaDVD[pos_aux].Nro_DVD+"\t"+ListaDVD[pos_aux].Contenido+"\t"+ListaDVD[pos_aux].Titulo+"\t"+ ListaDVD[pos_aux].Detalle+"\t"+ListaDVD[pos_aux].Genero+"\n");
        }
        else
        {
            System.out.println("No existe ese Numero de DVD");
        }
    }  
    public static void Eliminar_Registro(DVD [] ListaDVD, int num, int pos)
    {
        int pos_aux;
        pos_aux=DVD.Busca_DVD_Numero(num, ListaDVD, pos);
        if(pos_aux!=-1)
        {
        ListaDVD[pos_aux].Estado_DVD=0;       
        }
        else
        {
            System.out.println("No existe ese numero");
        }
        
    }
    public static void Modifica_Registro(DVD [] ListaDVD, int pos, String C,String T, String D, String G)
    {
        ListaDVD[pos].Contenido=C;
        ListaDVD[pos].Titulo=T;
        ListaDVD[pos].Detalle=D;
        ListaDVD[pos].Genero=G;
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


