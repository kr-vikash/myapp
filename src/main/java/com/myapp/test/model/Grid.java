package com.myapp.test.model;

import java.util.List;

public class Grid {

   private int id;
   private List<Edge> edges;

   public void setEdges(List<Edge> edges) {
      this.edges = edges;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public List<Edge> getEdges() {
      return edges;
   }
}
