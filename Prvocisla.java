/*
 * totally free :D
 */
import java.util.*;
import java.io.*;

/**Program vypočítá zadaný počet prvočísel začínající od 1
 * a uloží je do souboru v aktuálním adresáři.
 * Při použití přepínače "-max" vypočte prvočísla menší než zadaná hodnota.
 * @author JH
 */
public class Prvocisla {
static File f;
static PrintWriter pw;
static FileOutputStream fw;
    /**
     * @param args the command line arguments, usable "-max"
     */
@SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean useMax;
        useMax = !((args.length < 1) || (args[0].equals("-max")));
        if(!((args.length < 1) || !(args[0].equals("help")) 
                || !args[0].equals("help")  
                || !args[0].equals("/?") )) 
        {System.out.println("use no or \"-max\" argument");
        System.exit(0);}
            
            if(useMax) System.out.print("max:");
            else System.out.print("amount:");
            int x = sc.nextInt();
            
        try {
            if(useMax)
                f = new File("Prvočísla menší než " + x + ".txt");
            else f = new File(x + " nejmenších prvočísel.txt");
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fw = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            pw = new PrintWriter(fw);
            
            int[] p = null;
            if(useMax) p = getPrvocisla(x);
            else p = getnPrvocisel(x);
            
            for(int j : p){
                if(j!=0) pw.print(j + "\r\n");
            }
            pw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Done.");
    }
    
    public static int[] getPrvocisla(int max){
        int[] p = new int[max];
        p[0] = 1;
        p[1] = 2;
        p[2] = 3;
        
        for(int i = 5; i <= max ; i = i + 2 ){
            for(int u = 1; /*p[u] != 0*/ ; u++ ){
                
                if(p[u]==0){
                //System.out.println(i + " uklada jako " + p[u] + " na " + u);
                p[u] = i;
                break;
                }
                
                if(i != p[u] & i % p[u] == 0){
                    //System.out.print(i + " je  delitelne " + p[u] + ";\n");
                    break;
                }//else System.out.print(i + " neni delitelne " + p[u] + " " + u + " ;\n");
                
            }
        }
        
        System.out.println("vypocet konec");
        
    return p;}
    
    public static int[] getnPrvocisel(int amount){
        if(amount<10) amount = 10;
        int[] p = new int[amount];
        p[0] = 1;
        p[1] = 2;
        p[2] = 3;
        
        for(int i = 5; p[amount-1]==0 ; i = i + 2 ){
            for(int u = 1; u <= amount ; u++ ){
                
                if(p[u]==0){
                //System.out.println(i + " uklada jako " + p[u] + " na " + u);
                p[u] = i;
                break;
                }
                
                if(i != p[u] & i % p[u] == 0){
                    //System.out.print(i + " je  delitelne " + p[u] + ";\n");
                    break;
                }//else System.out.print(i + " neni delitelne " + p[u] + " " + u + " ;\n");
                
            }
        }
        System.out.println("vypocet konec");
    return p;}
    
}
