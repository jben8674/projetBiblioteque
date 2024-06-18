package com.Bengono.ProjetBiblioteque.model;

import jakarta.persistence.*;
import lombok.*;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @Entity
    @Table(name="borrower")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;
        @Column(nullable = false)
        private   String name;
        @Column(nullable = false)
        private  String firstName;
        @Column(nullable = false)
        private  String Email;

}




