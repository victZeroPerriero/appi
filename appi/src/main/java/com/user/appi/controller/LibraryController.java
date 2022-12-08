package com.user.appi.controller;


import com.user.appi.dto.BookDto;
import com.user.appi.service.LibraryJournalServce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libraryjournal")
@Slf4j
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryJournalServce libraryJournalServce;

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable("id") Long id){
        return libraryJournalServce.findBookByUser(id);
    }
}
