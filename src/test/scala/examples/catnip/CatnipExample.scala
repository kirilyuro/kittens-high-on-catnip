package examples.catnip

import cats.Semigroup
import cats.implicits._
import examples.Example
import io.scalaland.catnip.Semi

@Semi(Semigroup) case class Usd(value: Double) extends AnyVal
@Semi(Semigroup) case class CatalogItem(value: String) extends AnyVal
@Semi(Semigroup) case class ShoppingCart(items: List[CatalogItem], totalPrice: Usd)

class CatnipExample extends Example {
  "ShoppingCart" should "combine with Semigroup instances from catnip annotations" in {
    ShoppingCart(List(CatalogItem("Shirt")), Usd(20)) combine
      ShoppingCart(List(CatalogItem("Shoes")), Usd(50)) shouldBe
      ShoppingCart(List(CatalogItem("Shirt"), CatalogItem("Shoes")), Usd(70))
  }
}
