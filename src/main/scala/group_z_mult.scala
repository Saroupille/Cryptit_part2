class Zmult[Int] (p:Int) {
  val unit=1
  val generator=p-1
  val max=p
  override combines(a:Int, b:Int) {
    return (a*b)%max
  }
}
