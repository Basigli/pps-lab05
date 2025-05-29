package polyglot.a01a

import polyglot.a01a.Logics
import polyglot.a01a.Logics.Result
import util.Sequences.*

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:
  private var boatCoordinates: Sequence[(Int, Int)] = Sequence.empty
  randomizeBoat()
  private var attempts = 5
  private var hitCounter = 0

  private def randomizeBoat(): Unit =
    val rand = scala.util.Random
    val initialRow = rand.nextInt(size -1)  // for instance (2, 2)   boat = 4
    var offset = rand.nextInt(size - 1 - boat)

    for column <- 0 until boat do
      boatCoordinates = Sequence.Cons((initialRow, column), boatCoordinates)





  def hit(row: Int, col: Int) = {
    if (boatCoordinates.contains((row, col))) {
      hitCounter = hitCounter + 1
      if (hitCounter == boat) {
        Result.WON
      } else {
        Result.HIT
      }
    } else {
      attempts = attempts - 1
      println("attempts " + attempts)
      if (attempts == 0) {
        Result.LOST
      } else {
        Result.MISS
      }
    }
  }

