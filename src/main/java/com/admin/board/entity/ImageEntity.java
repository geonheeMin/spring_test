package com.admin.board.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;

@Builder
@ToString
@Entity(name="imageTest")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageEntity {
    @Id
    @Column(name="id")
    public int id;

    @Column(name="uri")
    @Lob
    public Blob uri;

    @Column(name="name")
    public String name;

    @Column(name="type")
    public String type;
}
