package au.id.tmm.probability.distribution.stochastic.testing

import au.id.tmm.probability.distribution.stochastic.ProbabilityDistribution
import au.id.tmm.probability.distribution.stochastic.apache.poisson
import au.id.tmm.utilities.testing.syntax._
import org.scalactic.Equality
import org.scalatest.tagobjects.Retryable
import org.scalatest.{FlatSpec, Outcome, Retries}

class DiscreteFrequenciesEqualitySpec extends FlatSpec with Retries {

  override def withFixture(test: NoArgTest): Outcome =
    if (isRetryable(test))
      withRetry { super.withFixture(test) } else
      super.withFixture(test)

  "the discrete frequencies equality" should "mark two poisson distributions as equal" taggedAs (Retryable) in {
    implicit val equality: Equality[ProbabilityDistribution[Int]] =
      DiscreteFrequenciesEquality[Int](relativeErrorThreshold = 0.05)

    (0 to 100).foreach { _ =>
      assert(poisson(1).get === poisson(1).get)
    }
  }

}
