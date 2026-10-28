package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(WiseSayingRepository wiseSayingRepository) {
        this.wiseSayingRepository = wiseSayingRepository;
    }

    public WiseSaying write(String sentence, String author) {
        return wiseSayingRepository.save(new WiseSaying(sentence, author));
    }

    public List<WiseSaying> findForList() {
        return wiseSayingRepository.findForList();
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public void modify(WiseSaying wiseSaying, String sentence, String author) {
        wiseSaying.setSentence(sentence);
        wiseSaying.setAuthor(author);
        wiseSayingRepository.save(wiseSaying);
    }
}
