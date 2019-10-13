package au.id.tmm.probability.measure.cats

import au.id.tmm.probability.measure.RationalProbability
import cats.kernel.{Hash, Order}

object RationalProbabilityOrder extends Order[RationalProbability] with Hash[RationalProbability] {
  private val ordering: Ordering[RationalProbability] = RationalProbability.fractionalInstance

  override def compare(x: RationalProbability, y: RationalProbability): Int = ordering.compare(x, y)
  override def hash(x: RationalProbability): Int                            = x.hashCode()
}
