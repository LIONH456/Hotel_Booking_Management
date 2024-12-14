package com.jh.hotelbookingmanagement.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rate_ID")
    int rateId;

    @Column(name = "Room_ID")
    String roomId;

    @Column(name = "Rated_By")
    String ratedBy;

    @Column(name = "Rate_Date")
    Date rateDate;

    @Column(name = "Rate(Stars)")
    int rateStars;

    @Column(name = "Feedback_Comment")
    String feedback;
}
