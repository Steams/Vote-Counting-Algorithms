package com.steams.voting

import com.steams.voting.algorithms.Coombs.{Ranking,method => coombs_method}


object Main extends App {
  val candidates = List("Memphis","Nashville","Chattanooga","Knoxville")

  val rankings =
    List.fill(42)(Ranking(List(candidates(0),candidates(1),candidates(2),candidates(3)))) ++
    List.fill(26)(Ranking(List(candidates(1),candidates(2),candidates(3),candidates(0)))) ++
    List.fill(15)(Ranking(List(candidates(2),candidates(3),candidates(1),candidates(0)))) ++
    List.fill(17)(Ranking(List(candidates(3),candidates(2),candidates(1),candidates(0))))
  //   List(
  //    Ranking(List(5,4,3,2,1))
  //   ,Ranking(List(1,3,5,4,2))
  //   ,Ranking(List(3,2,5,4,1))
  //   ,Ranking(List(1,5,4,3,2))
  //   ,Ranking(List(3,5,4,1,2))
  //   ,Ranking(List(2,5,1,4,3))
  //   ,Ranking(List(3,5,1,2,4))
  //   ,Ranking(List(4,1,3,5,2))
  //   ,Ranking(List(4,3,2,5,1))
  //   ,Ranking(List(1,4,3,2,5))
  // )
 println("Coombs Method: Winning candidate [ "+coombs_method.run(candidates, rankings)+" ] !!")
}

