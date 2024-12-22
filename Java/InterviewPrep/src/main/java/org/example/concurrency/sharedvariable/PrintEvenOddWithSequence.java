package org.example.concurrency.sharedvariable;

public class PrintEvenOddWithSequence implements Runnable {

    private static final int NUMBER_OF_THREADS = 3;
    private static final int TOTAL_NUMBERS_IN_SEQ = 10;

    private NumbersGenerator numbersGenerator;
    private int index;

    public PrintEvenOddWithSequence(NumbersGenerator numbersGenerator, int index) {
        this.numbersGenerator = numbersGenerator;
        this.index = index;
    }

    @Override
    public void run() {
        numbersGenerator.printNumber(this.index);
    }

    public static void main(String[] args) {

        NumbersGenerator numbersGenerator = new NumbersGenerator(NUMBER_OF_THREADS, TOTAL_NUMBERS_IN_SEQ);

        Thread t1 = new Thread(new PrintEvenOddWithSequence(numbersGenerator, 1), "THREAD-1");
        Thread t2 = new Thread(new PrintEvenOddWithSequence(numbersGenerator, 2), "THREAD-2");
        Thread t3 = new Thread(new PrintEvenOddWithSequence(numbersGenerator, 0), "THREAD-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
