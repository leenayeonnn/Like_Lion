package org.example.restexam.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    private final Map<Long, String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content) {
        Long id = counter.incrementAndGet();

        memos.put(id, content);

        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMemo(@PathVariable("id") Long id) {
        String memo = memos.get(id);
        if (memo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(memo);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id, @RequestBody String content) {
        if(!memos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        memos.put(id, content);
        return ResponseEntity.ok("update to : " + content);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id) {
        String removeMemo = memos.remove(id);
        if (removeMemo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("remove");
    }
}
