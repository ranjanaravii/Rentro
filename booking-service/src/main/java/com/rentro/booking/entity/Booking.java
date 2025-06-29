package com.rentro.booking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@EntityListeners(AuditingEntityListener.class)
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Property ID is required")
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    
    @NotNull(message = "Tenant ID is required")
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
    
    @NotNull(message = "Owner ID is required")
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus = BookingStatus.PENDING;
    
    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;
    
    @Column(name = "move_in_date")
    private LocalDateTime moveInDate;
    
    @Column(name = "lease_start_date")
    private LocalDateTime leaseStartDate;
    
    @Column(name = "lease_end_date")
    private LocalDateTime leaseEndDate;
    
    @Column(name = "monthly_rent", precision = 10, scale = 2)
    private BigDecimal monthlyRent;
    
    @Column(name = "security_deposit", precision = 10, scale = 2)
    private BigDecimal securityDeposit;
    
    @Column(name = "advance_payment", precision = 10, scale = 2)
    private BigDecimal advancePayment;
    
    @Column(name = "tenant_message", columnDefinition = "TEXT")
    private String tenantMessage;
    
    @Column(name = "owner_response", columnDefinition = "TEXT")
    private String ownerResponse;
    
    @Column(name = "rejection_reason", columnDefinition = "TEXT")
    private String rejectionReason;
    
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Booking() {}
    
    public Booking(Long propertyId, Long tenantId, Long ownerId, LocalDateTime bookingDate) {
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.ownerId = ownerId;
        this.bookingDate = bookingDate;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
    
    public Long getTenantId() { return tenantId; }
    public void setTenantId(Long tenantId) { this.tenantId = tenantId; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }
    
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    
    public LocalDateTime getMoveInDate() { return moveInDate; }
    public void setMoveInDate(LocalDateTime moveInDate) { this.moveInDate = moveInDate; }
    
    public LocalDateTime getLeaseStartDate() { return leaseStartDate; }
    public void setLeaseStartDate(LocalDateTime leaseStartDate) { this.leaseStartDate = leaseStartDate; }
    
    public LocalDateTime getLeaseEndDate() { return leaseEndDate; }
    public void setLeaseEndDate(LocalDateTime leaseEndDate) { this.leaseEndDate = leaseEndDate; }
    
    public BigDecimal getMonthlyRent() { return monthlyRent; }
    public void setMonthlyRent(BigDecimal monthlyRent) { this.monthlyRent = monthlyRent; }
    
    public BigDecimal getSecurityDeposit() { return securityDeposit; }
    public void setSecurityDeposit(BigDecimal securityDeposit) { this.securityDeposit = securityDeposit; }
    
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public void setAdvancePayment(BigDecimal advancePayment) { this.advancePayment = advancePayment; }
    
    public String getTenantMessage() { return tenantMessage; }
    public void setTenantMessage(String tenantMessage) { this.tenantMessage = tenantMessage; }
    
    public String getOwnerResponse() { return ownerResponse; }
    public void setOwnerResponse(String ownerResponse) { this.ownerResponse = ownerResponse; }
    
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    // Enums
    public enum BookingStatus {
        PENDING, APPROVED, REJECTED, CANCELLED, COMPLETED
    }
}
