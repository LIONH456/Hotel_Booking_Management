package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Picture_ID")
    Long pictureId;

    @Column(name="Picture_Name")
    String name;

    @Column(name = "Picture_Path")
    String path;

    // updatable = false: Once a value is set, it cannot be modified through JPA updates.
    // @Temporal(TemporalType.TIMESTAMP): This specifies that the database column should store both date and time information
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Upload_Date", updatable = false)
    Date uploadDate;

    @ManyToOne
    PictureCategory category;
}