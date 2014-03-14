class Zadd (n:Int) extends Group {
  type E = Int
  val unit=0
  val generator=1
  val max=n
  def combines(a:E, b:E) : E = {
    return ((a+b)%max)
  }
}
