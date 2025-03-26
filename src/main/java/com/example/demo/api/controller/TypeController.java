package com.example.demo.api.controller;

import com.example.demo.bll.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;
}
