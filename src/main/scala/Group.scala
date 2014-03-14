abstract class Group[E] {
  val unit : E
  val generator : E
  abstract def combines(e1: E, e2: E): E
  def exp (e: E, n: Int): E = {
    if(n==0)
      return unit
    else if(n==1)
      return e
    else if(n%2==0)
      return exp(combines(e,e), n/2)
    else
      return times(e,exp(combines(e,e), (n-1)/2))
  }
}
