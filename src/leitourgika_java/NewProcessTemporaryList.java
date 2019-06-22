package leitourgika_java;

import java.util.ArrayList;

/* Αναπαριστά μια λίστα στην οποία τοποθετούνται νέες διεργαςίες που μόλις
   έχουν δημιουργηθεί και βρίσκονται στην κατάσταση new */
public class NewProcessTemporaryList{

    private ArrayList<Process> processList;

    public NewProcessTemporaryList() {
         processList = new ArrayList<Process>();
    }
    //eisagwgh mias neas diergasias sth lista
    public void addNewProcess(Process process) {
        processList.add(process);
    }
    //epistrofh ths prwths diergasias ths listas
    public Process getFirst() {
        return processList.get(0);
    }
    //epistrofh tou stoixeiou i apo thn lista
    public Process getat(int i){
       return processList.get(i);
    }
  //ektupwsh ths listas me tis nees diergasies sthn othonh
    public void PrintNewList() {
        int i=0;
        System.out.println("nees diergasies:");
        for(i=0;i< processList.size();i++)
        {
            System.out.println("Process ID: " +processList.get(i).pid+ " arival time: " +processList.get(i).arrivalTime+ " cpu total time: " +processList.get(i).cpuTotalTime);
        }
    }
}
