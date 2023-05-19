package com.realtime.seatspringbootbackend.src.store.api;

import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import com.realtime.seatspringbootbackend.src.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/store")
@RequiredArgsConstructor
@Slf4j
public class AdminStoreApi {

    private final StoreService storeService;

    @GetMapping("/information/{id}")   // TODO user id로 받는지?
    public ResponseEntity<String> getStore(@PathVariable Long id) {
        try {
            StoreEntity storeEntity = storeService.findById(id);
            return ResponseEntity.status(200).body(storeEntity.toString());
        } catch (StoreNotFoundException e) {
            return ResponseEntity.status(e.getStoreErrorCode().getStatus()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
