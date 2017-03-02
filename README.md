# Vote-Counting-Algorithms
Implementations of Vote counting algorithms intended to be integrated into the Agora project. https://www.gitlab.com/aossie/Agora

### Currently implemented methods

##### Coomb's Method https://en.wikipedia.org/wiki/Coombs%27_method
Running the Example from the Wikipedia page produces the correct output:
```scala

  import com.steams.voting.algorithms.Coombs.{Ranking,method => coombs_method}

  val candidates = List("Memphis","Nashville","Chattanooga","Knoxville")

  val rankings =
    List.fill(42)(Ranking(List(candidates(0),candidates(1),candidates(2),candidates(3)))) ++
    List.fill(26)(Ranking(List(candidates(1),candidates(2),candidates(3),candidates(0)))) ++
    List.fill(15)(Ranking(List(candidates(2),candidates(3),candidates(1),candidates(0)))) ++
    List.fill(17)(Ranking(List(candidates(3),candidates(2),candidates(1),candidates(0))))

 println("Coombs Method: Winning candidate [ "+coombs_method.run(candidates, rankings)+" ] !!")

```
Results in 
```
[Memphis] First : 42 Last : 58
[Nashville] First : 26 Last : 0
[Chattanooga] First : 15 Last : 0
[Knoxville] First : 17 Last : 42
Most last place votes candidate [Memphis]
[Nashville] First : 68 Last : 32
[Chattanooga] First : 15 Last : 0
[Knoxville] First : 17 Last : 68
Candidate [ Nashville ] has majority favor
Coombs Method: Winning candidate [ Nashville ] !!

```
