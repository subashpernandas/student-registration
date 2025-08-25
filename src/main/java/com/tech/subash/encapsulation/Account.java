package com.tech.subash.encapsulation;

/*
If you blindly provide public getters and setters for all fields,
you're exposing the internal state — which breaks true encapsulation.

Encapsulation is not just about hiding fields — it’s also about controlling and
validating access to them.

This class technically hides the field (private) but offers no control over
how it’s used — anyone can set any balance, even negative ones.
*/


class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    /*public void setBalance(double balance) {
        this.balance = balance;  // no validation
    }*/

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }
}


