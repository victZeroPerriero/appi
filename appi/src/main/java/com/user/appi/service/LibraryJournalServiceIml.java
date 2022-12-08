package com.user.appi.service;

import com.user.appi.dto.BookDto;
import com.user.appi.mapper.LibraryJournalMapper;
import com.user.appi.model.Book;
import com.user.appi.model.LibraryJournal;
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

    private Book getBookFromList(Long bookId){
        return userRepo.findAll().stream()
                .map(User::getBookList)
                .flatMap(books -> books.stream().filter(book -> book.getId().equals(bookId)))
                .findFirst().get();
    }
}
