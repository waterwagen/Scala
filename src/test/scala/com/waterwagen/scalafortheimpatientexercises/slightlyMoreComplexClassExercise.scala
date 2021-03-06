package com.waterwagen

// Scala

// Java

object SlightlyMoreComplexClassExercise extends App {

  class BankAccount(private var balance: Long = 0) {
    // api
    def deposit(balanceChange: Long) {
      changeBalance(balanceChange)
    }

    def withdraw(balanceChange: Long) {
      changeBalance(balanceChange)
    }

    def getBalance = balance

    // private methods
    private def changeBalance(balanceChange: Long) {
      balance += balanceChange
    }
  }

  val bankAccount = new BankAccount
  printf("This is the initial bank account balance %d", bankAccount.getBalance)
  bankAccount.deposit(35)
  printf("\nThis is the updated bank account balance %d", bankAccount.getBalance)
}
