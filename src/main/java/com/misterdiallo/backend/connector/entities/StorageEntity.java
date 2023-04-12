package com.misterdiallo.backend.connector.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name="storage")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String url;

    private String credentials;

    // constructors, getters, and setters

}

