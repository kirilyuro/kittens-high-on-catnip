package examples.basic

import cats.Semigroup
import cats.implicits._
import examples.Example

case class Usd(value: Double) extends AnyVal
case class CatalogItem(value: String) extends AnyVal
case class ShoppingCart(items: List[CatalogItem], totalPrice: Usd)

class BasicExample extends Example {
  "ShoppingCart" should "combine with explicit Semigroup instances" in {
    implicit val usdSemigroup: Semigroup[Usd] =
      (x: Usd, y: Usd) =>
        Usd(x.value |+| y.value)

    implicit val shoppingCartSemigroup: Semigroup[ShoppingCart] =
      (x: ShoppingCart, y: ShoppingCart) =>
        ShoppingCart(x.items |+| y.items, x.totalPrice |+| y.totalPrice)

    ShoppingCart(List(CatalogItem("Shirt")), Usd(20)) combine
      ShoppingCart(List(CatalogItem("Shoes")), Usd(50)) shouldBe
      ShoppingCart(List(CatalogItem("Shirt"), CatalogItem("Shoes")), Usd(70))
  }
}
