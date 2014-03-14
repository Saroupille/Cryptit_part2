class Zadd[Int] (n:Int) {
  val unit=0
  val generator=1
  val max=n
  override combines(a:Int, b:Int) {
    return (a+b)%max
  }
}
