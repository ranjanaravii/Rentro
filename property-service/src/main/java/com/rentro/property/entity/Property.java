package com.rentro.property.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "properties")
@EntityListeners(AuditingEntityListener.class)
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Owner ID is required")
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    
    @NotNull(message = "Society ID is required")
    @Column(name = "society_id", nullable = false)
    private Long societyId;
    
    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false)
    private PropertyType propertyType;
    
    @Column(name = "bhk_type")
    private String bhkType; // 1BHK, 2BHK, 3BHK, etc.
    
    @Column(name = "carpet_area")
    private Integer carpetArea; // in sq ft
    
    @Column(name = "built_up_area")
    private Integer builtUpArea; // in sq ft
    
    @NotNull(message = "Monthly rent is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Monthly rent must be greater than 0")
    @Column(name = "monthly_rent", nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyRent;
    
    @Column(name = "security_deposit", precision = 10, scale = 2)
    private BigDecimal securityDeposit;
    
    @Column(name = "maintenance_charges", precision = 10, scale = 2)
    private BigDecimal maintenanceCharges;
    
    @Column(name = "floor_number")
    private Integer floorNumber;
    
    @Column(name = "total_floors")
    private Integer totalFloors;
    
    @Column(name = "flat_number")
    private String flatNumber;
    
    @Column(name = "furnishing_status")
    @Enumerated(EnumType.STRING)
    private FurnishingStatus furnishingStatus;
    
    @Column(name = "parking_available")
    private Boolean parkingAvailable = false;
    
    @Column(name = "balcony_count")
    private Integer balconyCount = 0;
    
    @Column(name = "bathroom_count")
    private Integer bathroomCount;
    
    @Column(name = "preferred_tenant_type")
    @Enumerated(EnumType.STRING)
    private PreferredTenantType preferredTenantType;
    
    @Column(name = "available_from")
    private LocalDateTime availableFrom;
    
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;
    
    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;
    
    @ElementCollection
    @CollectionTable(name = "property_images", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;
    
    @ElementCollection
    @CollectionTable(name = "property_amenities", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenity")
    private List<String> amenities;
    
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Property() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public Long getSocietyId() { return societyId; }
    public void setSocietyId(Long societyId) { this.societyId = societyId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public PropertyType getPropertyType() { return propertyType; }
    public void setPropertyType(PropertyType propertyType) { this.propertyType = propertyType; }
    
    public String getBhkType() { return bhkType; }
    public void setBhkType(String bhkType) { this.bhkType = bhkType; }
    
    public Integer getCarpetArea() { return carpetArea; }
    public void setCarpetArea(Integer carpetArea) { this.carpetArea = carpetArea; }
    
    public Integer getBuiltUpArea() { return builtUpArea; }
    public void setBuiltUpArea(Integer builtUpArea) { this.builtUpArea = builtUpArea; }
    
    public BigDecimal getMonthlyRent() { return monthlyRent; }
    public void setMonthlyRent(BigDecimal monthlyRent) { this.monthlyRent = monthlyRent; }
    
    public BigDecimal getSecurityDeposit() { return securityDeposit; }
    public void setSecurityDeposit(BigDecimal securityDeposit) { this.securityDeposit = securityDeposit; }
    
    public BigDecimal getMaintenanceCharges() { return maintenanceCharges; }
    public void setMaintenanceCharges(BigDecimal maintenanceCharges) { this.maintenanceCharges = maintenanceCharges; }
    
    public Integer getFloorNumber() { return floorNumber; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }
    
    public Integer getTotalFloors() { return totalFloors; }
    public void setTotalFloors(Integer totalFloors) { this.totalFloors = totalFloors; }
    
    public String getFlatNumber() { return flatNumber; }
    public void setFlatNumber(String flatNumber) { this.flatNumber = flatNumber; }
    
    public FurnishingStatus getFurnishingStatus() { return furnishingStatus; }
    public void setFurnishingStatus(FurnishingStatus furnishingStatus) { this.furnishingStatus = furnishingStatus; }
    
    public Boolean getParkingAvailable() { return parkingAvailable; }
    public void setParkingAvailable(Boolean parkingAvailable) { this.parkingAvailable = parkingAvailable; }
    
    public Integer getBalconyCount() { return balconyCount; }
    public void setBalconyCount(Integer balconyCount) { this.balconyCount = balconyCount; }
    
    public Integer getBathroomCount() { return bathroomCount; }
    public void setBathroomCount(Integer bathroomCount) { this.bathroomCount = bathroomCount; }
    
    public PreferredTenantType getPreferredTenantType() { return preferredTenantType; }
    public void setPreferredTenantType(PreferredTenantType preferredTenantType) { this.preferredTenantType = preferredTenantType; }
    
    public LocalDateTime getAvailableFrom() { return availableFrom; }
    public void setAvailableFrom(LocalDateTime availableFrom) { this.availableFrom = availableFrom; }
    
    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
    
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
    
    public List<String> getImageUrls() { return imageUrls; }
    public void setImageUrls(List<String> imageUrls) { this.imageUrls = imageUrls; }
    
    public List<String> getAmenities() { return amenities; }
    public void setAmenities(List<String> amenities) { this.amenities = amenities; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    // Enums
    public enum PropertyType {
        APARTMENT, VILLA, STUDIO, PENTHOUSE
    }
    
    public enum FurnishingStatus {
        FULLY_FURNISHED, SEMI_FURNISHED, UNFURNISHED
    }
    
    public enum PreferredTenantType {
        FAMILY, BACHELOR_MALE, BACHELOR_FEMALE, ANY
    }
}
