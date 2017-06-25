package com.pizzaworld.common.dao.test;


import com.pizzaworld.common.test.AbstractTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class AbstractRepositoryTest<E extends AbstractPersistable<Long>, T extends JpaRepository<E, Long>> extends AbstractTest {

    @Before
    public void init() {
        getRepository().deleteAll();
    }

    @After
    public void destroy() {
        getRepository().deleteAll();
    }

    @Test
    public void shouldFindById() {
        E entity = getRepository().save(getRandomEntity());
        E found = getRepository().findOne(entity.getId());
        Assert.assertEquals(entity, found);
    }

    @Test
    public void shouldFindAll() {
        E entity = getRepository().save(getRandomEntity());
        List<E> result = getRepository().findAll();
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(entity, result.get(0));
    }

    @Test
    public void shouldSaveEntity() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertNotNull(entity);
        Assert.assertNotNull(entity.getId());
    }

    @Test
    public void shouldSaveMultipleEntities() {

        Assert.assertEquals(0L, getRepository().count());

        getRepository().save(getRandomEntity());
        getRepository().save(getRandomEntity());

        Assert.assertEquals(2L, getRepository().count());
    }

    @Test
    public void shouldModifyEntity() {
        E entity = getRepository().save(getRandomEntity());
        getRepository().save(getModifiedEntity(entity));
        Assert.assertEquals(1L, getRepository().count());
    }

    @Test
    public void shouldDeleteEntity() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertEquals(1L, getRepository().count());
        getRepository().delete(entity);
        Assert.assertEquals(0L, getRepository().count());
    }

    @Test
    public void shouldDeleteEntityById() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertEquals(1L, getRepository().count());
        getRepository().delete(entity.getId());
        Assert.assertEquals(0L, getRepository().count());
    }

    @Test
    public void shouldCheckEntityToString() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertNotNull(entity);
        getRepository().deleteAll();
    }

    @Test
    public void shouldCheckEntityEquals() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertEquals(entity, entity);
        Assert.assertNotEquals(entity, getRepository().save(getRandomEntity()));
        getRepository().deleteAll();
    }

    @Test
    public void shouldCheckEntityHashCode() {
        E entity = getRepository().save(getRandomEntity());
        Assert.assertEquals(entity.hashCode(), entity.hashCode());
        Assert.assertNotEquals(entity.hashCode(), getRepository().save(getRandomEntity()).hashCode());
        getRepository().deleteAll();
    }

    public abstract E getRandomEntity();

    public abstract E getModifiedEntity(E entity);

    public abstract T getRepository();
}
