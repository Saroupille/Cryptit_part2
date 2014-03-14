trait CryptoSystem {
  def encrypt(msg:String, pub:PublicKey, rdm:Int): String
  def decrypt(msg:String, priv: PrivateKey): String
}
