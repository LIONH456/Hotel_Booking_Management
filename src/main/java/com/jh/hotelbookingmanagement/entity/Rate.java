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
    Long rateId;

    @ManyToOne
    @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID")
    Room room;

    @ManyToOne
    @JoinColumn(name = "Rated_By", referencedColumnName = "User_ID")
    User ratedBy;

    @Column(name = "Rate_Date")
    Date rateDate;

    @Column(name = "Rate(Stars)")
    int rateStars;

    @Column(name = "Feedback_Comment")
    String feedback;
}
