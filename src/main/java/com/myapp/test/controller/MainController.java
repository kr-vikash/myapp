package com.myapp.test.controller;


import com.myapp.test.model.Grid;
import com.myapp.test.model.WebDataModel;
import com.myapp.test.service.GridService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Vikash
 */
@RequestMapping("/user")
@RestController
public class MainController {

    GridService gridService;

    @RequestMapping( value ="/grid", method = RequestMethod.POST)
    public List<Character> createGrid(@RequestBody WebDataModel webDataModel){
        gridService=new GridService();

        Grid gridData=webDataModel.getGrid();
        for(int i=0;i<gridData.getEdges().size();i++){
            gridData.getEdges().get(i).setWeight();
        }
        if (!gridService.checkValidGrid(gridData)){
            System.out.println("invalid grid Data");
            return null;
        }
       return gridService.getShortestPath(webDataModel);
    }


}
