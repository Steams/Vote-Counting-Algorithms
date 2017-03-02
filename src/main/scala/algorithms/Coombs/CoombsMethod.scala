package com.steams.voting.algorithms.Coombs

import scala.collection.mutable.{Map => mut_Map}

case class Ranking(val candidates : List[String]){

  def currentFavorite : String = candidates(0)
  def leastFavorite : String = candidates(candidates.length - 1)
}

object method {
  type Candidate = String

  def run( candidates : List[Candidate], rankings : List[Ranking] ) : Candidate = {

    val firstPlaceVotes = mut_Map[Candidate,Int]()
    val lastPlaceVotes = mut_Map[Candidate,Int]()

    for(x <- candidates) {
      firstPlaceVotes(x) = 0
      lastPlaceVotes(x) = 0
    }

    // tally the votes of the favorite and least favorite candidate on each ballot
    for(ballot <- rankings){
      // println(ballot.candidates)
      firstPlaceVotes(ballot.currentFavorite) += 1
      lastPlaceVotes(ballot.leastFavorite) += 1
    }

    for(candidate <- candidates ){
      println("["+candidate+"] First : "+firstPlaceVotes(candidate)+" Last : "+lastPlaceVotes(candidate))
    }

    val potential_majority : (String,Int) = firstPlaceVotes.max

    //check for majority favorite
    if(potential_majority._2 > (rankings.length /2)) {
      println("Candidate [ " + potential_majority._1 + " ] has majority favor")
      return firstPlaceVotes.max._1
    }

    // search for the most frequently least favorite candidate
    //find Max in lastplaceVotes
    //NOTE : this doesnt account for ties right now
    val last : Candidate = lastPlaceVotes.maxBy{ x : (String,Int) => x._2}._1 //get the name of the candidate with the hights tally of last place votes

    println("Most last place votes candidate [ "+last+" ]")

    //filter out the losing candidate
    println("Eliminating [ "+last+" ]")
    val newCandidates = candidates.filter{ _ != last }

    //if only one candidate remains, they are the winner
    if (newCandidates.length == 1){
      return newCandidates.head
    }

    //otherwise we redistribute votes and run a next round
    //remove loser from each ranking to produce a new ranking
    println("Redistributing Votes")
    val newRankings = for (ballot <- rankings)
                      yield {
                        Ranking(ballot.candidates.filter( _ != last ))
                      }

    return run(newCandidates,newRankings)
  }
}
