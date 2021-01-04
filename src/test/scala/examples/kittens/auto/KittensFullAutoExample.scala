package examples.kittens.auto

import cats.implicits._
import examples.Example

case class Usd(value: Double) extends AnyVal
case class CatalogItem(value: String) extends AnyVal
case class ShoppingCart(items: List[CatalogItem], totalPrice: Usd)

class KittensFullAutoExample extends Example {
  "ShoppingCart" should "combine with full-auto derived Semigroup instances" in {
    import cats.derived.auto.semigroup._

    ShoppingCart(List(CatalogItem("Shirt")), Usd(20)) combine
      ShoppingCart(List(CatalogItem("Shoes")), Usd(50)) shouldBe
      ShoppingCart(List(CatalogItem("Shirt"), CatalogItem("Shoes")), Usd(70))
  }
}
