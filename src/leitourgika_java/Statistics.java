package leitourgika_java;
import java.io.*;
/* Αυτή η κλάση υπολογίζει ορισμένα στατιστικά στοιχεία βάσει των διεργασιών
   που εμφανίζονται στο σύστημα και τα αποθηκεύει σε ένα αρχείο */
public class Statistics implements Serializable {
    private float averageWaitingTime;//ο τρεχων μεσος χρόνος αναμονης των διεργασιών προς εκτελεση
    private int totalWaitingTime=0;//ο τρεχων συνολικός χρόνος αναμονης των διεργασιών
    private int maximumLengthOfReadyProcessesList=0;//το τρεχων μεγιστο πληθος διεργασιών προς εκτελεση
    public int totalNumberOfProcesses;//ο τρεχων συνολικός αριθμός διεργασιών
    private int totalProcessesWaiting=0;
    private File outputFile;//αρχειο που αποθηκεύονται τα στατιστικα δεδομενα

    public Statistics(String filename){
        try {
            this.outputFile = new File(filename);
            outputFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
//ελέγχει το μήκος της λίστας έτοιμων διεργασιών και ενημερώνει αν είναι απαραίτητο την maximumLengthOfReadyProcessesList
    public void UpdateMaximumListLength(ReadyProcessesList list){
        if(maximumLengthOfReadyProcessesList<list.getsize())
         maximumLengthOfReadyProcessesList=list.getsize();
    }
//μετρητής για τον υπολογισμό του συνολικού totalWaitingTime
    public void SumTotalWaitingTime(int numberOfWaitingProcesses){
        totalWaitingTime=totalWaitingTime+numberOfWaitingProcesses;
    }
//υπολογίζει τον μέσο χρόνο αναμονής
    public String CalculateAverageWaitingTime(int quantum, int numberOfProcesses){
        averageWaitingTime=totalWaitingTime/(quantum*numberOfProcesses);
        System.out.println("totalWaitingTime="+totalWaitingTime);
        return "\nO mesos xronos anamonhs einai: " +averageWaitingTime+" To megisto plhthos diergasiwn pros ektelesh einai:" +maximumLengthOfReadyProcessesList;
    }
//γράφει τα τρέχοντα στατιστικά στο αρχείο outputFile
    public void WriteStatistics2File(){
        try{
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        out.println("O mesos xronos anamonhs einai: " +averageWaitingTime+" To megisto plhthos diergasiwn pros ektelesh einai:" +maximumLengthOfReadyProcessesList);
        out.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
