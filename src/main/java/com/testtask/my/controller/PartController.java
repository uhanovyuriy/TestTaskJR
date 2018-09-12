package com.testtask.my.controller;

import com.testtask.my.entity.Part;
import com.testtask.my.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PartController {
    private int countPage = 0;
    private int statusSorted = 0;

    @Autowired
    private PartService partService;

    @RequestMapping("createPart")
    public ModelAndView createPart(@ModelAttribute Part part) {
        return new ModelAndView("partForm");
    }

    @RequestMapping("editPart")
    public ModelAndView editPart(@RequestParam int id, @ModelAttribute Part part) {
        part = partService.searchById(id);
        return new ModelAndView("partForm", "partObject", part);
    }

    @RequestMapping("savePart")
    public ModelAndView savePart(@ModelAttribute Part part) {
        if (part.getId() != 0) {
            partService.updatePart(part);
        } else {
            partService.createPart(part);
        }
        return new ModelAndView("redirect:getPageAllParts");
    }

    @RequestMapping("deletePart")
    public ModelAndView deletePart(@RequestParam int id) {
        partService.deletePart(id);
        return new ModelAndView("redirect:getPageAllParts");
    }

    @RequestMapping("searchPart")
    public ModelAndView searchPart(@RequestParam("searchName") String searchName) {
        return new ModelAndView("partsList", "partList", partService.searchPart(searchName));
    }

    @RequestMapping(value = {"getPageAllParts", "/"})
    public ModelAndView getPageAllParts() {
        statusSorted = 0;
        ModelAndView model = new ModelAndView();
        model.setViewName("partsList");
        model.addObject("partList", partService.getPageAllParts(countPage));
        model.addObject("numComp", partService.totalAssembleComp());
        return model;
    }

    @RequestMapping("getPagePartsNeed")
    public ModelAndView getPagePartsNeed() {
        if (statusSorted != 1) countPage = 0;
        statusSorted = 1;
        ModelAndView model = new ModelAndView();
        model.setViewName("partsList");
        model.addObject("partList", partService.getPageNeedParts(countPage, true));
        model.addObject("numComp", partService.totalAssembleComp());
        return model;
    }

    @RequestMapping("getPagePartsOptional")
    public ModelAndView getPagePartsOptional() {
        if (statusSorted != 2) countPage = 0;
        statusSorted = 2;
        ModelAndView model = new ModelAndView();
        model.setViewName("partsList");
        model.addObject("partList", partService.getPageNeedParts(countPage, false));
        model.addObject("numComp", partService.totalAssembleComp());
        return model;
    }

    @RequestMapping("previousPage")
    public ModelAndView getPreviousPage() {
        countPage--;
        if (countPage < 0) countPage++;
        switch (statusSorted) {
            case 1: return new ModelAndView("redirect:getPagePartsNeed");
            case 2: return new ModelAndView("redirect:getPagePartsOptional");
            default: return new ModelAndView("redirect:getPageAllParts");
        }
    }

    @RequestMapping("nextPage")
    public ModelAndView nextPage() {
        countPage++;
        if (countPage > partService.getTotalPage()) countPage--;
        switch (statusSorted) {
            case 1: return new ModelAndView("redirect:getPagePartsNeed");
            case 2: return new ModelAndView("redirect:getPagePartsOptional");
            default: return new ModelAndView("redirect:getPageAllParts");
        }
    }


}
