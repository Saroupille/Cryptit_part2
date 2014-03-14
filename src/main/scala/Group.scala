trait Group[E] {
  val unit : E
  val generator : E
  def times (e1: E, e2: E): E
  def exp (e: E, n: Int): E = {
  }
}
