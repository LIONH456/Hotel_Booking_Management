package com.jh.hotelbookingmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Picture_Category")
public class PictureCategory {
    @Id
    @Column(name="Category_Name")
    String categoryName;

    @Column(name="Description")
    String description;
}
