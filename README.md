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
candidate [Memphis] First : 42 Last : 58
candidate [Nashville] First : 26 Last : 0
candidate [Chattanooga] First : 15 Last : 0
candidate [Knoxville] First : 17 Last : 42
Most last place votes candidate [Memphis]
candidate [Nashville] First : 68 Last : 32
candidate [Chattanooga] First : 15 Last : 0
candidate [Knoxville] First : 17 Last : 68
Most last place votes candidate [Knoxville]
candidate [Nashville] First : 68 Last : 32
candidate [Chattanooga] First : 32 Last : 68
Most last place votes candidate [Chattanooga]
Coombs Method: Winning candidate [ Nashville ] !!

```
