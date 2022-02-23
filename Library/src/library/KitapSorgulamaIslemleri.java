/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;


/**
 *
 * @author hp
 */
public class KitapSorgulamaIslemleri implements Callable {  //use 'callable' to return value.
    
    int ogrencinumara ;       //'ogrencinumara' and 'kacincikitap' are values to be processed.                 
    int kacincikitap;
    boolean sifirincikitap = true ;  //Boolean expressions generated to check if one of the books exists.
    boolean birincikitap = true ;
    boolean ikincikitap = true;
    boolean ucuncukitap = true;
    boolean dorduncukitap = true;
    boolean besincikitap = true;

    public int getOgrencinumara() {     
        return ogrencinumara;
    }
                                        //'get' methods created to access it.
    public int getKacincikitap() {
        return kacincikitap;
    }
    
    //'set' methods created to change the state when we give and receive books.
    
    public void setSifirincikitap(boolean sifirincikitap) {        
        this.sifirincikitap = sifirincikitap;
    }
    
    public void setBirincikitap(boolean birincikitap) {
        this.birincikitap = birincikitap;
    }

    public void setIkincikitap(boolean ikincikitap) {
        this.ikincikitap = ikincikitap;
    }

    public void setUcuncukitap(boolean ucuncukitap) {
        this.ucuncukitap = ucuncukitap;
    }

    public void setDorduncukitap(boolean dorduncukitap) {
        this.dorduncukitap = dorduncukitap;
    }

    public void setBesincikitap(boolean besincikitap) {
        this.besincikitap = besincikitap;
    }

    //mechanism used to achieve synchronization and create critical section
    private static Semaphore mutex = new Semaphore(1);

    public KitapSorgulamaIslemleri(int ogrencinumara,int kacincikitap){
        this.ogrencinumara = ogrencinumara ;
        this.kacincikitap = kacincikitap;
    }
    
    @Override
    public Object call() throws Exception {
        
        if (kacincikitap==0 &&  sifirincikitap==true){  
            
            //The region where those who want to borrow the zeroth book from the library come.
            
            try {
                mutex.acquire();  //critical section start
                setSifirincikitap(false);  // the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));  
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");
                    setSifirincikitap(true);  //book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

                    mutex.release();   //end of critical section 
            }
            
        return ogrencinumara+","+kacincikitap ;
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (kacincikitap==1 &&  birincikitap==true){
            
            //The region where those who want to borrow the first book from the library come
            
            try {
                mutex.acquire();  //critical section start
                setBirincikitap(false);  // the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");                    
                    setBirincikitap(true);  //book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

                    mutex.release();   //end of critical section 
                    
            }
            
        return ogrencinumara+","+kacincikitap ; 
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (kacincikitap==2 &&  ikincikitap==true){
            
            //The region where those who want to borrow the second book from the library come
            
            try {
                mutex.acquire(); //critical section start
                setIkincikitap(false); //the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");                    
                    setIkincikitap(true);  //book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
 
                    mutex.release();   //end of critical section 
                    
            }
            
        return ogrencinumara+","+kacincikitap ;
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (kacincikitap==3 &&  ucuncukitap==true){
            
            //The region where those who want to borrow the third book from the library come.
            
            try {
                mutex.acquire();  //critical section start
                setUcuncukitap(false);  //the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");
                    setUcuncukitap(true);  //book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

                    mutex.release();      //end of critical section 
            }

        return ogrencinumara+","+kacincikitap ;
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (kacincikitap==4 &&  dorduncukitap==true){
            
            //The region where those who want to borrow the fourth book from the library come.
            
            try {
                mutex.acquire();   //critical section start
                setDorduncukitap(false);  //the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");
                    setDorduncukitap(true); //book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

                    mutex.release();  //end of critical section 
                    
            }

        return ogrencinumara+","+kacincikitap ; 
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }
        
        else if (kacincikitap==5 &&  besincikitap==true){
            
            //The region where those who want to borrow the fifth book from the library come
            
            try {
                mutex.acquire();   //critical section start
                setBesincikitap(false);  //the book was given to someone
                System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİYE VERİLİYOR");
                Thread.sleep((long) (Math.random()* 300));
                //The book was assigned to the student for a random period of milliseconds.
            } 
            catch (InterruptedException ex) {
                System.out.println("HATA!");
            }
            finally {
                    System.out.println(kacincikitap+"NUMARALI KİTAP"+ogrencinumara+"NUMARALI ÖĞRENCİDEN ALINDI");
                    setBesincikitap(true);  // book taken back from someone
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

                    mutex.release();  // end of critical section 
                    
            }
        return ogrencinumara+","+kacincikitap ;
                /*Since we can return a single statement with the 'call()' method,
                we return the two statements required for the deletion in a form that 
                can be arranged so that we can separate them with the 'split()' method in the main method.*/
        }

    return null;
    }
}


