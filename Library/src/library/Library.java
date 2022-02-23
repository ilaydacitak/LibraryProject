/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *
 * @author mrsci
 */
public class Library {
public static void main(String[] args) throws Exception {
        
        LinkedList<Integer>[] ogrencilistesi = new LinkedList[40];  
        //A linked-list of 40 members is created representing the students.
        
        for(int o=0; o<40; o++){     
            ogrencilistesi[o] = new LinkedList<>();      
            LinkedList<Integer> whichList = ogrencilistesi[o];  
            
            for ( int a = 0 ; a<6 ; a++){
                whichList.add(a);
            }
        //A six-item linked-list is created to represent the books that each student should read.
        }
        
        //Linked-lists consisting of linked-lists were created.
        /*In other words, a hash-table was created in order to control which student read
                which book and which ones remained.*/
        
        boolean u = true ;
        while(u){  // With the while loop, the process continued until the students read all the books.
            
            Random rastgele = new Random();
            
            /*I represented the students with their school numbers, 
            by obtaining three different numbers for three students to go to three librarians at random.*/
            
            int [] dizim = new int [3];  //this is the array where i keep three different school numbers.
            boolean durum = true ;
            int numara;  // number to be generated each time

            for (int i = 0; i < dizim.length; i++){

                while (durum){ 

                    numara = rastgele.nextInt(ogrencilistesi.length);

                    if (i == 0){

                        dizim[0] = numara; // The first random school number is chosen.
                        break; //exit of while loop
                    }
                    
                    // Checking whether there is a new number created in the array.

                    // If it exists, the state becomes true and exits the for loop. Because we need to assign a new number

                    for (int k = 0; k < i; k++){

                        if (dizim[k] == numara){ // If our new formed number already exists in the array ,

                            durum = true;
                            break; //exit the for loop.
                        }
                        else{
                            durum = false;
                        }
                    }
                    if (durum == false){
                        dizim[i] = numara; //otherwise the other random school number is chosen.
                    }
                }
                    durum = true;     
            }
            //Match three different random numbers that we assign as elements to the array with their int values.
            int numara1 = dizim[0];
            int numara2 = dizim[1];
            int numara3 = dizim[2];

            FutureTask[] randomNumberTasks = new FutureTask[3]; //I took the first step to create three threads.
            
            //It is checked whether there is a book that the randomly selected person has not read.
            if(ogrencilistesi[numara1].size()!=0){  
                                
                //If there is a book she/he has not read yet, she is allowed to randomly choose a book from among these books.
                int kitapnumarası1 = rastgele.nextInt(ogrencilistesi[numara1].size());
                int kitap1 = ogrencilistesi[numara1].get(kitapnumarası1);

                Callable callable = new KitapSorgulamaIslemleri(numara1,kitap1); 
                /*The number of the student to be checked whether she/he can borrow 
                the book and the number of that book are sent to the other class.*/
                randomNumberTasks[0] = new FutureTask(callable);
                Thread kutuphaneci1 = new Thread(randomNumberTasks[0]);
                kutuphaneci1.start();
                
                //We created the first thread named 'kutuphaneci1' and assigned the data. Then I started the thread.

                String str = (String) randomNumberTasks[0].get();
                String[] bolunecekler = str.split(",",2);
                
                //I separate the data I get back with 'split()' and get both data.

                //The first data is the student, the second data is the book he read.

                String kitabisilinecekkisistring = bolunecekler[0];
                int kitabisilinecekkişi = Integer.parseInt(kitabisilinecekkisistring); 

                String silinecekkitapstring = bolunecekler[1];
                int silinecekkitap = Integer.parseInt(silinecekkitapstring);
                
                //I converted the data I received in String type to int type.

                int silinecekkitap1 = ogrencilistesi[kitabisilinecekkişi].indexOf(silinecekkitap);

                ogrencilistesi[kitabisilinecekkişi].remove(silinecekkitap1);
                
                /*I find the index of the book to be deleted. Then I delete the read books from the list
                belonging to the particular student using the index-dependent deletion of the 'remove()' method.*/
                
                /*Since a left shift occurred instead of the deleted element by deleting in this way, 
                I was able to keep the book list size of the students within the required limits when 
                a book would be randomly selected for the same student again.*/
            }

            else{

                if (ogrencilistesi[0].size() == 0 && ogrencilistesi[1].size() == 0 && ogrencilistesi[2].size() == 0 
                    && ogrencilistesi[3].size() == 0 && ogrencilistesi[4].size() == 0 && ogrencilistesi[5].size() == 0
                    && ogrencilistesi[6].size() == 0 && ogrencilistesi[7].size() == 0 && ogrencilistesi[8].size() == 0 
                    && ogrencilistesi[9].size() == 0 && ogrencilistesi[10].size() == 0 && ogrencilistesi[11].size() == 0 
                    && ogrencilistesi[12].size() == 0 && ogrencilistesi[13].size() == 0 && ogrencilistesi[14].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[16].size() == 0 && ogrencilistesi[17].size() == 0 
                    && ogrencilistesi[18].size() == 0 && ogrencilistesi[19].size() == 0 && ogrencilistesi[20].size() == 0 
                    && ogrencilistesi[21].size() == 0 && ogrencilistesi[22].size() == 0 && ogrencilistesi[23].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[25].size() == 0 && ogrencilistesi[26].size() == 0 
                    && ogrencilistesi[27].size() == 0 && ogrencilistesi[28].size() == 0 && ogrencilistesi[29].size() == 0 
                    && ogrencilistesi[30].size() == 0 && ogrencilistesi[31].size() == 0 && ogrencilistesi[31].size() == 0
                    && ogrencilistesi[32].size() == 0 && ogrencilistesi[33].size() == 0 && ogrencilistesi[34].size() == 0
                    && ogrencilistesi[35].size() == 0 && ogrencilistesi[36].size() == 0 && ogrencilistesi[37].size() == 0 
                    && ogrencilistesi[38].size() == 0 && ogrencilistesi[39].size() == 0 ){
                    
                        u = false ;
                        break;
                        
                        /*When a student's books are finished, a check is made. If the books that other students should read 
                        are finished, the 'while' loop is made 'false'. The loop is broken.*/
                }
                else{
                    u = true ;
                    
                    //If other students still have books to read, the cycle continues.
                }
            }
            
            //It is checked whether there is a book that the randomly selected person has not read.
            if(ogrencilistesi[numara2].size()!=0){

                //If there is a book she/he has not read yet, she is allowed to randomly choose a book from among these books.
                int kitapnumarası2 = rastgele.nextInt(ogrencilistesi[numara2].size());
                int kitap2 = ogrencilistesi[numara2].get(kitapnumarası2);

                Callable callable = new KitapSorgulamaIslemleri(numara2,kitap2);
                /*The number of the student to be checked whether she/he can borrow 
                the book and the number of that book are sent to the other class.*/
                randomNumberTasks[1] = new FutureTask(callable);
                Thread kutuphaneci2 = new Thread(randomNumberTasks[1]);
                kutuphaneci2.start();
                
                //We created the first thread named 'kutuphaneci1' and assigned the data. Then I started the thread.

                String str = (String) randomNumberTasks[1].get();
                String[] bolunecekler = str.split(",",2);
                
                //I separate the data I get back with 'split()' and get both data.

                //The first data is the student, the second data is the book he read.

                String kitabisilinecekkisistring = bolunecekler[0];
                int kitabisilinecekkişi = Integer.parseInt(kitabisilinecekkisistring); 

                String silinecekkitapstring = bolunecekler[1];
                int silinecekkitap = Integer.parseInt(silinecekkitapstring);
                
                //I converted the data I received in String type to int type.

                int silinecekkitap2 = ogrencilistesi[kitabisilinecekkişi].indexOf(silinecekkitap);

                ogrencilistesi[kitabisilinecekkişi].remove(silinecekkitap2);
                
                /*I find the index of the book to be deleted. Then I delete the read books from the list
                belonging to the particular student using the index-dependent deletion of the 'remove()' method.*/
                
                /*Since a left shift occurred instead of the deleted element by deleting in this way, 
                I was able to keep the book list size of the students within the required limits when 
                a book would be randomly selected for the same student again.*/

            }
            else{
                if (ogrencilistesi[0].size() == 0 && ogrencilistesi[1].size() == 0 && ogrencilistesi[2].size() == 0 
                    && ogrencilistesi[3].size() == 0 && ogrencilistesi[4].size() == 0 && ogrencilistesi[5].size() == 0
                    && ogrencilistesi[6].size() == 0 && ogrencilistesi[7].size() == 0 && ogrencilistesi[8].size() == 0 
                    && ogrencilistesi[9].size() == 0 && ogrencilistesi[10].size() == 0 && ogrencilistesi[11].size() == 0 
                    && ogrencilistesi[12].size() == 0 && ogrencilistesi[13].size() == 0 && ogrencilistesi[14].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[16].size() == 0 && ogrencilistesi[17].size() == 0 
                    && ogrencilistesi[18].size() == 0 && ogrencilistesi[19].size() == 0 && ogrencilistesi[20].size() == 0 
                    && ogrencilistesi[21].size() == 0 && ogrencilistesi[22].size() == 0 && ogrencilistesi[23].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[25].size() == 0 && ogrencilistesi[26].size() == 0 
                    && ogrencilistesi[27].size() == 0 && ogrencilistesi[28].size() == 0 && ogrencilistesi[29].size() == 0 
                    && ogrencilistesi[30].size() == 0 && ogrencilistesi[31].size() == 0 && ogrencilistesi[31].size() == 0
                    && ogrencilistesi[32].size() == 0 && ogrencilistesi[33].size() == 0 && ogrencilistesi[34].size() == 0
                    && ogrencilistesi[35].size() == 0 && ogrencilistesi[36].size() == 0 && ogrencilistesi[37].size() == 0 
                    && ogrencilistesi[38].size() == 0 && ogrencilistesi[39].size() == 0 ){

                        u = false ;
                        break;
                        
                        /*When a student's books are finished, a check is made. If the books that other students should read 
                        are finished, the 'while' loop is made 'false'. The loop is broken.*/
                }
                else{
                    u = true ;
                    
                    //If other students still have books to read, the cycle continues.
                }

            }
            
            //It is checked whether there is a book that the randomly selected person has not read.
            if(ogrencilistesi[numara3].size()!=0){

                //If there is a book she/he has not read yet, she is allowed to randomly choose a book from among these books.
                int kitapnumarası3 = rastgele.nextInt(ogrencilistesi[numara3].size());
                int kitap3 = ogrencilistesi[numara3].get(kitapnumarası3);

                Callable callable = new KitapSorgulamaIslemleri(numara3,kitap3);
                /*The number of the student to be checked whether she/he can borrow 
                the book and the number of that book are sent to the other class.*/
                randomNumberTasks[2] = new FutureTask(callable);
                Thread kutuphaneci3 = new Thread(randomNumberTasks[2]);
                kutuphaneci3.start();
                
                //We created the first thread named 'kutuphaneci1' and assigned the data. Then I started the thread.

                String str = (String) randomNumberTasks[2].get();
                String[] bolunecekler = str.split(",",2);
                
                //I separate the data I get back with 'split()' and get both data.

                //The first data is the student, the second data is the book he read.

                String kitabisilinecekkisistring = bolunecekler[0];
                int kitabisilinecekkişi = Integer.parseInt(kitabisilinecekkisistring); 

                String silinecekkitapstring = bolunecekler[1];
                int silinecekkitap = Integer.parseInt(silinecekkitapstring);
                
                //I converted the data I received in String type to int type.

                int silinecekkitap3 = ogrencilistesi[kitabisilinecekkişi].indexOf(silinecekkitap);

                ogrencilistesi[kitabisilinecekkişi].remove(silinecekkitap3);
                
                /*I find the index of the book to be deleted. Then I delete the read books from the list
                belonging to the particular student using the index-dependent deletion of the 'remove()' method.*/
                
                /*Since a left shift occurred instead of the deleted element by deleting in this way, 
                I was able to keep the book list size of the students within the required limits when 
                a book would be randomly selected for the same student again.*/

            }
            else{
                if (ogrencilistesi[0].size() == 0 && ogrencilistesi[1].size() == 0 && ogrencilistesi[2].size() == 0 
                    && ogrencilistesi[3].size() == 0 && ogrencilistesi[4].size() == 0 && ogrencilistesi[5].size() == 0
                    && ogrencilistesi[6].size() == 0 && ogrencilistesi[7].size() == 0 && ogrencilistesi[8].size() == 0 
                    && ogrencilistesi[9].size() == 0 && ogrencilistesi[10].size() == 0 && ogrencilistesi[11].size() == 0 
                    && ogrencilistesi[12].size() == 0 && ogrencilistesi[13].size() == 0 && ogrencilistesi[14].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[16].size() == 0 && ogrencilistesi[17].size() == 0 
                    && ogrencilistesi[18].size() == 0 && ogrencilistesi[19].size() == 0 && ogrencilistesi[20].size() == 0 
                    && ogrencilistesi[21].size() == 0 && ogrencilistesi[22].size() == 0 && ogrencilistesi[23].size() == 0 
                    && ogrencilistesi[14].size() == 0 && ogrencilistesi[25].size() == 0 && ogrencilistesi[26].size() == 0 
                    && ogrencilistesi[27].size() == 0 && ogrencilistesi[28].size() == 0 && ogrencilistesi[29].size() == 0 
                    && ogrencilistesi[30].size() == 0 && ogrencilistesi[31].size() == 0 && ogrencilistesi[31].size() == 0
                    && ogrencilistesi[32].size() == 0 && ogrencilistesi[33].size() == 0 && ogrencilistesi[34].size() == 0
                    && ogrencilistesi[35].size() == 0 && ogrencilistesi[36].size() == 0 && ogrencilistesi[37].size() == 0 
                    && ogrencilistesi[38].size() == 0 && ogrencilistesi[39].size() == 0 ){

                        u = false ;
                        break;
                        
                        /*When a student's books are finished, a check is made. If the books that other students should read 
                        are finished, the 'while' loop is made 'false'. The loop is broken.*/
                }
                else{
                    u = true ;
                    
                    //If other students still have books to read, the cycle continues.
                }

            }

        }
        System.out.println("HERKES 6 KİTABI OKUDU");
        //If the loop is out, all students have read the books they should read.

    }
    
}
