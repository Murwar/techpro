
package ru.sync;
// Задание 6-2. Синхронизация потоков

//Данный класс имитирует работу банковской операции со счетами
public class U1901Bank {

    private int intTo; // счет-получатель
    private int intFrom = 220; // счет-отправитель

    // В данном методе орагнизована банковская операция по переброске денег между счетами.
    // Между снятием и пополнением организована задержка lngTimeout.
    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("Before: thread name = " + Thread.currentThread().getName() + ", From = " + intFrom
                + ", To = " + intTo);

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (Exception e) {
            e.printStackTrace();
        }

        intTo += intTransaction;
        System.out.println(
                "After: thread name = " + Thread.currentThread().getName() + ", From = " + intFrom + ", To = " + intTo);

    }
}