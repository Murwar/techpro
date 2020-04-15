package ru.sync;

//Класс для проверки работоспособности многопоточности.
public class U1901Main {
    public static void main(String[] args) {
        U1901Bank bankMain = new U1901Bank();

        // Создаем и запускаем первый поток
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000L);
        threadOne.setName("numberOne");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();
        // Создаем и запускаем второй поток
        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("numberTwo");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        System.out.println("current thread = " + Thread.currentThread().getName());

    }
}