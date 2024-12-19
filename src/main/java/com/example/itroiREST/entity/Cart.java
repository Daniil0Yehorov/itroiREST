package com.example.itroiREST.entity;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private int userId;
    private List<Integer> productIds;
    private double totalAmount;
    private String status;
    public Cart (){}
    public Cart(int userId, List<Integer> productIds, double totalAmount, String status) {
        this.userId = userId;
        this.productIds = productIds;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public List<Integer> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", productIds=" + productIds +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}