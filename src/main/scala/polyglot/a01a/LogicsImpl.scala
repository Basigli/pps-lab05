package polyglot.a01a

import polyglot.a01a.Logics
import polyglot.a01a.Logics.Result
import util.Sequences.*

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:
  private var boatCoordinates: Sequence[(Int, Int)] = Sequence.empty
  randomizeBoat()



  private def randomizeBoat(): Unit =
    val rand = scala.util.Random
    val initialCell = (rand.nextInt(size -1), rand.nextInt(size -1))  // for instance (2, 2)   boat = 4
    // choose between a random direction (left or right) ?





  def hit(row: Int, col: Int) =
    Result.HIT