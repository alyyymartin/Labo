package com.example.demo.api.controller;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.Create.CreateTypeResponse;
import com.example.demo.api.model.type.FindByType.FindTypeByTypeResponse;
import com.example.demo.api.model.type.GetAll.GetAllTypesResponse;
import com.example.demo.bll.service.TypeService;
import com.example.demo.dal.domain.entity.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;

    @PostMapping("/create")
        public ResponseEntity<CreateTypeResponse> createType (@RequestBody CreateTypeRequest createTypeRequest){
            return ResponseEntity.ok(typeService.createType(createTypeRequest));
        }

    @GetMapping("/{type}")
    public ResponseEntity<FindTypeByTypeResponse> findTypeByType(@PathVariable String type) {
        return ResponseEntity.ok(typeService.findTypeByType(type));
    }

    @GetMapping("")
    public ResponseEntity<GetAllTypesResponse> getAllTypes() {
        List<Type> setAllTypes = new ArrayList<>(typeService.getAllTypes());
        GetAllTypesResponse setAllTypesResponse = new GetAllTypesResponse(setAllTypes);
        return ResponseEntity.ok(setAllTypesResponse);
    }


}

