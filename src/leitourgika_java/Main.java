package leitourgika_java;

public class Main {

    static Clock Clock1 = new Clock();
    static NewProcessTemporaryList NewProcessTemporaryList1 = new NewProcessTemporaryList();
    static NewProcessTemporaryList NewProcessTemporaryList2 = new NewProcessTemporaryList();
    static ReadyProcessesList ReadyProcessesList1 = new ReadyProcessesList();
    static ProcessGenerator ProcessGenerator1 = new ProcessGenerator("GeneratedProcesses.txt");
    static CPU CPU1 = new CPU();
    static Statistics Statistics1 = new Statistics("Statistics.txt");
    static RRScheduler RRScheduler1 = new RRScheduler(20);

    public static void main(String[] args) {
        System.out.println("Running Main...");
        int minarrivaltime, maxarrivaltime;
        int place = 0;  //i thesi stin temporary list
        for (int i = 0; i < 10; i++)//Dhmiourgia 10 Diergasiwn
        {
            NewProcessTemporaryList1.addNewProcess(ProcessGenerator1.CreateProcess());
        }

        NewProcessTemporaryList1.PrintNewList();
        minarrivaltime = NewProcessTemporaryList1.getFirst().getArrivalTime();
        maxarrivaltime = NewProcessTemporaryList1.getFirst().getArrivalTime();
        for (int i = 1; i < 10; i++)//vriskw auton pou eftase prwtos poia stigmi eftase kai to idio gia ton teleutaio
        {
            if (minarrivaltime > NewProcessTemporaryList1.getat(i).getArrivalTime()) {
                minarrivaltime = NewProcessTemporaryList1.getat(i).getArrivalTime();
            }
            if (maxarrivaltime < NewProcessTemporaryList1.getat(i).getArrivalTime()) {
                maxarrivaltime = NewProcessTemporaryList1.getat(i).getArrivalTime();
            }
        }

        for (int i = minarrivaltime; i <= maxarrivaltime; i++) {
            for (int j = 0; j < 10; j++) {
                if (NewProcessTemporaryList1.getat(j).getArrivalTime() == i) {
                    NewProcessTemporaryList2.addNewProcess(NewProcessTemporaryList1.getat(j));
                }
            }
        }

        NewProcessTemporaryList2.PrintNewList();

        while (place <= 9 && Clock1.getTicks() < NewProcessTemporaryList2.getat(place).getArrivalTime() + 1) {

            Clock1.Time_Run();

            if (Clock1.getTicks() == NewProcessTemporaryList2.getat(place).getArrivalTime()) {
                System.out.println("time " + Clock1.getTicks());
                RRScheduler1.addProcessToReadyList(NewProcessTemporaryList2.getat(place), ReadyProcessesList1);
                CPU1.setTimeToNextContextSwitch(RRScheduler1.getQuantum() + Clock1.getTicks());
                CPU1.addProcess(ReadyProcessesList1.getProcessToRunInCPU());
                place++;
                while (ReadyProcessesList1.getsize() != 0 || CPU1.processeRuning().getCurrentState() != 3) {
                    RRScheduler1.RR(ReadyProcessesList1, Clock1, CPU1);
                    CPU1.execute();
                    Clock1.Time_Run();
                    System.out.print("Current time: " + Clock1.getTicks()+" ");
                    Statistics1.UpdateMaximumListLength(ReadyProcessesList1);
                    Statistics1.SumTotalWaitingTime(ReadyProcessesList1.getsize());
                    while (place <= 9 && Clock1.getTicks() == NewProcessTemporaryList2.getat(place).getArrivalTime()) {
                        RRScheduler1.addProcessToReadyList(NewProcessTemporaryList2.getat(place), ReadyProcessesList1);
                        place++;
                        System.out.println("oi etoimes diergasies sti lista einai:");
                        ReadyProcessesList1.printList();
                    }
                }
            }
        }
        System.out.println(Statistics1.CalculateAverageWaitingTime(10,10));//quantum=10  Processes=10
        Statistics1.WriteStatistics2File();
    }
}
