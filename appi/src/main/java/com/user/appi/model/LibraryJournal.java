package com.user.appi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "libraryjournal")
public class LibraryJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "book_id")
//    private Long bookId;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<User> userList;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Book> list;

}
