package polyglot.a05b

import polyglot.a05b.Logics
import util.Sequences.*

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:
  private var cellsWithElement: Sequence[(Int, Int)] = Sequence.empty
  initialRandomCell()
  private var step = 1

  private def initialRandomCell(): Unit =
    val rand = scala.util.Random
    val initialCell = (rand.between(1, size - 2), rand.between(1, size - 2))
    cellsWithElement = Sequence.Cons(initialCell, cellsWithElement)

  override def tick(): Unit =
    val initialCell = cellsWithElement.head.orElse((0, 0))
    val right = (initialCell._1 + step, initialCell._2)
    val left = (initialCell._1 - step, initialCell._2)
    val up = (initialCell._1, initialCell._2 + step)
    val down = (initialCell._1, initialCell._2 - step)
    val upperRight = (initialCell._1 + step, initialCell._2 + step)
    val upperLeft = (initialCell._1 - step, initialCell._2 + step)
    val lowerRight = (initialCell._1 + step, initialCell._2 - step)
    val lowerLeft = (initialCell._1 - step, initialCell._2 - step)
    cellsWithElement = cellsWithElement.concat(Sequence[(Int, Int)](right, left, up, down, upperRight, upperLeft, lowerRight, lowerLeft))
    step += 1

  override def isOver: Boolean =
    !cellsWithElement.find((x, y) => x == size || y == size || x == -1 || y == -1).isEmpty

  override def hasElement(x: Int, y: Int): Boolean =
    cellsWithElement.contains((x, y))
