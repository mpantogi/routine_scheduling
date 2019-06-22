         ���� ��� ������
* Class Process  //���������� ��� ��������� ��� ����������.
����������:arrivalTime,cpuTotatTime,cpuRemainingTime,currentState,pid
�������:���������� getters ���� ��� ����������, setProcessState(int newState) //������� ��� ��������� ��� ����������, changeCpuRemainingTime(int newCpuRemainingTime) //������� ��� ������������� ����� ����������� ��� ����������� ��� ��� ���������.
* class ProcessGenerator  // � ������������ ����� ���������� ��� ��������� ���������� ��� ��� �����������.                       
���������� ��� inputFile ��� ��� ���������� ��� ��������� ��� ���� ��������.
�������: CreateProcess() //���������� ���� ���� ���������� �� �����-������ ��������������, StoreProcessToFile(Process tempProcess) //���������� ��� ��������� ��� ���� ���������� ��� ������ inputFile.
* class NewProcessTemporaryList //���������� ��� ����� ��� ������������� ���� ����������.
���������� ��� ArrayList<Process> processList ��� ��� ����� ����.
�������: addNewProcess(Process process) //�������� ���� ���� ���������� ��� �����, getFirst() //��������� ��� ������ ���������� ��� ������, getat(int i) //��������� ��� ��������� I  ��� ��� �����, PrintNewList() //�������� ��� ������ �� ��� ���� ���������� ���� �����.
* class ReadyProcessesList //���������� ��� ����� ��� ������������� ������� ����������.
������ ��� LinkedList<Process> processList,� ����� �������� ��� ������� ����������.
�������: addProcess(Process item) //�������� ���� ���� ������� ���������� ��� �����, getProcessToRunInCPU()//�������� ��� ���������� ��� ������ � ����� ����� �� ����������, printList() //�������� ��� ������������ ���� ������ ���� �����, getsize() //��������� ��� �������� ��� �����.
* class Clock //����� ��� ���������� �� ����� ��� ����������.
������������� ��� ���������� ticks ��� ��� ���������� ��� ������ ������� ������ �������� ��� ����� ��������.
�������: Time_Run() //������ ��� ������ ��� ��������, int ShowTime() //��������� ��� ����, getTicks() //��������� ��� ticks.
* class CPU //���������� �� ������ ������������ ��� ����������
����������: runningProcess, timeToNextContextSwitch, lastProcessStartTime
�������: addProcess(Process process) //�������� ��� ���������� ���� �������� ��� CPU, removeProcessFromCpu() //������� ��� ��������� ���������� ��� ��� CPU, execute() //�������� ��� ���������� �� ���������� ������ ��� ������ ���������.����������� ��� getters ��� ����������,���� ������ ��� �� setters ��� timeToNextContextSwitch ��� lastProcessStartTime.
* class RRScheduler //���������� ������������ ���������� ���� �� CPU.
������������� ��� ���������� quantum, ���� ��� ������ ������� � �����������
�������: getQuantum() //��������� ��� quantum, addProcessToReadyList(Process process, ReadyProcessesList list) // ��������� ��� ��������� ���� ��������� ���� ��� ������ ��� ������� ����������, RR(ReadyProcessesList list, Clock clock, CPU cpu) // ������� ��� �������� ��� ���������� ��� CPU.
* class Statistics //����� ��� ��� ����������� ��������� ����������� ���������.
����������: averageWaitingTime, totalWaitingTime, maximumLengthOfReadyProcessesList, totalNumberOfProcesses, totalProcessesWaiting.
���������� ��� outputFile ��� ��� ���������� ��� ���������
�������: UpdateMaximumListLength(ReadyProcessesList list) //������� �� ����� ��� ������ ������� ���������� ��� ���������� �� ����� ���������� ��� maximumLengthOfReadyProcessesList, CalculateAverageWaitingTime(int quantum, int numberOfProcesses //���������� ��� ���� ����� ��������, SumTotalWaitingTime(int numberOfWaitingProcesses) //�������� ��� ��� ���������� ��� ��������� totalWaitingTime, WriteStatistics2File() //������ �� �������� ���������� ��� ������ outputFile.
* class Main  //����� ��������� ��� ��� ����� ������� � �������� ��� ������������ .��������� ���������� ��� ����� ��� �� ������ ���� ���������� ��� ��������.

