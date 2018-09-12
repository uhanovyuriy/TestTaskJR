package com.testtask.my.dao;

import com.testtask.my.entity.Part;
import com.testtask.my.util.HibernateUtil;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PartDaoImpl implements PartDao {

    @Autowired
    private HibernateUtil hibernateUtil;

    private int totalPage = 0;

    @Override
    public int getTotalPage() {
        return totalPage;
    }

    @Override
    public int createPart(Part part) {
        return (int) hibernateUtil.createPart(part);
    }

    @Override
    public Part updatePart(Part part) {
        return hibernateUtil.updatePart(part);
    }

    @Override
    public void deletePart(int id) {
        Part part = new Part();
        part.setId(id);
        hibernateUtil.deletePart(part);
    }

    @Override
    public Part searchById(int id) {
        return hibernateUtil.searchById(id, Part.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getPageAllParts(int page) {
        Query query = hibernateUtil.getQuery("FROM Part");
        totalPage = query.list().size();
        if (totalPage != 0) {
            if (totalPage % 10 != 0) totalPage /= 10;
            else totalPage = (totalPage - 1) / 10;
        }
        query.setFirstResult(page*10);
        query.setMaxResults(10);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getPageNeedParts(int page, boolean need) {
        int intNeed = need?1:0;
        Query query = hibernateUtil.getQuery("FROM Part where need = " + "'" + intNeed + "'");
        totalPage = query.list().size();
        if (totalPage != 0) {
            if (totalPage % 10 != 0) totalPage /= 10;
            else totalPage = (totalPage - 1) / 10;
        }
        query.setFirstResult(page*10);
        query.setMaxResults(10);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> searchPart(String detail) {
        return (List<Part>) hibernateUtil.getQuery("FROM Part where detail = " + "'" + detail + "'").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getAllNeedParts() {
        return (List<Part>) hibernateUtil.getQuery("FROM Part where need = '1'").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getAllParts() {
        return (List<Part>) hibernateUtil.getQuery("From Part").list();
    }
}
