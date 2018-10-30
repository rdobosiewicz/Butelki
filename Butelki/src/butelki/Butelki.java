/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butelki;

/**
 *
 * @author Dell
 */
public class Butelki {

    /**
     * @param args the command line arguments
     */
    
    private double pojemnosc;
    private double maxPojemnosc=15;
    private double roznica;
    private int idButelki;
    
    Butelki(double pojemnosc,int id)
    {
        if(pojemnosc<this.maxPojemnosc+1)
        {
            if (pojemnosc<1)
                {
                    System.out.println("Nie można podać minusowej wartości do pojemności butelki");
                }
            else
                {
                     this.pojemnosc=pojemnosc;
                     this.idButelki=id;
                }
        }
        else
        {
            this.pojemnosc=maxPojemnosc;
            this.roznica=pojemnosc-maxPojemnosc;
            this.idButelki=id;
            System.out.println("Zabrakło miejsca w butelce o id "+this.idButelki+" !! Maksymalna pojemnosc to 15 l. Zostało "+this.roznica+ " l do przelania");
        }  
        
    }
    
    int getIdButelki()
    {
        return idButelki;
    }
    
    double getPojemnosc()
    {
        return pojemnosc;
    }
    
    double getRoznica()
    {
        return roznica;
    }
    
    void wlej(double ilosc)
    {
       if(ilosc-1<this.maxPojemnosc-this.pojemnosc)
           if (ilosc<1)
            {
                System.out.println("Nie można wlać, zła wartość");
            }
           else
            {
                 this.pojemnosc+=ilosc;
            }
       else
       {
            this.roznica=ilosc-(this.maxPojemnosc-this.pojemnosc);
            this.pojemnosc=this.maxPojemnosc;
            System.out.println("Zabrakło miejsca w butelce nr "+this.idButelki+" !! Maksymalna pojemnosc to 15 l. Zostało "+this.roznica+" l do przelania");
       }     
    }
    
    void wylej(double ilosc)
    {
        if(ilosc<this.pojemnosc+1)
            this.pojemnosc-=ilosc;
        else
            System.out.println("Nie można wylać wiecej wody, niż posiadasz");
    }
    
    void przelej(double ilosc, Butelki gdziePrzelac, Butelki gdzieWylac)
    {
        if(ilosc-1<gdzieWylac.getPojemnosc())
        {   
            if (ilosc<1)
            {
                System.out.println("Nie mozna przelac, zla wartosc przelania");
            }
            else
            {
                gdzieWylac.wylej(ilosc);
                gdziePrzelac.wlej(ilosc);
            }
        }  
        else
            System.out.println("Z mało wody w butelce");
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Butelki[] butelka=new Butelki[50];
        
        for (int i=0; i<50; i++)
        {
            butelka[i]=new Butelki(10,i);
        }
        
        butelka[3].wlej(2);
        butelka[4].wlej(3);
       
        butelka[5].wylej(10);
        
        butelka[10].przelej(5, butelka[11],butelka[10]);
        
        System.out.println("W butelce o id "+butelka[5].getIdButelki()+" jest "+butelka[5].getPojemnosc());
        System.out.println("W butelce o id "+butelka[3].getIdButelki()+" jest "+butelka[3].getPojemnosc());
        System.out.println("W butelce o id "+butelka[4].getIdButelki()+" jest "+butelka[4].getPojemnosc());
        System.out.println("W butelce o id "+butelka[11].getIdButelki()+" jest "+butelka[11].getPojemnosc());
        System.out.println("W butelce o id "+butelka[10].getIdButelki()+" jest "+butelka[10].getPojemnosc());
    }
    
}
