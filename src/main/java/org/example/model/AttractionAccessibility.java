package org.example.model;

import jakarta.persistence.*;


@Entity
@Table(name="attractionaccessibility")
public class AttractionAccessibility {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private MustTransfer mustTransfer;



}
