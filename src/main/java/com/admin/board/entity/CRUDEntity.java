package com.admin.board.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@ToString
@Entity(name="board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CRUDEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, name="title")
    public String title;

    @Column(nullable = false, name="user")
    public String user;
    @Column (nullable = false, name="category")
    public String category;
    @Column (nullable = false, name="content")
    public String content;
    @Column (nullable = false, name="date")
    public String date;
}
