package com.pickle.service.impl;

import com.pickle.persistence.repository.TrashRepository;
import com.pickle.rest.TrashController;
import com.pickle.service.TrashService;
import com.pickle.vo.TrashVO;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

import static org.junit.Assert.*;


public class TrashServiceImplTest {

    @Autowired
    private TrashService trashService;

    @Autowired
    private TrashRepository trashRepository;

    @Autowired
    private TrashController trashController;



    /*@Test
    public void testAdd() throws Exception {
        TrashRepository mockTrashRepository = mock(TrashRepository.class);
        trashService = new TrashServiceImpl(mockTrashRepository);
        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");

        when(trashService.add(trashVO)).thenReturn(trashVO);
        TrashVO resultVo = trashService.add(trashVO);

        assertEquals(trashVO.getId(),resultVo.getId());

    }*/

    @Test
    public void testUpdate() throws Exception {
        /*
        TrashVO trashVO = trashService.update("f6e9b574-30c5-439a-bd40-34026c4b7604", new TrashVO());
        TrashVO trashVO1 = trashService.findById("f6e9b574-30c5-439a-bd40-34026c4b7604");
        assertEquals(trashVO.getTitle(),trashVO1.getTitle());
        */
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        /*
        Collection<TrashVO> trashVOCollection= trashService.findAll();
        assertEquals(trashVOCollection.size(), 7);
        */
    }

    @Test
    public void testFindById() throws Exception {

    }
}