package com.libraryManagement.enumeration;
public enum BookStatus {





    AVAILABLE("Available"), RESERVED("Reserved"), BORROWED("Borrowed"), OVERDUE("Overdue"), LOST("Lost"), DAMAGED("Damaged");

    // declaring private variable for getting values
    private String status;

    // getter method
    public String getStatus() {
        return this.status;
    }

    // enum constructor - cannot be public or protected
    private BookStatus(String status) {
        this.status = status;
    }
}