package com.testtask.my.service;

import com.testtask.my.entity.Part;
import java.util.List;

public interface PartService {

    int getTotalPage();

    void createPart(Part part);

    Part updatePart(Part part);

    Part searchById(int id);

    void deletePart(int id);

    List<Part> getPageAllParts(int page);

    List<Part> getPageNeedParts(int page, boolean need);

    List<Part> searchPart(String detail);

    List<Part> getAllNeedParts();

    List<Part> getAllParts();

    int totalAssembleComp();
}
