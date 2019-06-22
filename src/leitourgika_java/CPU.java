package leitourgika_java;

public class CPU {
    private Process runningProcess;// περιεχει τη διεργασια που χρησιμοποιει τη CPU την τρεχουσα στιγμη
    private int timeToNextContextSwitch;// περιεχει τη χρονικη στιγμη της επόμενης διακοπης
    private int lastProcessStartTime;// περιεχει τη χρονικη στιγμη εναρξης της τελευταιας διεργασιας
    
    public CPU() {}
/* εισαγωγη της διεργασιας προς εκτελεση στη CPU */
    public void addProcess(Process process){
        this.runningProcess=process;
    }
/* εξαγωγη τησ τρεχουσας διεργασιας από τη CPU */
    public Process removeProcessFromCpu(){
      
        runningProcess.setProcessState(3);//3-->H diergasia einai Terminated
        return runningProcess;
    }
/* εκτελεση της διεργασιας με αντιστοιχη μειωση του χρόνου εκτελεσης της */
    public void execute() {
        runningProcess.setProcessState(2);//2-->H diergasia einai Running
        int remaintime= runningProcess.getCpuRemainingTime();
        runningProcess.changeCpuRemainingTime(remaintime-1);
        if(runningProcess.getCpuRemainingTime()==0) removeProcessFromCpu();
    }

    public void setLastProcessStartTime() {
        lastProcessStartTime = runningProcess.arrivalTime;
    }

    public void setTimeToNextContextSwitch(int q) {
        timeToNextContextSwitch = q;
    }

    public int getLastProcessStartTime() {
        return lastProcessStartTime;
    }

    public int getTimeToNextContextSwitch() {
        return timeToNextContextSwitch;
    }
   
    public Process processeRuning() {
        return runningProcess;
    }
}
