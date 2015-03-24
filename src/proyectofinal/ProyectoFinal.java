package proyectofinal;

import java.io.File;
import java.util.Scanner;

public class ProyectoFinal {

    public static void main(String[] args) {
        int op, op1, op2, op3, op5, N, posCD = 0, posDVD = 0, pos_aux, num;
        String C, T, D, G;
        int opC;
        CD[] ListaCD = new CD[1000];
        CD DatosCD = null;
        DVD[] ListaDVD = new DVD[1000];
        DVD DatosDVD = null;
        File FficheroCD = new File("ListaCD.txt");
        File FficheroDVD = new File("ListaDVD.txt");
        Scanner lector = new Scanner(System.in);
        posCD = Fichero.CargarFicheroCD(FficheroCD, ListaCD, DatosCD);
        posDVD = Fichero.CargarFicheroDVD(FficheroDVD, ListaDVD, DatosDVD);
        System.out.println("Cantidad de CD cargadas:" + posCD);
        System.out.println("Cantidad de +DVD cargadas:" + posDVD);
        do {
            System.out.println("     ESTANTE DE CD O DVD      ");
            System.out.println("1. Registrar CD o DVD");
            System.out.println("2. Borrar CD o DVD danado");
            System.out.println("3. Corregir informacion registrada de CD o DVD");
            System.out.println("4. Listado de CD y DVD");
            System.out.println("5. Busqueda de informacion por Titulo de CD o DVD");
            System.out.println("6. Busqueda de informacion por Nro de CD o DVD");
            System.out.println("7. Salir");
            System.out.println("Elija una opcion:");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.println("    REGISTRAR DE CD O DVD     ");
                        System.out.println("1. Registrar CD");
                        System.out.println("2. Registrar DVD");
                        System.out.println("3. Volver a Menu Principal");
                        System.out.println("Elija una opcion: ");
                        op1 = lector.nextInt();
                        switch (op1) {
                            case 1:
                                N = posCD + 1;
                                System.out.println("Nro CD:" + N);
                                do {
                                    System.out.println("1. Pelicula \t 2. Libro \t 3. Cancion \t 4.MP3");
                                    System.out.println("Ingrese Contenido:");
                                    op3 = lector.nextInt();
                                } while (op3 != 1 && op3 != 2 && op3 != 3 && op3 != 4);
                                C = CD.LeeContenido(op3);
                                lector.nextLine();
                                System.out.println("Ingrese Titulo:");
                                T = lector.nextLine();
                                System.out.println("Ingrese Detalle:");
                                D = lector.next();
                                do {
                                    if (op3 == 1 || op3 == 2) {
                                        System.out.println("1. Romantica \t 2. Drama \t 3. Suspenso ");
                                    } else {
                                        System.out.println("1. Rock \t 2. Electronico \t 3. Reggeton  ");
                                    }
                                    System.out.println("Ingrese Genero:");
                                    op2 = lector.nextInt();
                                } while (op2 != 1 && op2 != 2 && op2 != 3);
                                G = CD.LeeGenero(op2, op3);
                                DatosCD = new CD(N, 1, C, T, D, G);
                                ListaCD[posCD] = DatosCD;
                                posCD++;
                                Fichero.EcribirFicheroCD(FficheroCD, DatosCD);
                                break;
                            case 2:
                                N = posDVD + 1;
                                System.out.println("Nro DVD:" + N);
                                do {
                                    System.out.println("1. Pelicula \t 2. Libro \t 3. Cancion \t 4. MP3");
                                    System.out.println("Ingrese Contenido:");
                                    op3 = lector.nextInt();
                                } while (op3 != 1 && op3 != 2 && op3 != 3 && op3 != 4);
                                C = DVD.LeeContenido(op3);
                                lector.nextLine();
                                System.out.println("Ingrese Titulo:");
                                T = lector.nextLine();
                                System.out.println("Ingrese Detalle:");
                                D = lector.next();
                                do {
                                    if (op3 == 1 || op3 == 2) {
                                        System.out.println("1. Romantica \t 2. Drama \t 3. Suspenso ");
                                    } else {
                                        System.out.println("1. Rock \t 2. Electronico \t 3. Reggeton  ");
                                    }
                                    System.out.println("Ingrese Genero:");
                                    op2 = lector.nextInt();
                                } while (op2 != 1 && op2 != 2 && op2 != 3);
                                G = DVD.LeeGenero(op2, op3);
                                DatosDVD = new DVD(N, 1, C, T, D, G);
                                ListaDVD[posDVD] = DatosDVD;
                                posDVD++;
                                Fichero.EcribirFicheroDVD(FficheroDVD, DatosDVD);
                                break;
                        }
                    } while (op1 != 3);
                    break;
                case 2:
                    do {
                        System.out.println("    ELIMINAR DE CD O DVD     ");
                        System.out.println("1. Eliminar CD");
                        System.out.println("2. Eliminar DVD");
                        System.out.println("3. Volver a Menu Principal");
                        System.out.println("Elija una opcion:");
                        op1 = lector.nextInt();
                        switch (op1) {
                            case 1:
                                System.out.println("Ingrese el Numero de CD dañado");
                                num = lector.nextInt();
                                pos_aux = CD.Busca_CD_Numero(num, ListaCD, posCD);
                                CD.Muestra_CD_Numero(pos_aux, ListaCD);
                                CD.Eliminar_Registro(ListaCD, num, posCD);
                                CD.Muestra_CD(posCD, ListaCD);
                                Fichero.BorrarFichero(FficheroCD);
                                int cont = 0;
                                for (int i = 0; i < posCD; i++) {
                                    if (ListaCD[i].Estado_CD == 1) {
                                        Fichero.EcribirFicheroCD(FficheroCD, ListaCD[i]);
                                        cont++;
                                    }
                                }
                                posCD = cont;
                                break;
                            case 2:
                                System.out.println("Ingrese el Numero de DVD dañado:");
                                num = lector.nextInt();
                                pos_aux = DVD.Busca_DVD_Numero(num, ListaDVD, posDVD);
                                DVD.Muestra_DVD_Numero(pos_aux, ListaDVD);
                                DVD.Eliminar_Registro(ListaDVD, num, posDVD);
                                DVD.Muestra_DVD(posDVD, ListaDVD);
                                Fichero.BorrarFichero(FficheroDVD);
                                int cont1 = 0;
                                for (int i = 0; i < posDVD; i++) {
                                    if (ListaDVD[i].Estado_DVD == 1) {
                                        Fichero.EcribirFicheroDVD(FficheroDVD, ListaDVD[i]);
                                        cont1++;
                                    }
                                }
                                posDVD = cont1;
                                break;
                        }
                    } while (op1 != 3);

                    break;
                case 3:
                    do {
                        System.out.println("   MODIFICAR DE CD O DVD    ");
                        System.out.println("1. Modificar CD");
                        System.out.println("2. Modificar DVD");
                        System.out.println("3. Volver a Menu Principal");
                        System.out.println("Elija una opcion:");
                        op1 = lector.nextInt();
                        switch (op1) {
                            case 1:
                                System.out.println("Ingrese el Numero de CD para modificar");
                                num = lector.nextInt();
                                pos_aux = CD.Busca_CD_Numero(num, ListaCD, posCD);
                                if (pos_aux != -1) {
                                    CD.Muestra_CD_Numero(pos_aux, ListaCD);
                                    op3 = 0;
                                    C = T = D = G = "";
                                    System.out.println("Desea modificar Contenido??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        do {
                                            System.out.println("1. Pelicula \t 2. Libro \t 3. Cancion \t 4.MP3");
                                            System.out.println("Modifique Contenido...");
                                            op3 = lector.nextInt();
                                        } while (op3 != 1 && op3 != 2 && op3 != 3 && op3 != 4);
                                        C = CD.LeeContenido(op3);
                                    } else {
                                        C = ListaCD[pos_aux].Contenido;
                                    }
                                    System.out.println("Desea modificar Titulo??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        System.out.println("Modifique Titulo:");
                                        T = lector.nextLine();
                                    } else {
                                        T = ListaCD[pos_aux].Titulo;
                                    }
                                    System.out.println("Desea modificar Detalle??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        System.out.println("Modifique Detalle:");
                                        D = lector.next();
                                    } else {
                                        D = ListaCD[pos_aux].Detalle;
                                    }
                                    System.out.println("Desea modificar Genero??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        do {
                                            if (ListaCD[pos_aux].Contenido == "Pelicula" || ListaCD[pos_aux].Contenido == "Libro") {
                                                System.out.println("1. Romantica \t 2. Drama \t 3. Suspenso ");
                                            } else {
                                                System.out.println("1. Rock \t 2. Electronico \t 3. Reggeton  ");
                                            }
                                            System.out.println("Modifique Genero:");
                                            op2 = lector.nextInt();
                                        } while (op2 != 1 && op2 != 2 && op2 != 3);
                                        System.out.println("op3" + op3 + C + T + D + G);
                                        G = CD.LeeGenero(op2, op3);
                                    } else {
                                        G = ListaCD[pos_aux].Genero;
                                    }
                                    CD.Modifica_Registro(ListaCD, pos_aux, C, T, D, G);
                                    CD.Muestra_CD(posCD, ListaCD);
                                    Fichero.BorrarFichero(FficheroCD);
                                    for (int i = 0; i < posCD; i++) {
                                        if (ListaCD[i].Estado_CD == 1) {
                                            Fichero.EcribirFicheroCD(FficheroCD, ListaCD[i]);
                                        }
                                    }
                                } else {
                                    System.out.println("NO existe ese numero de CD");
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el Numero de DVD para modificar");
                                num = lector.nextInt();
                                pos_aux = DVD.Busca_DVD_Numero(num, ListaDVD, posDVD);
                                if (pos_aux != -1) {
                                    DVD.Muestra_DVD_Numero(pos_aux, ListaDVD);
                                    op3 = 0;
                                    C = T = D = G = "";
                                    System.out.println("Desea modificar Contenido??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        do {
                                            System.out.println("1. Pelicula \t 2. Libro \t 3. Cancion \t 4.MP3");
                                            System.out.println("Modifique Contenido:");
                                            op3 = lector.nextInt();
                                        } while (op3 != 1 && op3 != 2 && op3 != 3 && op3 != 4);
                                        C = DVD.LeeContenido(op3);
                                    } else {
                                        C = ListaDVD[pos_aux].Contenido;
                                    }
                                    System.out.println("Desea modificar Titulo??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        System.out.println("Modifique Titulo:");
                                        T = lector.nextLine();
                                    } else {
                                        T = ListaDVD[pos_aux].Titulo;
                                    }
                                    System.out.println("Desea modificar Detalle??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        System.out.println("Modifique Detalle:");
                                        D = lector.next();
                                    } else {
                                        D = ListaDVD[pos_aux].Detalle;
                                    }
                                    System.out.println("Desea modificar Genero??? 1-Si 2-No ");
                                    opC = lector.nextInt();
                                    if (opC == 1) {
                                        do {
                                            if (ListaDVD[pos_aux].Contenido == "Pelicula" || ListaDVD[pos_aux].Contenido == "Libro") {
                                                System.out.println("1. Romantica \t 2. Drama \t 3. Suspenso ");
                                            } else {
                                                System.out.println("1. Rock \t 2. Electronico \t 3. Reggeton  ");
                                            }
                                            System.out.println("Modifique Genero:");
                                            op2 = lector.nextInt();
                                        } while (op2 != 1 && op2 != 2 && op2 != 3);
                                        System.out.println("op3" + op3 + C + T + D + G);
                                        G = DVD.LeeGenero(op2, op3);
                                    } else {
                                        G = ListaDVD[pos_aux].Genero;
                                    }
                                    DVD.Modifica_Registro(ListaDVD, pos_aux, C, T, D, G);
                                    DVD.Muestra_DVD(posDVD, ListaDVD);
                                    Fichero.BorrarFichero(FficheroDVD);
                                    for (int i = 0; i < posDVD; i++) {
                                        if (ListaDVD[i].Estado_DVD == 1) {
                                            Fichero.EcribirFicheroDVD(FficheroDVD, ListaDVD[i]);
                                        }
                                    }
                                } else {
                                    System.out.println("NO existe ese numero de DVD");
                                }
                                break;
                        }
                    } while (op1 != 3);
                    break;
                case 4:
                    System.out.println("Lista de CD");
                    CD.Muestra_CD(posCD, ListaCD);
                    System.out.println("Lista de DVD");
                    DVD.Muestra_DVD(posDVD, ListaDVD);
                    break;
                case 5:
                    do {
                        System.out.println("     BUSQUEDA DE CD O DVD POR TITULO      ");
                        System.out.println("1. Buscar CD");
                        System.out.println("2. Buscar DVD");
                        System.out.println("3. Volver a Menu Principal");
                        System.out.println("Elija una opcion:");
                        op1 = lector.nextInt();
                        switch (op1) {
                            case 1:
                                System.out.println("Ingrese el titulo de CD para buscar");
                                lector.nextLine();
                                T = lector.nextLine();
                                pos_aux = CD.Busca_CD_Titulo(T, ListaCD, posCD);
                                if (pos_aux != -1) {
                                    CD.Muestra_CD_Numero(pos_aux, ListaCD);
                                } else {
                                    System.out.println("No se ha encontrado ese titulo");
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el titulo de DVD para buscar");
                                lector.nextLine();
                                T = lector.nextLine();
                                pos_aux = DVD.Busca_DVD_Titulo(T, ListaDVD, posDVD);
                                if (pos_aux != -1) {
                                    DVD.Muestra_DVD_Numero(pos_aux, ListaDVD);
                                } else {
                                    System.out.println("No se ha encontrado ese titulo");
                                }
                                break;

                        }
                    } while (op1 != 3);
                    break;
                case 6:
                    do {
                        System.out.println("    BUSQUEDA DE CD O DVD POR NUMERO     ");
                        System.out.println("1. Buscar CD");
                        System.out.println("2. Buscar DVD");
                        System.out.println("3. Volver a Menu Principal");
                        System.out.println("Elija una opcion:");
                        op1 = lector.nextInt();
                        switch (op1) {
                            case 1:
                                System.out.println("Ingrese el Numero de CD para buscar");
                                N = lector.nextInt();
                                pos_aux = CD.Busca_CD_Numero(N, ListaCD, posCD);
                                if (pos_aux != -1) {
                                    CD.Muestra_CD_Numero(pos_aux, ListaCD);
                                } else {
                                    System.out.println("No se ha encontrado ese numero");
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el Numero de DVD para buscar");
                                N = lector.nextInt();
                                pos_aux = DVD.Busca_DVD_Numero(N, ListaDVD, posDVD);
                                if (pos_aux != -1) {
                                    DVD.Muestra_DVD_Numero(pos_aux, ListaDVD);
                                } else {
                                    System.out.println("No se ha encontrado ese numero");
                                }
                                break;
                        }
                    } while (op1 != 3);
            }
        } while (op != 7);

    }
}
