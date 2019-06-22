         ΔΟΜΗ ΤΟΥ ΚΩΔΙΚΑ
* Class Process  //Αναπαριστά μια διεργασία του συστήματος.
Μεταβλητές:arrivalTime,cpuTotatTime,cpuRemainingTime,currentState,pid
Μέθοδοι:Δημιουργία getters όλων των μεταβλητών, setProcessState(int newState) //αλλάζει την κατάσταση της διεργασίας, changeCpuRemainingTime(int newCpuRemainingTime) //αλλάζει τον εναπομείναντα χρόνο απασχόλησης του επεξεργαστή από την διεργασία.
* class ProcessGenerator  // Η συγκεκριμένη κλάση αναπαριστά μια γεννήτρια διεργασιών για την προσομοίωση.                       
Δημιουργία του inputFile για την αποθήκευση των δεδομένων των νέων εργασιών.
Μέθοδοι: CreateProcess() //δημιουργία μιας νέας διεργασίας με ψευδο-τυχαία χαρακτηριστικά, StoreProcessToFile(Process tempProcess) //αποθήκευση των στοιχείων της νέας διεργασίας στο αρχείο inputFile.
* class NewProcessTemporaryList //Αναπαριστά μια λίστα που τοποθετούνται νέες διεργασίες.
Δημιουργία της ArrayList<Process> processList για τον σκοπό αυτό.
Μέθοδοι: addNewProcess(Process process) //εισαγωγή μιας νέας διεργασίας στη λίστα, getFirst() //επιστροφή της πρώτης διεργασίας της λίστας, getat(int i) //επιστροφή του στοιχείου I  από την λίστα, PrintNewList() //εκτύπωση της λίστας με τις νέες διεργασίες στην οθόνη.
* class ReadyProcessesList //Αναπαριστά μια λίστα που τοποθετούνται έτοιμες διεργασίες.
Δήλωση της LinkedList<Process> processList,η οποία περιέχει τις έτοιμες διεργασίες.
Μέθοδοι: addProcess(Process item) //προσθήκη μιας νέας έτοιμης διεργασίας στη λίστα, getProcessToRunInCPU()//επιστοφή της διεργασίας της οποίας η σειρά είναι να εκτελεστεί, printList() //εκτύπωση του περιεχομένου στης λίστας στην οθόνη, getsize() //επιστροφή του μεγέθους της λίστα.
* class Clock //Κλάση που αναπαριστά το ρολόι του συστήματος.
Χρησιμοποίηση της μεταβλητής ticks για την αποθήκευση των τρέχων αριθμών χτύπων ρολογιού που έχουν παρέλθει.
Μέθοδοι: Time_Run() //αύξηση των χτύπων του ρολογιού, int ShowTime() //επιστροφή της ώρας, getTicks() //επιστροφή των ticks.
* class CPU //Παριστάνει τη μονάδα επεξεργασίας του συστήματος
Μεταβλητές: runningProcess, timeToNextContextSwitch, lastProcessStartTime
Μέθοδοι: addProcess(Process process) //εισαγωγή της διεργασίας προς εκτέλεση στη CPU, removeProcessFromCpu() //εξαγωγή της τρέχουσας διεργασίας από την CPU, execute() //εκτέλεση της διεργασίας με αντίστοιχη μειωση του χρόνου εκτέλεσης.Δημιουργεία των getters των μεταβλητών,όπως επίσης και τα setters των timeToNextContextSwitch και lastProcessStartTime.
* class RRScheduler //Αλγόριθμος δρομολόγησης διεργασιών προς τη CPU.
Χρησιμοποίηση της μεταβλητής quantum, βάση της οποίας γίνεται η δρομολόγηση
Μέθοδοι: getQuantum() //επιστροφή του quantum, addProcessToReadyList(Process process, ReadyProcessesList list) // τοποθετεί μια διεργασία στην κατάλληλη θέση της λίστας των έτοιμων διεργασιών, RR(ReadyProcessesList list, Clock clock, CPU cpu) // εκτελεί την εναλλαγή της διεργασίας στη CPU.
* class Statistics //Κλάση για των υπολογισμών ορισμένων στατιστικών στοιχείων.
Μεταβλητές: averageWaitingTime, totalWaitingTime, maximumLengthOfReadyProcessesList, totalNumberOfProcesses, totalProcessesWaiting.
Δημιουργία του outputFile για την αποθήκευση των δεδομένων
Μέθοδοι: UpdateMaximumListLength(ReadyProcessesList list) //ελέγχει το μήκος της λίστας έτοιμων διεργασιών και ενημερώνει αν είναι απαραίτητο την maximumLengthOfReadyProcessesList, CalculateAverageWaitingTime(int quantum, int numberOfProcesses //υπολογίζει τον μέσο χρόνο αναμονής, SumTotalWaitingTime(int numberOfWaitingProcesses) //μετρητής για τον υπολογισμό του συνολικού totalWaitingTime, WriteStatistics2File() //γράφει τα τρέχοντα στατιστικά στο αρχείο outputFile.
* class Main  //Κύρια συνάρτηση από την οποία εκκινεί η εκτέλεση του προγράμματος .Αναλυτική παρουσίαση της δομής της θα βρείτε στην τεκμηρίωση της εργασίας.

