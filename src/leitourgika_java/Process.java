package leitourgika_java;
import java.io.*;
/* Η συγκεκριμένη κλάση αναπαριστά μια διεργασία του συστήματος */
public class Process implements Serializable {
    protected int pid;
    protected int arrivalTime; //xronikh stigmh afikshs ths diergasias sto susthma
    protected int cpuTotalTime;//sunolokos xronos apasxolhshs CPU apo th diergasia
    protected int cpuRemainingTime;//enapomeinantas xronos apasxolhshs CPU apo th diergasia
    protected int currentState;//trexousa katastash ths diergasias(0,1,2,3)
    
    public Process(int pid,int arrivalTime,int cpuTotalTime)
    {
        this.pid=pid;
        this.arrivalTime=arrivalTime;
        this.cpuTotalTime=cpuTotalTime;
        this.currentState=0;
        this.cpuRemainingTime=cpuTotalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getCpuRemainingTime() {
        return cpuRemainingTime;
    }

    public int getCpuTotalTime() {
        return cpuTotalTime;
    }

    public int getCurrentState() {
        return currentState;
    }
    //allazei tin katastash ths diergasias
    public int setProcessState(int newState){
        currentState=newState;
        return currentState;
    }
    //allazei ton enapomeinanta xrono apasxolhshs CPU apo th diergasia
    public void changeCpuRemainingTime(int newCpuRemainingTime){
        cpuRemainingTime=newCpuRemainingTime;
        System.out.println("Diergasia: "+pid+" remainning time: "+cpuRemainingTime);
    }
}
