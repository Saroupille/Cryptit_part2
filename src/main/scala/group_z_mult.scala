class Zmult (p:BigInt) extends Group[BigInt] {
  type E = BigInt
  val unit=BigInt(1)
  val generator=p-1
  val order=p

  def toString(e : E) : String = {
  	e.toString
  }

  def fromString(s : String) : E = {
  	BigInt(s)
  }

  def combines(a:E, b:E) : E = {
    return (a*b)%order
  }

  def toBigInt(e : E) : BigInt = {
  	return e
  }

  def fromBigInt(n : BigInt) : E = {
  	return n % (order - 1) + 1
  }
}
