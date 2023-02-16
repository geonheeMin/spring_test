package com.admin.board.controller;

import com.admin.board.domain.Board;
import com.admin.board.domain.Item;
import com.admin.board.entity.CRUDEntity;
import com.admin.board.entity.ImageEntity;
import com.admin.board.repository.CRUDRepository;
import com.admin.board.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.sql.rowset.serial.SerialBlob;
import javax.transaction.Transactional;
import java.sql.Blob;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
@Service
public class BoardController {
    private final CRUDRepository cr;
    private final ImageRepository ir;
    @GetMapping("/api/items")
    public Item first() {
        Item item = new Item(777, 300, 320000);
        return item;
    }

    @GetMapping("/api/insert")
    public void boardInsert(@RequestParam String title, @RequestParam String user, @RequestParam String category, @RequestParam String content, @RequestParam String date) {
        System.out.println(String.format("title: %s\nuser:%s\ncategory:%s\ncontent:%s\ndate:%s",title, user, category, content, date));
        CRUDEntity entity = CRUDEntity.builder().title(title).user(user).category(category).content(content).date(date).build();
        cr.save(entity);
    }

    @GetMapping("/api/list")
//    public String boardList() {
//        Collection<CRUDEntity> result = cr.findById(32);
//        String[] boardInfo = result.toString().substring(12, result.toString().length()-2).split(",");
//        for (int i = 0; i < boardInfo.length; i++) {
//            boardInfo[i] = boardInfo[i].split("=")[1];
//        }
//        Board board = new Board(Integer.valueOf(boardInfo[0]), boardInfo[1], boardInfo[2], boardInfo[3], boardInfo[4], boardInfo[5]);
//        return board;
//        return cr.findAll().toString().split(",")[0];
//    }
    public List<CRUDEntity> boardList() {
        return cr.findAll();
    }

    @GetMapping("api/detail")
    public Optional<CRUDEntity> boardDetail(Long id) {
        return cr.findById(id);
    }

    @GetMapping("api/update")
    public void boardUpdate(@RequestParam String title, @RequestParam String user, @RequestParam String category, @RequestParam String content, @RequestParam String date) {
        System.out.println("받아오기");
        CRUDEntity newEntity = cr.findByDate(date);
        System.out.println(String.format("title: %s\n", newEntity.title));
        newEntity.setTitle(title);
        newEntity.setCategory(category);
        newEntity.setUser(user);
        newEntity.setContent(content);
        cr.save(newEntity);
    }

    @GetMapping("api/image")
    public void getImageItem(@RequestParam Blob uri, @RequestParam String type, @RequestParam String name) {
        ImageEntity inset = new ImageEntity();
        inset.setUri(uri);
        inset.setName(name);
        inset.setType(type);
        inset.setId(2);

        ir.save(inset);
    }
}
