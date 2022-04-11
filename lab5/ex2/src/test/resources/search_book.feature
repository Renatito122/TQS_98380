Feature: Book Search
    To allow a customer to find for a book fast, the library must allow him to search by author, title, or publication date

    Background:
        Given a book with the title "Ensaio sobre a Cegueira", written by "José Saramago", published in "1995-07-08"
            And a book with the title "Ensaio sobre a Lucidez", written by "George RR Martin", published in "2004-09-15"
            And a book with the title "a book", written by "a guy", published in "1996-11-13"

    Scenario: Search books by publication year
        When the customer searches for books published between "1994-02-01" and "1998-03-24"
        Then 2 books should have been found
            And Book 1 should have the title "Some book"
            And Book 2 should have the title "Ensaio sobre a Cegueira" 
            

    Scenario: Search books by author
        When the customer searches for books written by "Saramago"
        Then 2 books should have been found
            And Book 1 should have the title "Ensaio sobre a Lucidez"
            And Book 2 should have the title "Ensaio sobre a Cegueira" 
    
    Scenario: Search books by title
        When the customer searches for books with title "Lucidez"
        Then 1 books should have been found
            And Book 1 should have the title "Ensaio sobre a Lucidez"

