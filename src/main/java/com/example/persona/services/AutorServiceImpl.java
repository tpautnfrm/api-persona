package com.example.persona.services;

import com.example.persona.entities.Autor;
import com.example.persona.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiseImpl<Autor,Long> implements AutorService{

    public AutorServiceImpl(BaseRepository<Autor,Long> baseRepository){
        super(baseRepository);
    }
}