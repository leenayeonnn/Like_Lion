package org.example.personal_project2.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.personal_project2.domain.Board;
import org.example.personal_project2.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    @Transactional(readOnly = true)
    public Page<Board> findAllBoard(Pageable pageable) {
        Pageable sortedByDescDate = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Direction.DESC, "createdAt"));

        return repository.findAll(sortedByDescDate);
    }

    public Board findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void saveBoard(Board board) {
        LocalDateTime date = LocalDateTime.now();
        board.setCreatedAt(date);
        board.setUpdatedAt(date);
        repository.save(board);
    }

    @Transactional
    public boolean deleteBoard(Long id, String password) {
        Board board = findById(id);
        if (board.getPassword().equals(password)) {
            repository.delete(board);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateBoard(Board newBoard) {
        Board oldBoard = findById(newBoard.getId());
        if (oldBoard.getPassword().equals(newBoard.getPassword())) {
            newBoard.setUpdatedAt(LocalDateTime.now());
            repository.save(newBoard);
            return true;
        }
        return false;
    }
}
