package com.maclern.apriori

import org.scalatest._

class TransactionListSpec extends FlatSpec with Matchers {
    
    val foo : Item = new Item("Foo")
    val bar : Item = new Item("Bar")
    val baz : Item = new Item("Baz")
    val fullTransaction : Transaction = new Transaction(List(foo, bar, baz))
    val emptyTransaction : Transaction = new Transaction(List())
    val lonelyTransaction : Transaction = new Transaction(List(foo))
    val transactionList : TransactionList = new TransactionList(List(fullTransaction, emptyTransaction, lonelyTransaction))
    
    "A transaction list" should "contain transactions" in {
        transactionList.transactions should equal (List(fullTransaction, emptyTransaction, lonelyTransaction))
    }
    
    "A transaction list" should "print its transactions" in {
        transactionList.toString should be ("Foo, Bar, Baz\n\nFoo")
    }
}
