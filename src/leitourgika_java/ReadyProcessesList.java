package leitourgika_java;
import java.util.LinkedList;


public class ReadyProcessesList {
    private LinkedList<Process> processList;/* η λιστα που περιεχει τις ετοιμες διεργασιες */

    public ReadyProcessesList() {
        processList = new LinkedList<Process>();
    }
    /* προσθηκη μιας νεας ετοιμης διεργασιας στη λιστα*/

    public void addProcess(Process item) {
        item.setProcessState(1);//1-->H diergasia einai Ready/Waiting
        processList.add(item);
    }
    /* επιστροφη της διεργασιας της οποιας η σειρα ειναι να εκτελεστει
    στη CPU σύμφωνα με τον εκαστοτε αλγόριθμο δρομολόγησης */

    public Process getProcessToRunInCPU() {
        Process first = processList.get(0);
        processList.remove();
        return first;
    }
    /* εκτύπωση του περιεχομενου της λίστας στην οθόνη */

    public void printList() {
        int i = 0;
        System.out.println("ready diergasies:");
        for (i = 0; i < processList.size(); i++) {
            System.out.println(processList.get(i).pid);
        }
    }

    public int getsize() {
        return processList.size();
    }
}
