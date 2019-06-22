# routine_scheduling
STRUCTURE OF THE CODE
* Class Process // Represents a system process.
Variables: arrivalTime, cpuTotatTime, cpuRemainingTime, currentState, pid
Methods: Creating getters of all variables, setProcessState (int newState) // changes the process state, changeCpuRemainingTime (int newCpuRemainingTime) // changes the processor's remaining working time.
* class ProcessGenerator // This class represents a process generator for the simulation.
Create inputFile to store new job data.
Methods: CreateProcess () // create a new pseudo-random process, StoreProcessToFile (Process tempProcess) // save the new process elements in the inputFile file.
* class NewProcessTemporaryList // Represents a list of new processes.
Create the ArrayList <Process> processList for this purpose.
Methods: addNewProcess (Process process) // import a new process into the list, getFirst () // return the first list process, getat (int i) // return element I from the list, PrintNewList () list with the new processes on the screen.
* class ReadyProcessesList // Represents a list of ready processes.
LinkedList <Process> processList statement, which contains the ready processes.
Methods: addProcess (Process item) // add a new finished process to the list, getProcessToRunInCPU () // print the process whose order is to run, printList () // print the content in the list on the screen, getize () / return the size of the list.
* class Clock // Class representing the system clock.
Using the ticks variable to store the current clock numbers that have elapsed.
Methods: Time_Run () // Increase of clock ticks, int ShowTime () // Return of time, getTicks () // Return of ticks.
* class CPU // Represents the system processing unit
Variables: runningProcess, timeToNextContextSwitch, lastProcessStartTime
Methods: addProcess (process process) // input process to execute on CPU, removeProcessFromCpu () // extract the current process from the CPU, execute () // execute the process with corresponding decrease in runtime. Creation of the getters of the variables , as well as setters of timeToNextContextSwitch and lastProcessStartTime.
* class RRScheduler // Process routing algorithm for the CPU.
Using the quantum variable on the basis of which the routing takes place
Methods: getQuantum () // return quantum, addProcessToReadyList (Process process, ReadyProcessesList list) // puts a process in the appropriate position of the list of ready processes, RR (ReadyProcessesList list, Clock clock, CPU cpu) // performs rotation of CPU process.
* class Statistics // Class for the calculation of certain statistics.
Variables: averageWaitingTime, totalWaitingTime, maximumLengthOfReadyProcessesList, totalNumberOfProcesses, totalProcessesWaiting.
Create outputFile for data storage
Methods: UpdateMaximumListLength (ReadyProcessesList list) // checks the length of the ready process list and updates if necessary the maximumLengthOfReadyProcessesList, CalculateAverageWaitingTime (int quantum, int numberOfProcesses // calculates the average wait time, SumTotalWaitingTime (int numberOfWaitingProcesses) // counter to calculate of the total totalWaitingTime, WriteStatistics2File () // writes the current statistics to the outputFile file.
* class Main // Main function from which the execution of the program starts. An overview of its structure can be found in the work documentation.
