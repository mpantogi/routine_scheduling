package leitourgika_java;
import java.io.*;
import java.util.Random;
/* Η συγκεκριμένη κλάση αναπαριστά μια γεννήτρια διεργασιών για την προσομοίωση */
public class ProcessGenerator implements Serializable{
    private File inputFile;
    private int randomPid=1;
    
    public ProcessGenerator(String filename){
        try {
            this.inputFile = new File(filename);
            inputFile.createNewFile();                        
        } catch (IOException e) {
            System.out.println(e);
        }                       
    }
    //dhmiourgia mias neas dhergasias me psedotuxaia xarakthristika
    public Process CreateProcess(){
        Random randomGenerator = new Random();
        int arrivalTime = randomGenerator.nextInt(100);        
        int cpuTotalTime = randomGenerator.nextInt(100);//tuxaios arithmos gia to xrono apasxolhshs tou CPU
        Process tempProcess = new Process(randomPid,arrivalTime,cpuTotalTime); //Clock.ticks periexei to trexonta xrono
        //System.out.println("arrivalTime ="+tempProcess.arrivalTime+" cpuTotalTime="+tempProcess.cpuTotalTime+" pid="+tempProcess.pid+" currentState=" +tempProcess.currentState);
        StoreProcessToFile(tempProcess);
        randomPid++;
        return tempProcess;
    }
    //apothkeush twn stoixeiwn ths neas diergasias sto arxeio inputfile
    public void StoreProcessToFile(Process tempProcess){
        try{
        PrintWriter out = new PrintWriter(new FileWriter(inputFile,true));
        out.println("arrivalTime ="+tempProcess.arrivalTime+" cpuTotalTime="+tempProcess.cpuTotalTime+" pid="+tempProcess.pid);
            
            
        out.flush();
        out.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
