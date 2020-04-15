package ru.sync;

//Задание 6-2. В данном классе реализуется многопоточность для работы с методом calc класса U1901Bank.
public class U1901Thread extends Thread {
    private U1901Bank bankWork;
    private int intTrans;
    private long lngSleep;

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    public void run() {
        this.bankWork.calc(intTrans, lngSleep);
    }
}