trait Group[E] {
  val unit : E
  val generator : E
  def times (e1: E, e2: E): E
  def exp (e: E, n: Int): E = {
    if(n==0)
      return unit
    else if(n==1)
      return e
    else if(n%2==0)
      return exp(times(e,e), n/2)
    else
      return times(e,exp(times(e,e), (n-1)/2))
  }
}
