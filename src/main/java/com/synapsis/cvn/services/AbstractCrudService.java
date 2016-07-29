package com.synapsis.cvn.services;

import org.springframework.data.repository.CrudRepository;

import com.synapsis.cvn.persistence.entity.AbstractBasicEntity;


public abstract class AbstractCrudService<M extends AbstractBasicEntity, R extends CrudRepository<M, Long>> {
    protected R repo;
    
    public abstract void setRepo(R repo);
    
    /**
     * Define the parameters that you want to save to the DB when calling the update() method
     * @param from source object
     * @param to DB object that gets saves, "return to" in this method
     * @return
     */
    public abstract M copy(M from, M to);

    public Iterable<M> getAll() {
        return this.repo.findAll();
    }

    /**
     * Mainly used to create a new entity
     * however, can also be used to save something without using the
     * update() method.
     * @param model
     * @return saved entity model
     */
    public M save(M entity) {
        return this.repo.save(entity);
    }

    public M get(Long id) {
        return this.repo.findOne(id);
    }

    public M update(M entity) {
        M updated = this.repo.findOne(entity.getId());
        updated = copy(entity, updated);
        return this.repo.save(updated);
    }

    public Boolean delete(Long id) {
        this.repo.delete(id);
        return true;
    }
}
