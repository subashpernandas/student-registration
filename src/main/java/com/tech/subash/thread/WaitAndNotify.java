package com.tech.subash.thread;

public class WaitAndNotify {

    private int savingAccount = 0;

    WaitAndNotify(int initialDepositAmount){
        this.savingAccount = initialDepositAmount;
    }

    public int getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(int savingAccount) {
        this.savingAccount = savingAccount;
    }

    public synchronized void deposit(int depositAmount) {
        if (depositAmount > 0) {
            savingAccount += depositAmount;
            System.out.println(Thread.currentThread().getName() + ": Deposited: " + depositAmount + ", Total: " + savingAccount);
            notify();  // Notify waiting thread
        } else {
            throw new RuntimeException("Deposit amount should be greater than 0");
        }
    }


    public synchronized void withdraw(int withDrawAmount) {
        if (withDrawAmount > savingAccount) {
            System.out.println(Thread.currentThread().getName() + ": Insufficient balance. Waiting...");
            try {
                wait();  // Wait until deposit is made
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Sufficient balance now
        System.out.println(Thread.currentThread().getName() + ": Total Savings Before Withdraw: " + savingAccount);
        savingAccount -= withDrawAmount;
        if(savingAccount < 0){
            throw new RuntimeException("Insufficient Balance Exception, please deposit some valid amount");
        }
        System.out.println(Thread.currentThread().getName() + ": Withdraw Amount: " + withDrawAmount);
        System.out.println(Thread.currentThread().getName() + ": Total Savings After Withdraw: " + savingAccount);
    }


    public static void main(String[] args) {
        WaitAndNotify account = new WaitAndNotify(1000);

        Thread withdrawThread = new Thread(() -> account.withdraw(2000), "Withdraw-Thread");
        Thread depositThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(2000);
        }, "Deposit-Thread");

        withdrawThread.start();
        depositThread.start();
    }

}
