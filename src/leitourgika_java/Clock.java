package leitourgika_java;

public class Clock {
    protected static int ticks;

    public Clock(){
        ticks=0;
    }

    /* αύξηση των χτύπων του ρολογιού (+1) */
    public void Time_Run(){
        ticks++;
    }

    /* επιστροφη της ώρας βασει της μεταβλητης ticks */
    public int ShowTime(){
        return ticks;
    }
//επιστροφη των ticks
    public int getTicks() {
        return ticks;
    }
    
}
