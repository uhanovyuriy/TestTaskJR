package com.testtask.my.dao;

import com.testtask.my.entity.Part;
import java.util.List;

public interface PartDao {

    int getTotalPage();

    int createPart(Part part);

    Part updatePart(Part part);

    Part searchById(int id);

    void deletePart(int id);

    List<Part> getPageAllParts(int page);

    List<Part> getPageNeedParts(int page, boolean need);

    List<Part> searchPart(String detail);

    List<Part> getAllNeedParts();

    List<Part> getAllParts();
}
