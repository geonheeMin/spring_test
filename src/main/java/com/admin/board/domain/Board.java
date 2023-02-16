package com.admin.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String user;
    private String category;
    private String content;
    private String date;

    public Board(int id, String title, String user, String category, String content, String Date) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.category = category;
        this.content = content;
        this.date = date;
    }
}
