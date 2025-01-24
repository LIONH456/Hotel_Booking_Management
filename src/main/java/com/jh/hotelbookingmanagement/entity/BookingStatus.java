package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_status")
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_status_id")
    private Long bookingStatusId;
    
    @Column(name = "booking_status")
    private String bookingStatus;
    
    private String description;

    @OneToMany(mappedBy = "bookingStatus")
    private List<BookingDetail> bookingDetails;
}
