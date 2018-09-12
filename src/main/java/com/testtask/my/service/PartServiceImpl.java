package com.testtask.my.service;

import com.testtask.my.dao.PartDaoImpl;
import com.testtask.my.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private PartDaoImpl partDao;

    @Override
    public int getTotalPage() {
        return partDao.getTotalPage();
    }

    @Override
    public void createPart(Part part) {
        partDao.createPart(part);
    }

    @Override
    public Part updatePart(Part part) {
        return partDao.updatePart(part);
    }

    @Override
    public void deletePart(int id) {
        partDao.deletePart(id);
    }

    @Override
    public Part searchById(int id) {
        return partDao.searchById(id);
    }

    @Override
    public List<Part> getPageAllParts(int page) {
        return partDao.getPageAllParts(page);
    }

    @Override
    public List<Part> getPageNeedParts(int page, boolean need) {
        return partDao.getPageNeedParts(page, need);
    }

    @Override
    public List<Part> searchPart(String detail) {
        return partDao.searchPart(detail);
    }

    @Override
    public List<Part> getAllNeedParts() {
        return partDao.getAllNeedParts();
    }

    @Override
    public List<Part> getAllParts() {
        return partDao.getAllParts();
    }

    @Override
    public int totalAssembleComp() {
        int totalMB = 0, totalProc = 0, totalHDD = 0, totalDIMM = 0, totalCase = 0;
        for (Part p: getAllNeedParts()) {
            if (p.getDetail().trim().toLowerCase().contains("motherboard")) totalMB += p.getAmount();
            if (p.getDetail().trim().toLowerCase().contains("processor")) totalProc += p.getAmount();
            if (p.getDetail().trim().toLowerCase().contains("hdd") || p.getDetail().trim().toLowerCase().contains("ssd"))
                totalHDD += p.getAmount();
            if (p.getDetail().trim().toLowerCase().contains("dimm")) totalDIMM += p.getAmount();
            if (p.getDetail().trim().toLowerCase().contains("case")) totalCase += p.getAmount();
        }

        return Math.min(Math.min(Math.min(totalMB, totalProc), Math.min(totalHDD, totalDIMM)), totalCase);
    }
}
