package com.misterdiallo.backend.connector.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="dataset")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DataSetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "data_source_id")
    private DataSourceEntity dataSource;

    // getters and setters

}
