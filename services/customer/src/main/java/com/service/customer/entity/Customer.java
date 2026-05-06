package com.service.customer.entity;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
    @Table(name = "customer")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String username;
        private Integer age;
        @Column
        private String cpf;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
    }

