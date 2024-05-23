package org.example.friendexam.service;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.repository.FriendRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    @Transactional(readOnly = true)
    public Iterable<Friend> findAllFriend() {
        return friendRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Friend> findAllFriend(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Direction.DESC, "id"));

        return friendRepository.findAll(sortedByDescId);
    }

    @Transactional
    public Friend saveFirend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Transactional(readOnly = true)
    public Friend findFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }
}
