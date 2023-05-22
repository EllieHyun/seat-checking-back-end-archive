package com.realtime.seatspringbootbackend.src.store.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreCreateRequestDto;
import com.realtime.seatspringbootbackend.src.store.dto.request.StoreUpdateRequestDto;
import com.realtime.seatspringbootbackend.src.store.exception.StoreNotFoundException;
import com.realtime.seatspringbootbackend.src.store.service.StoreService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/store")
@RequiredArgsConstructor
@Slf4j
public class AdminStoreApi {

    private final StoreService storeService;

    @GetMapping("/{id}") // TODO user id로 받는지?
    public ResponseEntity<StoreEntity> getStore(@PathVariable Long id) {
        try {
            StoreEntity storeEntity = storeService.findById(id);
            return new ResponseEntity<>(storeEntity, HttpStatus.OK); // TODO dto 반환으로 바꾸기
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @PostMapping
    public void postStore(@RequestBody @Valid StoreCreateRequestDto storeCreateRequestDto) {
        try {
            storeService.save(storeCreateRequestDto);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public void updateStore(
            @PathVariable Long id, @RequestBody StoreUpdateRequestDto storeUpdateRequestDto) {
        try {
            storeService.update(id, storeUpdateRequestDto);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        try {
            storeService.delete(id);
        } catch (StoreNotFoundException e) {
            throw new BaseException(e.getResponseCode());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
}
