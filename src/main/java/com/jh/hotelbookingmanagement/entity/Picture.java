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

    @Column(name = "Picture_Path")
    String picturePath;

    @Column(name = "Description")
    String description;

    @Column(name = "Upload_Date")
    Date uploadDate;

    @Column(name="category")
    String category;
}