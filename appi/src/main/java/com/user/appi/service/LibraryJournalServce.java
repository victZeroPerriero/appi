package com.user.appi.service;


import com.user.appi.dto.BookDto;
import com.user.appi.model.User;

import java.util.List;

public interface LibraryJournalServce {
    BookDto findBookByUser(Long bookId);
    BookDto findBookByUserName(String name);
}
