package com.example.fitXperience.Dto;

public class BookingRequest {
    private Long userId;
    private Long packageId;
    private boolean paid;

    public BookingRequest(Long userId, Long packageId, boolean paid) {
        this.userId = userId;
        this.packageId = packageId;
        this.paid = paid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    // Getters and setters
}
