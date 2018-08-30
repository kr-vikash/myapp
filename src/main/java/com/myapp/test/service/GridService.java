package com.myapp.test.service;

import com.myapp.test.model.Edge;
import com.myapp.test.model.Grid;
import com.myapp.test.model.WebDataModel;
import java.util.*;

/**
 * @Author Vikash
 */
public class GridService {
    Map<Character,Integer> indexMapWithNode=new HashMap<>();

    /**
     *
     * @param grid
     * @return
     */
    public boolean checkValidGrid(Grid grid){

        List<Edge> list =grid.getEdges();

        for (int i=0;i<list.size();i++){
            //checking for valide data for all the inputs of the graph
            if (Character.isWhitespace(list.get(i).getStartPoint()) || (list.get(i).getEndPoint() == null) || list.get(i).getL().size()!=list.get(i).getS().size() || list.get(i).getEndPoint().size()!=list.get(i).getL().size()){
                    return false;
            }
        }
        return true;
    }

    /**
     *
     * @param webDataModel
     * @return  Grid of shortestPath
     */
    public List<Character> getShortestPath(WebDataModel webDataModel){
          Grid grid=webDataModel.getGrid();
          char start=webDataModel.getStartPoint();
          char end =webDataModel.getEndPoint();
          List<Edge> edges=grid.getEdges();
          int index=Integer.MAX_VALUE;

          Map<Character,Boolean> visitedMap= new HashMap<>();
          Map<Character,Double> dist=new HashMap<>();
          //
        for (int i=0;i<edges.size();i++){
              visitedMap.put(edges.get(i).getStartPoint(),false);
              indexMapWithNode.put(edges.get(i).getStartPoint(),i);
              dist.put(edges.get(i).getStartPoint(),Double.MAX_VALUE);
              if(edges.get(i).getStartPoint()==start){
                  index=i;
              }
          }
          if (index==Integer.MAX_VALUE){
              System.out.println("invalid start point");
              return null;
          }

          Queue<Character> tempEdges = new LinkedList<>();
          //map to store optimal route
          Map<Character,Character> parentNode = new HashMap<>();

          tempEdges.add(edges.get(index).getStartPoint());

          dist.put(edges.get(index).getStartPoint(), (double) 0);

          while (!tempEdges.isEmpty()){

              char tempChar=tempEdges.remove();
              visitedMap.put(tempChar,true);
              int ind=indexMapWithNode.get(tempChar);
              if (end==tempChar){
                  char temp=end;
                 /* Grid shortestPath=new Grid();
                  List<Edge> list=new ArrayList<>();*/
                  List<Character> result=new ArrayList<>();
                 // Edge edgeFinal=new Edge();
                  result.add(temp);

                  while(parentNode.get(temp)!=start){
                      /*Edge edge=new Edge();
                      edge.setStartPoint(temp);
                      edge.setEndPoint(Collections.singletonList(parentNode.get(temp)));
                      list.add(edge);*/
                      temp=parentNode.get(temp);
                      result.add(temp);
                  }
                  result.add(start);
                  Collections.reverse(result);
                  for (int i=0;i<result.size();i++){
                      if(i!=result.size()-1)
                      System.out.print(result.get(i)+"->");
                      else
                      System.out.print(result.get(i));
                  }
                  //edgeFinal.setStartPoint(temp);
                 // edgeFinal.setEndPoint(Collections.singletonList(parentNode.get(temp)));
                  //list.add(edgeFinal);
                  //shortestPathGrid
                ///  shortestPath.setEdges(list);
                  return  result;
              }

              for (Character character:edges.get(ind).getEndPoint()) {

                  if (!visitedMap.get(character) && (dist.get(character) > dist.get(tempChar) + edges.get(ind).getWeight().get(character))) {
                      tempEdges.add(character);
                      dist.put(character, dist.get(tempChar) + edges.get(ind).getWeight().get(character));
                      tempEdges.add(character);
                      parentNode.put(character, tempChar);
                  }
              }
          }
      return null;

    }
}
