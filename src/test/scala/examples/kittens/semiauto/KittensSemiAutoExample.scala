package examples.kittens.semiauto

import cats.{Semigroup, derived}
import cats.implicits._
import examples.Example

case class Usd(value: Double) extends AnyVal
case class CatalogItem(value: String) extends AnyVal
case class ShoppingCart(items: List[CatalogItem], totalPrice: Usd)

class KittensSemiAutoExample extends Example {
  "ShoppingCart" should "combine with semi-auto derived Semigroup instances" in {
    implicit val usdSemigroup: Semigroup[Usd] = {
      import derived.auto.semigroup._
      derived.semiauto.semigroup
    }

    implicit val shoppingCartSemigroup: Semigroup[ShoppingCart] = {
      import derived.auto.semigroup._
      derived.semiauto.semigroup
    }

    ShoppingCart(List(CatalogItem("Shirt")), Usd(20)) combine
      ShoppingCart(List(CatalogItem("Shoes")), Usd(50)) shouldBe
      ShoppingCart(List(CatalogItem("Shirt"), CatalogItem("Shoes")), Usd(70))
  }
}
