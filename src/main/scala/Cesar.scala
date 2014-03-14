class CryptoCesar extends CryptoVigenere {
	override def generateKeys : (VigenerePublicKey, VigenerePrivateKey) = {
		(new VigenerePublicKey((10 .toChar).toString), new VigenerePrivateKey((10 .toChar).toString));
	}
}