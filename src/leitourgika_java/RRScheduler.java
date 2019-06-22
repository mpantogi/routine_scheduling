package leitourgika_java;

public class RRScheduler {

    private int quantum;// αναπαριστα την τιμη του quantum με βαση το οποιο γινεται η δρομολόγηση

    public RRScheduler(int quantum) {
        this.quantum = quantum;
    }

    public int getQuantum() {
        return quantum;
    }
//τοποθετει μια διεργασια στην καταλληλη θεση της λιστας των ετοιμων διεργασιων
    public void addProcessToReadyList(Process process, ReadyProcessesList list) {
        list.addProcess(process);
    }
//εκτελει την εναλλαγη της διεργασιας στη CPU
    public void RR(ReadyProcessesList list, Clock clock, CPU cpu) {
        if (cpu.processeRuning().cpuRemainingTime == 0) {
            System.out.println("I diergasia " + cpu.processeRuning().pid + "teleiwse");
            cpu.addProcess(list.getProcessToRunInCPU());
            cpu.setTimeToNextContextSwitch(clock.getTicks() + quantum);
        } else if (cpu.getTimeToNextContextSwitch() == clock.getTicks()) {
            System.out.println("ENALLAGH DIERGASIAS");
            list.addProcess(cpu.processeRuning());
            cpu.addProcess(list.getProcessToRunInCPU());
            System.out.println("i nea running diergasia " + cpu.processeRuning().pid);
            cpu.setTimeToNextContextSwitch(clock.getTicks() + quantum);
        } else {}
    }
}
