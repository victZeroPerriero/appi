package com.user.appi.service;

import com.user.appi.dto.BookDto;
import com.user.appi.listjanr.ResponseByJanrBook;
import com.user.appi.listjanr.ListJanrBook;
import com.user.appi.mapper.LibraryJournalMapper;
import com.user.appi.model.Book;
import com.user.appi.model.User;
import com.user.appi.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LibraryJournalServiceIml implements LibraryJournalServce {
    private final UserRepo userRepo;
    private final LibraryJournalMapper libraryJournalMapper;
    @Override
    public BookDto findBookByUser(Long bookId) {
        return libraryJournalMapper.fromEntityToDto(getBookFromList(bookId));
    }

    @Override
    public BookDto findBookByUserName(String name) {
        return  libraryJournalMapper.fromEntityToDto(
                getUserFromList(name)
        );
    }

    @Override
    public String listJanr(String name) {
        for (ListJanrBook list : ListJanrBook.values()) {
            if ( list.getNumber().equals(name) ){
              return ResponseByJanrBook.VALUE_IS_FIND;
            }
        }
        return ResponseByJanrBook.VALUES_IS_NOT_FOUND;
    }

    private Book getBookFromList(Long bookId){
        return userRepo.findAll().stream()
                .map(User::getBookList)
                .flatMap(books -> books.stream().filter(book -> book.getId().equals(bookId)))
                .findFirst().get();
    }

    private Book getUserFromList(String name){
         return userRepo.findAll().stream()
                .filter(users -> users.getFirstName().equals(name) || users.getLastName().equals(name))
                .findFirst().get()
                 .getBookList().stream()
                 .findFirst()
                 .get();
    }
}
