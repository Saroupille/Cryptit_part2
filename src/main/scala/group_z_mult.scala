class Zmult (p:Int) extends Group {
  type E = Int
  val unit=1
  val generator=p-1
  val max=p
  def combines(a:E, b:E) : E = {
    return (a*b)%max
  }
}
