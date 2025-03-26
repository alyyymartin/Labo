package com.example.demo.bll.serviceImpl;

import com.example.demo.bll.service.TypeService;
import com.example.demo.dal.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
}
