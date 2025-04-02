package com.example.demo.api.controller;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.Create.CreateTypeResponse;
import com.example.demo.api.model.type.DeleteByType.DeleteTypeByTypeResponse;
import com.example.demo.api.model.type.FindByType.FindTypeByTypeResponse;
import com.example.demo.api.model.type.GetAll.GetAllTypesResponse;
import com.example.demo.api.model.type.UpdateTypeByType.UpdateTypeByTypeRequest;
import com.example.demo.api.model.type.UpdateTypeByType.UpdateTypeByTypeResponse;
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
        Type typeToCreate = typeService.createType(createTypeRequest);
        return ResponseEntity.ok(new CreateTypeResponse("Le type suivant a bien été créé : ", typeToCreate));
    }

    @PatchMapping("/{type}")
    public ResponseEntity<UpdateTypeByTypeResponse> updateType (@PathVariable String type,@RequestBody UpdateTypeByTypeRequest updateTypeRequest){
        Type updatedType = typeService.updateTypeByType(updateTypeRequest);
        return ResponseEntity.ok(new UpdateTypeByTypeResponse("Nouvelles infos : ", updatedType));
    }

    @GetMapping("/{type}")
    public ResponseEntity<FindTypeByTypeResponse> findTypeByType(@PathVariable String type) {
        Type typeToFind = typeService.findTypeByType(type);
        return ResponseEntity.ok(new FindTypeByTypeResponse("Le type recherché est le suivant : ", typeToFind));
    }

    @GetMapping("")
    public ResponseEntity<GetAllTypesResponse> getAllTypes() {
        List<Type> setAllTypes = new ArrayList<>(typeService.getAllTypes());
        GetAllTypesResponse setAllTypesResponse = new GetAllTypesResponse(setAllTypes);
        return ResponseEntity.ok(setAllTypesResponse);
    }

    @DeleteMapping ("/{type}/delete")
    public ResponseEntity<DeleteTypeByTypeResponse> deleteTypeByType (@PathVariable String type) {
        Type typeToDelete = typeService.findTypeByType(type);
        typeService.deleteTypeByType(type);
        return ResponseEntity.ok(new DeleteTypeByTypeResponse("Le type suivant a bien été supprimé : ", typeToDelete));
    }

}

