package com.example.persona.services;

import com.example.persona.entities.Base;
import com.example.persona.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiseImpl<E extends Base, ID extends Serializable> implements BaseServise<E,ID>{

    protected BaseRepository<E,ID> baseRepository;

    public BaseServiseImpl(BaseRepository<E,ID> baseRepository){
        this.baseRepository=baseRepository;
    }

    @Override
    @Transactional
    public Page<E> findall(Pageable pageable) throws Exception{
        try{
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public List<E> findall() throws Exception {
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> optionalEntity = baseRepository.findById(id);
            return optionalEntity.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> optionalE = baseRepository.findById(id);
            E ent = optionalE.get();
            ent = baseRepository.save(entity);
            return ent;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
